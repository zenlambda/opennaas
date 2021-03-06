package org.opennaas.extensions.router.model.opticalSwitch;

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

import javax.xml.bind.annotation.XmlRootElement;

import org.opennaas.extensions.router.model.FCPort;
import org.opennaas.extensions.router.model.opticalSwitch.dwdm.proteus.cards.ProteusOpticalSwitchCard;

@XmlRootElement
public class FiberConnection {

	/* These parameters don't have to be complete, it is enough if they contain */
	/**
	 * A card with chassis and slot correctly setted up.
	 */
	ProteusOpticalSwitchCard	srcCard	= null;
	/**
	 * A card with chassis and slot correctly setted up.
	 */
	ProteusOpticalSwitchCard	dstCard	= null;

	/**
	 * A FCPort with portNumber correctly setted up.
	 */
	FCPort						srcPort	= null;
	/**
	 * A FCPort with portNumber correctly setted up.
	 */
	FCPort						dstPort	= null;

	/**
	 * A DWDMChannel with lambda correctly setted up.
	 */
	DWDMChannel					srcDWDMFiberChannel;
	/**
	 * A DWDMChannel with lambda correctly setted up.
	 */
	DWDMChannel					dstDWDMFiberChannel;

	public FiberConnection() {

	}

	public ProteusOpticalSwitchCard getSrcCard() {
		return srcCard;
	}

	public void setSrcCard(ProteusOpticalSwitchCard srcCard) {
		this.srcCard = srcCard;
	}

	public ProteusOpticalSwitchCard getDstCard() {
		return dstCard;
	}

	public void setDstCard(ProteusOpticalSwitchCard dstCard) {
		this.dstCard = dstCard;
	}

	public FCPort getSrcPort() {
		return srcPort;
	}

	public void setSrcPort(FCPort srcPort) {
		this.srcPort = srcPort;
	}

	public FCPort getDstPort() {
		return dstPort;
	}

	public void setDstPort(FCPort dstPort) {
		this.dstPort = dstPort;
	}

	public DWDMChannel getSrcFiberChannel() {
		return srcDWDMFiberChannel;
	}

	public void setSrcFiberChannel(DWDMChannel srcFiberChannel) {
		this.srcDWDMFiberChannel = srcFiberChannel;
	}

	public DWDMChannel getDstFiberChannel() {
		return dstDWDMFiberChannel;
	}

	public void setDstFiberChannel(DWDMChannel dstFiberChannel) {
		this.dstDWDMFiberChannel = dstFiberChannel;
	}

}
