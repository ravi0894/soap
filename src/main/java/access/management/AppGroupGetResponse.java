//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.20 at 03:58:03 PM IST 
//


package access.management;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AppGroup" type="{http://access/management}AppGroupResponse"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "appGroup"
})
@XmlRootElement(name = "AppGroupGetResponse")
public class AppGroupGetResponse {

    @XmlElement(name = "AppGroup", required = true)
    protected AppGroupResponse appGroup;

    /**
     * Gets the value of the appGroup property.
     * 
     * @return
     *     possible object is
     *     {@link AppGroupResponse }
     *     
     */
    public AppGroupResponse getAppGroup() {
        return appGroup;
    }

    /**
     * Sets the value of the appGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppGroupResponse }
     *     
     */
    public void setAppGroup(AppGroupResponse value) {
        this.appGroup = value;
    }

}
