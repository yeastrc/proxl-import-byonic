//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.04.16 at 02:04:02 PM PDT 
//


package info.psidev.psi.pi.mzidentml._1;

import javax.xml.bind.annotation.*;


/**
 * The software used for performing the analyses.
 * 
 * <p>Java class for AnalysisSoftwareType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnalysisSoftwareType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzIdentML/1.1}IdentifiableType">
 *       &lt;sequence>
 *         &lt;element name="ContactRole" type="{http://psidev.info/psi/pi/mzIdentML/1.1}ContactRoleType" minOccurs="0"/>
 *         &lt;element name="SoftwareName" type="{http://psidev.info/psi/pi/mzIdentML/1.1}ParamType"/>
 *         &lt;element name="Customizations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="uri" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnalysisSoftwareType", propOrder = {
    "contactRole",
    "softwareName",
    "customizations"
})
public class AnalysisSoftwareType
    extends IdentifiableType
{

    @XmlElement(name = "ContactRole")
    protected ContactRoleType contactRole;
    @XmlElement(name = "SoftwareName", required = true)
    protected ParamType softwareName;
    @XmlElement(name = "Customizations")
    protected String customizations;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected String uri;

    /**
     * Gets the value of the contactRole property.
     * 
     * @return
     *     possible object is
     *     {@link ContactRoleType }
     *     
     */
    public ContactRoleType getContactRole() {
        return contactRole;
    }

    /**
     * Sets the value of the contactRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactRoleType }
     *     
     */
    public void setContactRole(ContactRoleType value) {
        this.contactRole = value;
    }

    /**
     * Gets the value of the softwareName property.
     * 
     * @return
     *     possible object is
     *     {@link ParamType }
     *     
     */
    public ParamType getSoftwareName() {
        return softwareName;
    }

    /**
     * Sets the value of the softwareName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamType }
     *     
     */
    public void setSoftwareName(ParamType value) {
        this.softwareName = value;
    }

    /**
     * Gets the value of the customizations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomizations() {
        return customizations;
    }

    /**
     * Sets the value of the customizations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomizations(String value) {
        this.customizations = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUri(String value) {
        this.uri = value;
    }

}
