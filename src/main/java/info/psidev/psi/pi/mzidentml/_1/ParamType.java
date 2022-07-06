//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.04.16 at 02:04:02 PM PDT 
//


package info.psidev.psi.pi.mzidentml._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Helper type to allow either a cvParam or a userParam to be provided for an element.
 * 
 * <p>Java class for ParamType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParamType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{http://psidev.info/psi/pi/mzIdentML/1.1}ParamGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParamType", propOrder = {
    "cvParam",
    "userParam"
})
public class ParamType {

    protected CVParamType cvParam;
    protected UserParamType userParam;

    /**
     * Gets the value of the cvParam property.
     * 
     * @return
     *     possible object is
     *     {@link CVParamType }
     *     
     */
    public CVParamType getCvParam() {
        return cvParam;
    }

    /**
     * Sets the value of the cvParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link CVParamType }
     *     
     */
    public void setCvParam(CVParamType value) {
        this.cvParam = value;
    }

    /**
     * Gets the value of the userParam property.
     * 
     * @return
     *     possible object is
     *     {@link UserParamType }
     *     
     */
    public UserParamType getUserParam() {
        return userParam;
    }

    /**
     * Sets the value of the userParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserParamType }
     *     
     */
    public void setUserParam(UserParamType value) {
        this.userParam = value;
    }

}
