package org.opennaas.extensions.pdu.capability.shell;

/*
 * #%L
 * OpenNaaS :: PDU Resource
 * %%
 * Copyright (C) 2007 - 2014 Fundació Privada i2CAT, Internet i Innovació a Catalunya
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.opennaas.core.resources.IResource;
import org.opennaas.core.resources.shell.GenericKarafCommand;
import org.opennaas.extensions.gim.model.load.MeasuredLoad;
import org.opennaas.extensions.pdu.capability.IPDUPowerMonitoringIDsCapability;

@Command(scope = "pdu", name = "getPowerMetrics", description = "Reads power metrics from specified port")
public class GetCurrentPowerMetricsCommand extends GenericKarafCommand {

	@Argument(index = 0, name = "resourceType:resourceName", description = "The resource id where given port is.", required = true, multiValued = false)
	private String		resourceId;

	@Argument(index = 1, name = "port", description = "Port to read metrics from", required = true, multiValued = false)
	private String		portId;

	private DateFormat	dateFormat	= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	@Override
	protected Object doExecute() throws Exception {

		printInitCommand("getPowerMetrics of port : " + portId + " in resource: " + resourceId);

		IResource resource = getResourceFromFriendlyName(resourceId);
		MeasuredLoad metrics = ((IPDUPowerMonitoringIDsCapability) resource.getCapabilityByInterface(IPDUPowerMonitoringIDsCapability.class))
				.getCurrentPowerMetrics(portId);
		printMetrics(metrics);

		printEndCommand();
		return null;

	}

	private void printMetrics(MeasuredLoad metrics) {
		String readTime = dateFormat.format(metrics.getReadingTime());
		printSymbol("Power Consumption Metrics for resource " + resourceId + " @ " + readTime + ":");
		printSymbol("Voltage: " + metrics.getVoltage() + " Volts");
		printSymbol("Current: " + metrics.getCurrent() + " Amps");
		printSymbol("Power: " + metrics.getPower() + " KW");
		printSymbol("Energy: " + metrics.getEnergy() + " KWh");
	}

}
