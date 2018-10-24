//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.10.24 at 11:55:59 AM EDT 
//


package com.apria.gateway.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Transaction_Details complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Transaction_Details"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}Order_Equipment" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{}Delivery_Address" minOccurs="0"/&gt;
 *         &lt;element name="Generic_1" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="Generic_2" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="Generic_3" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transaction_Details", propOrder = {
    "orderEquipment",
    "deliveryAddress",
    "generic1",
    "generic2",
    "generic3"
})
public class TransactionDetails {

    @XmlElement(name = "Order_Equipment")
    protected List<OrderEquipment> orderEquipment;
    @XmlElement(name = "Delivery_Address")
    protected DeliveryAddress deliveryAddress;
    @XmlElement(name = "Generic_1")
    protected Object generic1;
    @XmlElement(name = "Generic_2")
    protected Object generic2;
    @XmlElement(name = "Generic_3")
    protected Object generic3;

    /**
     * Gets the value of the orderEquipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderEquipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderEquipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderEquipment }
     * 
     * 
     */
    public List<OrderEquipment> getOrderEquipment() {
        if (orderEquipment == null) {
            orderEquipment = new ArrayList<OrderEquipment>();
        }
        return this.orderEquipment;
    }

    /**
     * Gets the value of the deliveryAddress property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryAddress }
     *     
     */
    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Sets the value of the deliveryAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryAddress }
     *     
     */
    public void setDeliveryAddress(DeliveryAddress value) {
        this.deliveryAddress = value;
    }

    /**
     * Gets the value of the generic1 property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getGeneric1() {
        return generic1;
    }

    /**
     * Sets the value of the generic1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setGeneric1(Object value) {
        this.generic1 = value;
    }

    /**
     * Gets the value of the generic2 property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getGeneric2() {
        return generic2;
    }

    /**
     * Sets the value of the generic2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setGeneric2(Object value) {
        this.generic2 = value;
    }

    /**
     * Gets the value of the generic3 property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getGeneric3() {
        return generic3;
    }

    /**
     * Sets the value of the generic3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setGeneric3(Object value) {
        this.generic3 = value;
    }

}