package org.opennaas.extensions.vnmapper.capability.vnmapping;

/*
 * #%L
 * OpenNaaS :: VNMapper Resource
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

import org.opennaas.core.resources.capability.CapabilityException;
import org.opennaas.core.resources.capability.ICapability;
import org.opennaas.extensions.vnmapper.VNTRequest;

/**
 * 
 * @author Elisabeth Rigol
 * @author Adrian Rosello
 * 
 */
public interface IVNMappingCapability extends ICapability {

	/**
	 * @return
	 * @throws CapabilityException
	 */
	public VNMapperOutput mapVN(String networkResourceId, VNTRequest request) throws CapabilityException;

}
