/**
 * This file was auto-generated by mofcomp -j version 1.0.0 on Wed Jan 12
 * 09:21:06 CET 2011.
 */

package org.opennaas.extensions.router.model;

/*
 * #%L
 * OpenNaaS :: CIM Model
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

import java.io.Serializable;

/**
 * This Class contains accessor and mutator methods for all properties defined in the CIM class SAPSAPDependency as well as methods comparable to the
 * invokeMethods defined for this class. This Class implements the SAPSAPDependencyBean Interface. The CIM class SAPSAPDependency is described as
 * follows:
 * 
 * CIM_SAPSAPDependency is an association between one ServiceAccessPoint and another ServiceAccessPoint that indicates that the latter is required for
 * the former to utilize or connect with its Service. For example, to print to a network printer, local Print Access Points must utilize underlying
 * network-related SAPs, or ProtocolEndpoints, to send the print request.
 */
public class SAPSAPDependency extends Dependency implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1187256438166392002L;

	/**
	 * This constructor creates a SAPSAPDependencyBeanImpl Class which implements the SAPSAPDependencyBean Interface, and encapsulates the CIM class
	 * SAPSAPDependency in a Java Bean. The CIM class SAPSAPDependency is described as follows:
	 * 
	 * CIM_SAPSAPDependency is an association between one ServiceAccessPoint and another ServiceAccessPoint that indicates that the latter is required
	 * for the former to utilize or connect with its Service. For example, to print to a network printer, local Print Access Points must utilize
	 * underlying network-related SAPs, or ProtocolEndpoints, to send the print request.
	 */
	public SAPSAPDependency() {
	};

	/**
	 * This method create an Association of the type SAPSAPDependency between one ServiceAccessPoint object and ServiceAccessPoint object
	 */
	public static SAPSAPDependency link(ServiceAccessPoint
			antecedent, ServiceAccessPoint dependent) {

		return (SAPSAPDependency) Association.link(SAPSAPDependency.class, antecedent, dependent);
	}// link

} // Class SAPSAPDependency
