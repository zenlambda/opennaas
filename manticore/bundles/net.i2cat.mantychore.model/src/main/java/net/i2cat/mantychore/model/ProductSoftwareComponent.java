/**
 * This file was auto-generated by mofcomp -j version 1.0.0 on Wed Jan 12
 * 09:21:06 CET 2011.
 */

package net.i2cat.mantychore.model;

import java.io.*;

/**
 * This Class contains accessor and mutator methods for all properties defined in the CIM class ProductSoftwareComponent as well as methods comparable
 * to the invokeMethods defined for this class. This Class implements the ProductSoftwareComponentBean Interface. The CIM class
 * ProductSoftwareComponent is described as follows:
 * 
 * Indicates that the referenced SoftwareIdentity is acquired as part of a Product.
 */
public class ProductSoftwareComponent extends Component implements
		Serializable {

	/**
	 * This constructor creates a ProductSoftwareComponentBeanImpl Class which implements the ProductSoftwareComponentBean Interface, and encapsulates
	 * the CIM class ProductSoftwareComponent in a Java Bean. The CIM class ProductSoftwareComponent is described as follows:
	 * 
	 * Indicates that the referenced SoftwareIdentity is acquired as part of a Product.
	 */
	public ProductSoftwareComponent() {
	};

	/**
	 * This method create an Association of the type ProductSoftwareComponent between one Product object and SoftwareIdentity object
	 */
	public static ProductSoftwareComponent link(Product
			groupComponent, SoftwareIdentity partComponent) {

		return (ProductSoftwareComponent) Association.link(ProductSoftwareComponent.class, groupComponent, partComponent);
	}// link

} // Class ProductSoftwareComponent