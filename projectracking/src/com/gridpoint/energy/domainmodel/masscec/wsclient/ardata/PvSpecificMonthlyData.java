//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.04 at 05:01:15 PM IST 
//


package com.gridpoint.energy.domainmodel.masscec.wsclient.ardata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pvSpecificMonthlyData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pvSpecificMonthlyData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ar.masstech-pts.org/PTS-AR}monthlyType">
 *       &lt;sequence>
 *         &lt;element name="emptyElement" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pvSpecificMonthlyData", propOrder = {
    "emptyElement"
})
public class PvSpecificMonthlyData
    extends MonthlyType
{

    protected Object emptyElement;

    /**
     * Gets the value of the emptyElement property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getEmptyElement() {
        return emptyElement;
    }

    /**
     * Sets the value of the emptyElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setEmptyElement(Object value) {
        this.emptyElement = value;
    }

}
