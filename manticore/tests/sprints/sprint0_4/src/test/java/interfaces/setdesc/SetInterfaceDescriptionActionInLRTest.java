package interfaces.setdesc;

import static org.openengsb.labs.paxexam.karaf.options.KarafDistributionOption.karafDistributionConfiguration;
import static org.openengsb.labs.paxexam.karaf.options.KarafDistributionOption.keepRuntimeFolder;

import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.CoreOptions.options;

import helpers.CheckParametersHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import junit.framework.Assert;
import net.i2cat.mantychore.actionsets.junos.ActionConstants;
import net.i2cat.mantychore.model.ComputerSystem;
import net.i2cat.mantychore.model.EthernetPort;
import net.i2cat.mantychore.model.LogicalPort;
import net.i2cat.nexus.tests.InitializerTestHelper;
import net.i2cat.nexus.tests.IntegrationTestsHelper;
import net.i2cat.nexus.tests.ResourceHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opennaas.core.resources.ILifecycle.State;
import org.opennaas.core.resources.IResource;
import org.opennaas.core.resources.IResourceManager;
import org.opennaas.core.resources.ResourceException;
import org.opennaas.core.resources.capability.CapabilityException;
import org.opennaas.core.resources.capability.ICapability;
import org.opennaas.core.resources.descriptor.ResourceDescriptor;
import org.opennaas.core.resources.helpers.ResourceDescriptorFactory;
import org.opennaas.core.resources.profile.IProfileManager;
import org.opennaas.core.resources.protocol.IProtocolManager;
import org.opennaas.core.resources.protocol.ProtocolException;
import org.opennaas.core.resources.protocol.ProtocolSessionContext;
import org.opennaas.core.resources.queue.QueueConstants;
import org.opennaas.core.resources.queue.QueueResponse;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.ExamReactorStrategy;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.ops4j.pax.exam.util.Filter;
import org.ops4j.pax.exam.spi.reactors.EagerSingleStagedReactorFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.blueprint.container.BlueprintContainer;

@RunWith(JUnit4TestRunner.class)
@ExamReactorStrategy(EagerSingleStagedReactorFactory.class)
public class SetInterfaceDescriptionActionInLRTest
{
	@Inject
	private BundleContext		bundleContext;

	@Inject
	private IResourceManager	resourceManager;

	@Inject
	private IProfileManager		profileManager;

	@Inject
	private IProtocolManager	protocolManager;

    @Inject
    @Filter("(osgi.blueprint.container.symbolicname=net.i2cat.mantychore.repository)")
    private BlueprintContainer routerService;

    @Inject
    @Filter("(osgi.blueprint.container.symbolicname=net.i2cat.mantychore.queuemanager)")
    private BlueprintContainer queueService;

    @Inject
    @Filter("(osgi.blueprint.container.symbolicname=net.i2cat.mantychore.capability.ip)")
    private BlueprintContainer ipService;

    @Inject
    @Filter("(osgi.blueprint.container.symbolicname=net.i2cat.mantychore.capability.chassis)")
    private BlueprintContainer chassisService;

	private boolean				isMock;
	private ResourceDescriptor	resourceDescriptor;
	private IResource			resource;
	private String				deviceID;
	private String				type;

	private String				LRName			= "cpe2";
	private String				interfaceName	= "fe-0/0/3.1";

	private IResource			LRresource;
	private EthernetPort		iface;

	@Configuration
	public static Option[] configuration() {
		return options(karafDistributionConfiguration()
					   .frameworkUrl(maven()
									 .groupId("net.i2cat.mantychore")
									 .artifactId("assembly")
									 .type("zip")
									 .classifier("bin")
									 .versionAsInProject())
					   .karafVersion("2.2.2")
					   .name("mantychore")
					   .unpackDirectory(new File("target/paxexam")),
					   keepRuntimeFolder());
	}

	public SetInterfaceDescriptionActionInLRTest() {
		this.type = "router";
		this.deviceID = "junos";
	}

	/**
	 * Prepare the resource to do the test
	 *
	 * @throws ResourceException
	 * @throws ProtocolException
	 *
	 */
	@Before
	public void setUp() throws ResourceException, ProtocolException {

		// Reset repository
		IResource[] toRemove = new IResource[resourceManager.listResources().size()];
		toRemove = resourceManager.listResources().toArray(toRemove);

		for (IResource resource : toRemove) {
			if (resource.getState().equals(State.ACTIVE))
				resourceManager.stopResource(resource.getResourceIdentifier());

			resourceManager.removeResource(resource.getResourceIdentifier());
		}

		List<String> capabilities = new ArrayList<String>();
		capabilities.add("chassis");
		capabilities.add("ipv4");
		capabilities.add("queue");
		resourceDescriptor = ResourceDescriptorFactory.newResourceDescriptor(deviceID, type, capabilities);
		resource = resourceManager.createResource(resourceDescriptor);
		createProtocolForResource(resource.getResourceIdentifier().getId());
		resourceManager.startResource(resource.getResourceIdentifier());

		int posChassis = InitializerTestHelper.containsCapability(resource, "chassis");
		if (posChassis == -1)
			Assert.fail("Could not get Chassis capability for given resource");
		ICapability chassisCapability = resource.getCapabilities().get(posChassis);

		if (!resource.getModel().getChildren().isEmpty()) {
			LRName = resource.getModel().getChildren().get(0);
		} else {
			// create LR
			chassisCapability.sendMessage(ActionConstants.CREATELOGICALROUTER, LRName);
			executeQueue(resource);
		}

		// add logicalIface in LR
		// remove it from parent
		EthernetPort ethernetPort = new EthernetPort();
		ethernetPort.setName(interfaceName);
		ethernetPort.setPortNumber(2);
		chassisCapability.sendMessage(ActionConstants.DELETESUBINTERFACE, ethernetPort);

		// put it in child
		EthernetPort ethernetPort2 = new EthernetPort();
		ethernetPort2.setName(ethernetPort.getName());
		ethernetPort2.setPortNumber(ethernetPort.getPortNumber());
		ethernetPort2.setElementName(LRName);
		chassisCapability.sendMessage(ActionConstants.CONFIGURESUBINTERFACE, ethernetPort2);
		executeQueue(resource);

		LRresource = resourceManager.getResource(resourceManager.getIdentifierFromResourceName("router", LRName));
		iface = ethernetPort;
	}

	/**
	 * Reset info for next tests
	 *
	 * @throws ResourceException
	 *
	 */
	@After
	public void tearDown() throws ResourceException {

		// delete created sub interface
		int posChassis = InitializerTestHelper.containsCapability(resource, "chassis");
		if (posChassis == -1)
			Assert.fail("Could not get Chassis capability for given resource");
		ICapability chassisCapability = resource.getCapabilities().get(posChassis);

		if (iface != null) {
			try {
				chassisCapability.sendMessage(ActionConstants.DELETESUBINTERFACE, iface);
			} catch (CapabilityException e) {
				Assert.fail("It was impossible to send message " + ActionConstants.DELETESUBINTERFACE + " : " + e.getMessage());
			}
		}

		// delete LR
		if (LRresource != null) {
			try {
				chassisCapability.sendMessage(ActionConstants.DELETELOGICALROUTER, LRName);
			} catch (CapabilityException e) {
				Assert.fail("It was impossible to send message " + ActionConstants.DELETELOGICALROUTER + " : " + e.getMessage());
			}
		}

		executeQueue(resource);

		// Reset repository
		IResource[] toRemove = new IResource[resourceManager.listResources().size()];
		toRemove = resourceManager.listResources().toArray(toRemove);

		for (IResource resource : toRemove) {
			if (resource.getState().equals(State.ACTIVE))
				resourceManager.stopResource(resource.getResourceIdentifier());

			resourceManager.removeResource(resource.getResourceIdentifier());
		}
	}

	@Test
	public void setInterfaceDescriptionActionInLRTest()
		throws CapabilityException, ResourceException
	{
		setSubInterfaceDescriptionTest();
		setInterfaceDescriptionTest();
	}

	/**
	 * Put related task
	 * */
	public void setSubInterfaceDescriptionTest()
		throws CapabilityException, ResourceException
	{
		/* send action */
		int posChassis = InitializerTestHelper.containsCapability(resource, "chassis");
		if (posChassis == -1)
			Assert.fail("Could not get Chassis capability for given resource");
		ICapability chassisCapability = resource.getCapabilities().get(posChassis);

		int posIpv4 = InitializerTestHelper.containsCapability(resource, "ipv4");
		if (posIpv4 == -1)
			Assert.fail("Could not get ipv4 capability for given resource");
		ICapability ipCapability = resource.getCapabilities().get(posIpv4);

		EthernetPort ethernetPort = new EthernetPort();
		ethernetPort.setName(iface.getName());
		ethernetPort.setPortNumber(iface.getPortNumber());
		ethernetPort.setDescription("Description for the setSubInterfaceDescription test");
		ethernetPort.setElementName(LRName);

		ipCapability.sendMessage(ActionConstants.SETINTERFACEDESCRIPTION, ethernetPort);

		/* execute action */
		executeQueue(resource);

		/* refresh model */
		chassisCapability.sendMessage(ActionConstants.GETCONFIG, ethernetPort);

		if (isMock)
			return;

		resourceManager.startResource(LRresource.getResourceIdentifier());

		/* check the update model, it is only possible to check it with a real router */
		int pos = CheckParametersHelper.containsSubInterface((ComputerSystem) LRresource.getModel(), ethernetPort);
		Assert.assertTrue(pos != -1);

		String desc = ((EthernetPort) ((ComputerSystem) LRresource.getModel()).getLogicalDevices().get(pos)).getDescription();
		Assert.assertTrue(desc.equals(ethernetPort.getDescription()));
	}

	/**
	 * Test the possibility to configure subinterfaces with an encapsulation
	 * */
	public void setInterfaceDescriptionTest()
		throws CapabilityException, ResourceException
	{
		/* send action */
		int posChassis = InitializerTestHelper.containsCapability(resource, "chassis");
		if (posChassis == -1)
			Assert.fail("Could not get Chassis capability for given resource");
		ICapability chassisCapability = resource.getCapabilities().get(posChassis);

		int posIpv4 = InitializerTestHelper.containsCapability(resource, "ipv4");
		if (posIpv4 == -1)
			Assert.fail("Could not get ipv4 capability for given resource");
		ICapability ipCapability = resource.getCapabilities().get(posIpv4);

		LogicalPort logicalPort = new LogicalPort();
		logicalPort.setName("fe-0/3/2");
		logicalPort.setDescription("Description for the setSubInterfaceDescription test");
		logicalPort.setElementName(LRName);

		ipCapability.sendMessage(ActionConstants.SETINTERFACEDESCRIPTION, logicalPort);

		/* execute action */
		executeQueue(resource);

		/* refresh model */
		chassisCapability.sendMessage(ActionConstants.GETCONFIG, logicalPort);

		if (isMock)
			return;

		resourceManager.startResource(LRresource.getResourceIdentifier());

		/* check the update model, it is only possible to check it with a real router */
		/* check the update model, it is only possible to check it with a real router */
		int pos = CheckParametersHelper.containsInterface((ComputerSystem) LRresource.getModel(), logicalPort);
		Assert.assertTrue(pos != -1);

		String desc = ((LogicalPort) ((ComputerSystem) LRresource.getModel()).getLogicalDevices().get(pos)).getDescription();
		Assert.assertTrue(desc.equals(logicalPort.getDescription()));
	}

	/**
	 * TODO This class has to be moved to the share helper
	 */
	private void createProtocolForResource(String resourceId) throws ProtocolException {
		ProtocolSessionContext context = ResourceHelper.newSessionContextNetconf();
		protocolManager.getProtocolSessionManagerWithContext(resourceId, context);

		isMock = false;
		if (context.getSessionParameters().containsKey(ProtocolSessionContext.PROTOCOL_URI)) {
			if (((String) context.getSessionParameters().get(ProtocolSessionContext.PROTOCOL_URI)).startsWith("mock")) {
				isMock = true;
			}
		}
	}

	private QueueResponse executeQueue(IResource resource) throws CapabilityException {
		/* execute action */
		int posQueue = InitializerTestHelper.containsCapability(resource, "queue");
		if (posQueue == -1)
			Assert.fail("Could not get Queue capability for given resource");
		ICapability queueCapability = resource.getCapabilities().get(posQueue);
		QueueResponse response = (QueueResponse) queueCapability.sendMessage(QueueConstants.EXECUTE, null);
		Assert.assertTrue(response.isOk());
		return response;
	}
}