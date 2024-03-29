//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.04 at 05:01:15 PM IST 
//


package com.gridpoint.energy.domainmodel.masscec.wsclient.ardata;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for entryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="entryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kwAcOutput" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="entryDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="intervalKwhRegistry" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="sysEff" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="avgTempInF" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entryType", propOrder = {
    "kwAcOutput",
    "entryDateTime",
    "intervalKwhRegistry",
    "sysEff",
    "avgTempInF"
})
@XmlSeeAlso({
    PVType.class
})
public class EntryType {

    @XmlElement(required = true)
    protected BigDecimal kwAcOutput;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar entryDateTime;
    protected BigDecimal intervalKwhRegistry;
    protected BigDecimal sysEff;
    protected BigDecimal avgTempInF;

    /**
     * Gets the value of the kwAcOutput property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getKwAcOutput() {
        return kwAcOutput;
    }

    /**
     * Sets the value of the kwAcOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setKwAcOutput(BigDecimal value) {
        this.kwAcOutput = value;
    }

    /**
     * Gets the value of the entryDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEntryDateTime() {
        return entryDateTime;
    }

    /**
     * Sets the value of the entryDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEntryDateTime(XMLGregorianCalendar value) {
        this.entryDateTime = value;
    }

    /**
     * Gets the value of the intervalKwhRegistry property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIntervalKwhRegistry() {
        return intervalKwhRegistry;
    }

    /**
     * Sets the value of the intervalKwhRegistry property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIntervalKwhRegistry(BigDecimal value) {
        this.intervalKwhRegistry = value;
    }

    /**
     * Gets the value of the sysEff property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSysEff() {
        return sysEff;
    }

    /**
     * Sets the value of the sysEff property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSysEff(BigDecimal value) {
        this.sysEff = value;
    }

    /**
     * Gets the value of the avgTempInF property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAvgTempInF() {
        return avgTempInF;
    }

    /**
     * Sets the value of the avgTempInF property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAvgTempInF(BigDecimal value) {
        this.avgTempInF = value;
    }

}
