//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.10.24 at 11:55:59 AM EDT 
//


package com.apria.gateway.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Name complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Name"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}First" minOccurs="0"/&gt;
 *         &lt;element ref="{}Middle" minOccurs="0"/&gt;
 *         &lt;element ref="{}Last" minOccurs="0"/&gt;
 *         &lt;element name="Suffix" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Name", propOrder = {
    "first",
    "middle",
    "last",
    "suffix"
})
public class Name {

    @XmlElement(name = "First")
    protected First first;
    @XmlElement(name = "Middle")
    protected Middle middle;
    @XmlElement(name = "Last")
    protected Last last;
    @XmlElement(name = "Suffix")
    protected Object suffix;

    /**
     * Gets the value of the first property.
     * 
     * @return
     *     possible object is
     *     {@link First }
     *     
     */
    public First getFirst() {
        return first;
    }

    /**
     * Sets the value of the first property.
     * 
     * @param value
     *     allowed object is
     *     {@link First }
     *     
     */
    public void setFirst(First value) {
        this.first = value;
    }

    /**
     * Gets the value of the middle property.
     * 
     * @return
     *     possible object is
     *     {@link Middle }
     *     
     */
    public Middle getMiddle() {
        return middle;
    }

    /**
     * Sets the value of the middle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Middle }
     *     
     */
    public void setMiddle(Middle value) {
        this.middle = value;
    }

    /**
     * Gets the value of the last property.
     * 
     * @return
     *     possible object is
     *     {@link Last }
     *     
     */
    public Last getLast() {
        return last;
    }

    /**
     * Sets the value of the last property.
     * 
     * @param value
     *     allowed object is
     *     {@link Last }
     *     
     */
    public void setLast(Last value) {
        this.last = value;
    }

    /**
     * Gets the value of the suffix property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSuffix(Object value) {
        this.suffix = value;
    }

}