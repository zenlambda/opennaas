/**
 * This file was auto-generated by mofcomp -j version 1.0.0 on Wed Jan 12
 * 09:21:06 CET 2011.
 */

package net.i2cat.mantychore.model;

import java.io.Serializable;

/**
 * This Class contains accessor and mutator methods for all properties defined in the CIM class RoutingPolicy as well as methods comparable to the
 * invokeMethods defined for this class. This Class implements the RoutingPolicyBean Interface. The CIM class RoutingPolicy is described as follows:
 * 
 * This class is used to implement routing policies. It aggregates a set of FilterLists, along with other appropriate constructs, into a unit. One of
 * the most important uses of this class is to change the routing policy by changing values of various attributes in a consistent manner. A
 * RoutingPolicy is weak to the network device (i.e., the ComputerSystem) that contains it. Hence, the ComputerSystem keys are propagated to this
 * class. Note that this class was defined before the Policy Model and hence is not positioned in that hierarchy. The class will be repositioned in a
 * later release of the Network Model.
 */
public class RoutingPolicy extends LogicalElement implements Serializable {

	/**
	 * This constructor creates a RoutingPolicyBeanImpl Class which implements the RoutingPolicyBean Interface, and encapsulates the CIM class
	 * RoutingPolicy in a Java Bean. The CIM class RoutingPolicy is described as follows:
	 * 
	 * This class is used to implement routing policies. It aggregates a set of FilterLists, along with other appropriate constructs, into a unit. One
	 * of the most important uses of this class is to change the routing policy by changing values of various attributes in a consistent manner. A
	 * RoutingPolicy is weak to the network device (i.e., the ComputerSystem) that contains it. Hence, the ComputerSystem keys are propagated to this
	 * class. Note that this class was defined before the Policy Model and hence is not positioned in that hierarchy. The class will be repositioned
	 * in a later release of the Network Model.
	 */
	public RoutingPolicy() {
	};

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property systemCreationClassName.
	 */
	private String	systemCreationClassName;

	/**
	 * This method returns the RoutingPolicy.systemCreationClassName property value. This property is described as follows:
	 * 
	 * The scoping ComputerSystem's CreationClassName.
	 * 
	 * @return String current systemCreationClassName property value
	 * @exception Exception
	 */
	public String getSystemCreationClassName() {

		return this.systemCreationClassName;
	} // getSystemCreationClassName

	/**
	 * This method sets the RoutingPolicy.systemCreationClassName property value. This property is described as follows:
	 * 
	 * The scoping ComputerSystem's CreationClassName.
	 * 
	 * @param String
	 *            new systemCreationClassName property value
	 * @exception Exception
	 */
	public void setSystemCreationClassName(String systemCreationClassName) {

		this.systemCreationClassName = systemCreationClassName;
	} // setSystemCreationClassName

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property systemName.
	 */
	private String	systemName;

	/**
	 * This method returns the RoutingPolicy.systemName property value. This property is described as follows:
	 * 
	 * The scoping ComputerSystem's Name.
	 * 
	 * @return String current systemName property value
	 * @exception Exception
	 */
	public String getSystemName() {

		return this.systemName;
	} // getSystemName

	/**
	 * This method sets the RoutingPolicy.systemName property value. This property is described as follows:
	 * 
	 * The scoping ComputerSystem's Name.
	 * 
	 * @param String
	 *            new systemName property value
	 * @exception Exception
	 */
	public void setSystemName(String systemName) {

		this.systemName = systemName;
	} // setSystemName

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property creationClassName.
	 */
	private String	creationClassName;

	/**
	 * This method returns the RoutingPolicy.creationClassName property value. This property is described as follows:
	 * 
	 * CreationClassName indicates the name of the class or the subclass used in the creation of an instance. When used with the other key properties
	 * of this class, this property allows all instances of this class and its subclasses to be uniquely identified.
	 * 
	 * @return String current creationClassName property value
	 * @exception Exception
	 */
	public String getCreationClassName() {

		return this.creationClassName;
	} // getCreationClassName

	/**
	 * This method sets the RoutingPolicy.creationClassName property value. This property is described as follows:
	 * 
	 * CreationClassName indicates the name of the class or the subclass used in the creation of an instance. When used with the other key properties
	 * of this class, this property allows all instances of this class and its subclasses to be uniquely identified.
	 * 
	 * @param String
	 *            new creationClassName property value
	 * @exception Exception
	 */
	public void setCreationClassName(String creationClassName) {

		this.creationClassName = creationClassName;
	} // setCreationClassName

	// /**
	// * The following constants are defined for use with the ValueMap/Values
	// * qualified property name.
	// */
	// private String name;
	/**
	 * This method returns the RoutingPolicy.name property value. This property is described as follows:
	 * 
	 * This is the name of the Routing Policy.
	 * 
	 * @return String current name property value
	 * @exception Exception
	 */
	@Override
	public String getName() {
		return super.getName();
	} // getName

	/**
	 * This method sets the RoutingPolicy.name property value. This property is described as follows:
	 * 
	 * This is the name of the Routing Policy.
	 * 
	 * @param String
	 *            new name property value
	 * @exception Exception
	 */
	@Override
	public void setName(String name) {
		super.setName(name);
	} // setName

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property Action.
	 */

	public enum Action {
		ACCEPT_AS_IS,
		ACCEPT_WITH_PROTOCOL_ATTRIBUTE_CHANGES,
		ACCEPT_AND_REMARK_PACKET,
		ACCEPT_WITH_PROTOCOL_ATTRIBUTE_CHANGES_AND_REMARK,
		ACCEPT_WITH_OTHER_ACTION,
		ACCEPT_WITH_PROTOCOL_ATTRIBUTE_CHANGES_AND_OTHER_ACTION,
		ACCEPT_WITH_REMARK_AND_OTHER_ACTION,
		ACCEPT_WITH_PROTOCOL_ATTRIBUTE_CHANGES_REMARK_AND_OTHER_ACTION,
		DENY
	}

	private Action	action;

	/**
	 * This method returns the RoutingPolicy.action property value. This property is described as follows:
	 * 
	 * This defines the type of action that will be performed if the match conditions of the policy are met. The match conditions are defined by the
	 * associated ListsIn RoutingPolicy. There are essentially three choices: forward the traffic unmodified, forward the traffic but modify either
	 * the attributes describing the route and/or other attributes that define how to condition the traffic (e.g., its ToS byte settings), or prevent
	 * the traffic from being forwarded.
	 * 
	 * @return int current action property value
	 * @exception Exception
	 */
	public Action getAction() {

		return this.action;
	} // getAction

	/**
	 * This method sets the RoutingPolicy.action property value. This property is described as follows:
	 * 
	 * This defines the type of action that will be performed if the match conditions of the policy are met. The match conditions are defined by the
	 * associated ListsIn RoutingPolicy. There are essentially three choices: forward the traffic unmodified, forward the traffic but modify either
	 * the attributes describing the route and/or other attributes that define how to condition the traffic (e.g., its ToS byte settings), or prevent
	 * the traffic from being forwarded.
	 * 
	 * @param int new action property value
	 * @exception Exception
	 */
	public void setAction(Action action) {

		this.action = action;
	} // setAction

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property AttributeAction.
	 */

	public enum AttributeAction {
		REPLACE,
		PREPEND,
		APPEND
	}

	private AttributeAction	attributeAction;

	/**
	 * This method returns the RoutingPolicy.attributeAction property value. This property is described as follows:
	 * 
	 * This controls whether protocol-specific attributes replace, get prepended, or get appended to their existing values.
	 * 
	 * @return int current attributeAction property value
	 * @exception Exception
	 */
	public AttributeAction getAttributeAction() {

		return this.attributeAction;
	} // getAttributeAction

	/**
	 * This method sets the RoutingPolicy.attributeAction property value. This property is described as follows:
	 * 
	 * This controls whether protocol-specific attributes replace, get prepended, or get appended to their existing values.
	 * 
	 * @param int new attributeAction property value
	 * @exception Exception
	 */
	public void setAttributeAction(AttributeAction attributeAction) {

		this.attributeAction = attributeAction;
	} // setAttributeAction

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property BGPAction.
	 */

	public enum BGPAction {
		ORIGIN,
		AS_PATH,
		NEXT_HOP,
		MULTI_EXIT_DISC,
		LOCAL_PREF,
		ATOMIC_AGGREGATE,
		AGGREGATOR,
		COMMUNITY,
		ORIGINATOR_ID,
		CLUSTER_LIST
	}

	private BGPAction	bGPAction;

	/**
	 * This method returns the RoutingPolicy.bGPAction property value. This property is described as follows:
	 * 
	 * This defines one or more BGP-specific attributes that should be used to modify this routing update.
	 * 
	 * @return int current bGPAction property value
	 * @exception Exception
	 */
	public BGPAction getBGPAction() {

		return this.bGPAction;
	} // getBGPAction

	/**
	 * This method sets the RoutingPolicy.bGPAction property value. This property is described as follows:
	 * 
	 * This defines one or more BGP-specific attributes that should be used to modify this routing update.
	 * 
	 * @param int new bGPAction property value
	 * @exception Exception
	 */
	public void setBGPAction(BGPAction bGPAction) {

		this.bGPAction = bGPAction;
	} // setBGPAction

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property bGPValue.
	 */
	private String	bGPValue;

	/**
	 * This method returns the RoutingPolicy.bGPValue property value. This property is described as follows:
	 * 
	 * The value for the corresponding BGPAction.
	 * 
	 * @return String current bGPValue property value
	 * @exception Exception
	 */
	public String getBGPValue() {

		return this.bGPValue;
	} // getBGPValue

	/**
	 * This method sets the RoutingPolicy.bGPValue property value. This property is described as follows:
	 * 
	 * The value for the corresponding BGPAction.
	 * 
	 * @param String
	 *            new bGPValue property value
	 * @exception Exception
	 */
	public void setBGPValue(String bGPValue) {

		this.bGPValue = bGPValue;
	} // setBGPValue

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property RemarkAction.
	 */

	public enum RemarkAction {
		CHANGE_DSCP,
		CHANGE_TOS,
		CHANGE_802_1Q_VALUE,
		CHANGE_CIR,
		CHANGE_CBR,
		CHANGE_ABR,
		CHANGE_VBR
	}

	private RemarkAction	remarkAction;

	/**
	 * This method returns the RoutingPolicy.remarkAction property value. This property is described as follows:
	 * 
	 * This defines a remarking action for this traffic.
	 * 
	 * @return int current remarkAction property value
	 * @exception Exception
	 */
	public RemarkAction getRemarkAction() {

		return this.remarkAction;
	} // getRemarkAction

	/**
	 * This method sets the RoutingPolicy.remarkAction property value. This property is described as follows:
	 * 
	 * This defines a remarking action for this traffic.
	 * 
	 * @param int new remarkAction property value
	 * @exception Exception
	 */
	public void setRemarkAction(RemarkAction remarkAction) {

		this.remarkAction = remarkAction;
	} // setRemarkAction

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property remarkValue.
	 */
	private String	remarkValue;

	/**
	 * This method returns the RoutingPolicy.remarkValue property value. This property is described as follows:
	 * 
	 * The value for the corresponding RemarkAction.
	 * 
	 * @return String current remarkValue property value
	 * @exception Exception
	 */
	public String getRemarkValue() {

		return this.remarkValue;
	} // getRemarkValue

	/**
	 * This method sets the RoutingPolicy.remarkValue property value. This property is described as follows:
	 * 
	 * The value for the corresponding RemarkAction.
	 * 
	 * @param String
	 *            new remarkValue property value
	 * @exception Exception
	 */
	public void setRemarkValue(String remarkValue) {

		this.remarkValue = remarkValue;
	} // setRemarkValue

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property ConditioningAction.
	 */

	public enum ConditioningAction {
		OTHER,
		INPUT_FLOW_POLICING,
		OUTPUT_FLOW_POLICING,
		INPUT_AGGREGATE_POLICING,
		OUTPUT_AGGREGATE_POLICING,
		POLICE_BY_MARKING_DOWN,
		POLICE_BY_DROPPING_DOWN
	}

	private ConditioningAction	conditioningAction;

	/**
	 * This method returns the RoutingPolicy.conditioningAction property value. This property is described as follows:
	 * 
	 * This defines another action to be taken for this traffic.
	 * 
	 * @return int current conditioningAction property value
	 * @exception Exception
	 */
	public ConditioningAction getConditioningAction() {

		return this.conditioningAction;
	} // getConditioningAction

	/**
	 * This method sets the RoutingPolicy.conditioningAction property value. This property is described as follows:
	 * 
	 * This defines another action to be taken for this traffic.
	 * 
	 * @param int new conditioningAction property value
	 * @exception Exception
	 */
	public void setConditioningAction(ConditioningAction
			conditioningAction) {

		this.conditioningAction = conditioningAction;
	} // setConditioningAction

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property otherConditioningAction.
	 */
	private String	otherConditioningAction;

	/**
	 * This method returns the RoutingPolicy.otherConditioningAction property value. This property is described as follows:
	 * 
	 * If the value of the ConditioningAction property of this class is 1, this contains an application-specific type of conditioning that is to be
	 * performed. Otherwise, if the ConditioningAction property is any other value, the value of this property should be NULL.
	 * 
	 * @return String current otherConditioningAction property value
	 * @exception Exception
	 */
	public String getOtherConditioningAction() {

		return this.otherConditioningAction;
	} // getOtherConditioningAction

	/**
	 * This method sets the RoutingPolicy.otherConditioningAction property value. This property is described as follows:
	 * 
	 * If the value of the ConditioningAction property of this class is 1, this contains an application-specific type of conditioning that is to be
	 * performed. Otherwise, if the ConditioningAction property is any other value, the value of this property should be NULL.
	 * 
	 * @param String
	 *            new otherConditioningAction property value
	 * @exception Exception
	 */
	public void setOtherConditioningAction(String otherConditioningAction) {

		this.otherConditioningAction = otherConditioningAction;
	} // setOtherConditioningAction

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property conditioningValue.
	 */
	private String	conditioningValue;

	/**
	 * This method returns the RoutingPolicy.conditioningValue property value. This property is described as follows:
	 * 
	 * The value for the corresponding ConditioningAction, if appropriate.
	 * 
	 * @return String current conditioningValue property value
	 * @exception Exception
	 */
	public String getConditioningValue() {

		return this.conditioningValue;
	} // getConditioningValue

	/**
	 * This method sets the RoutingPolicy.conditioningValue property value. This property is described as follows:
	 * 
	 * The value for the corresponding ConditioningAction, if appropriate.
	 * 
	 * @param String
	 *            new conditioningValue property value
	 * @exception Exception
	 */
	public void setConditioningValue(String conditioningValue) {

		this.conditioningValue = conditioningValue;
	} // setConditioningValue

} // Class RoutingPolicy