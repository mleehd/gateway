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
 * <p>Java class for Order_Equipment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Order_Equipment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}Order_Equipment_Line" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order_Equipment", propOrder = {
    "orderEquipmentLine"
})
public class OrderEquipment {

    @XmlElement(name = "Order_Equipment_Line")
    protected List<OrderEquipmentLine> orderEquipmentLine;

    /**
     * Gets the value of the orderEquipmentLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderEquipmentLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderEquipmentLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderEquipmentLine }
     * 
     * 
     */
    public List<OrderEquipmentLine> getOrderEquipmentLine() {
        if (orderEquipmentLine == null) {
            orderEquipmentLine = new ArrayList<OrderEquipmentLine>();
        }
        return this.orderEquipmentLine;
    }

}