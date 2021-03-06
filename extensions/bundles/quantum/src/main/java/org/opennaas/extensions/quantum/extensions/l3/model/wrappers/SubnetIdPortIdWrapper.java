package org.opennaas.extensions.quantum.extensions.l3.model.wrappers;

/*
 * #%L
 * OpenNaaS :: Quantum
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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Add Interface Quantum L3 Extension Message Wrapper.<br/>
 * Designed to store Quantum L3 Extension request or response.<br/>
 * Based on <a href="http://docs.openstack.org/api/openstack-network/2.0/content/router_add_interface.html">Openstack Networking API v2.0 L3
 * Extension.</a>
 * 
 * @author Julio Carlos Barrera
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SubnetIdPortIdWrapper {

	private String	subnet_id;
	private String	port_id;

	public String getSubnet_id() {
		return subnet_id;
	}

	public void setSubnet_id(String subnet_id) {
		this.subnet_id = subnet_id;
	}

	public String getPort_id() {
		return port_id;
	}

	public void setPort_id(String port_id) {
		this.port_id = port_id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubnetIdPortIdWrapper other = (SubnetIdPortIdWrapper) obj;
		if (!subnet_id.equals(other.getSubnet_id()))
			return false;
		if (!port_id.equals(other.getPort_id()))
			return false;
		return true;
	}

}
