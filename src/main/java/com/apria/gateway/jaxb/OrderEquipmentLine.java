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
 * <p>Java class for Order_Equipment_Line complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Order_Equipment_Line"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}Order_Line"/&gt;
 *         &lt;element name="Line_Item_Referral_ID" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element ref="{}Line_Address_Type" minOccurs="0"/&gt;
 *         &lt;element ref="{}Line_Coverage" minOccurs="0"/&gt;
 *         &lt;element ref="{}Line_Item_Code" minOccurs="0"/&gt;
 *         &lt;element ref="{}Line_Item_Description" minOccurs="0"/&gt;
 *         &lt;element name="Line_Item_Soft_Good_HC_ID" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="Line_Item_Modifier_Code" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="Request_Type" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element ref="{}Line_Item_Quantity" minOccurs="0"/&gt;
 *         &lt;element ref="{}Line_Service_Start_Date" minOccurs="0"/&gt;
 *         &lt;element name="Line_Service_Expiration_Date" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element ref="{}Line_Duration_Unit" minOccurs="0"/&gt;
 *         &lt;element ref="{}Line_Duration_Of_Use" minOccurs="0"/&gt;
 *         &lt;element ref="{}Line_Delivery_Type" minOccurs="0"/&gt;
 *         &lt;element ref="{}Line_Notes" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Pricing_Information" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{}Line_CoPay_Method"/&gt;
 *                   &lt;element ref="{}Line_CoPay_Amount"/&gt;
 *                   &lt;element ref="{}Line_Member_Liability"/&gt;
 *                   &lt;element ref="{}Line_KP_Share"/&gt;
 *                   &lt;element ref="{}Line_Medicare_Share"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order_Equipment_Line", propOrder = {
    "orderLine",
    "lineItemReferralID",
    "lineAddressType",
    "lineCoverage",
    "lineItemCode",
    "lineItemDescription",
    "lineItemSoftGoodHCID",
    "lineItemModifierCode",
    "requestType",
    "lineItemQuantity",
    "lineServiceStartDate",
    "lineServiceExpirationDate",
    "lineDurationUnit",
    "lineDurationOfUse",
    "lineDeliveryType",
    "lineNotes",
    "pricingInformation"
})
public class OrderEquipmentLine {

    @XmlElement(name = "Order_Line", required = true)
    protected OrderLine orderLine;
    @XmlElement(name = "Line_Item_Referral_ID")
    protected Object lineItemReferralID;
    @XmlElement(name = "Line_Address_Type")
    protected LineAddressType lineAddressType;
    @XmlElement(name = "Line_Coverage")
    protected LineCoverage lineCoverage;
    @XmlElement(name = "Line_Item_Code")
    protected LineItemCode lineItemCode;
    @XmlElement(name = "Line_Item_Description")
    protected LineItemDescription lineItemDescription;
    @XmlElement(name = "Line_Item_Soft_Good_HC_ID")
    protected Object lineItemSoftGoodHCID;
    @XmlElement(name = "Line_Item_Modifier_Code")
    protected Object lineItemModifierCode;
    @XmlElement(name = "Request_Type")
    protected Object requestType;
    @XmlElement(name = "Line_Item_Quantity")
    protected LineItemQuantity lineItemQuantity;
    @XmlElement(name = "Line_Service_Start_Date")
    protected LineServiceStartDate lineServiceStartDate;
    @XmlElement(name = "Line_Service_Expiration_Date")
    protected Object lineServiceExpirationDate;
    @XmlElement(name = "Line_Duration_Unit")
    protected LineDurationUnit lineDurationUnit;
    @XmlElement(name = "Line_Duration_Of_Use")
    protected LineDurationOfUse lineDurationOfUse;
    @XmlElement(name = "Line_Delivery_Type")
    protected LineDeliveryType lineDeliveryType;
    @XmlElement(name = "Line_Notes")
    protected List<LineNotes> lineNotes;
    @XmlElement(name = "Pricing_Information")
    protected OrderEquipmentLine.PricingInformation pricingInformation;

    /**
     * Gets the value of the orderLine property.
     * 
     * @return
     *     possible object is
     *     {@link OrderLine }
     *     
     */
    public OrderLine getOrderLine() {
        return orderLine;
    }

    /**
     * Sets the value of the orderLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderLine }
     *     
     */
    public void setOrderLine(OrderLine value) {
        this.orderLine = value;
    }

    /**
     * Gets the value of the lineItemReferralID property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getLineItemReferralID() {
        return lineItemReferralID;
    }

    /**
     * Sets the value of the lineItemReferralID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setLineItemReferralID(Object value) {
        this.lineItemReferralID = value;
    }

    /**
     * Gets the value of the lineAddressType property.
     * 
     * @return
     *     possible object is
     *     {@link LineAddressType }
     *     
     */
    public LineAddressType getLineAddressType() {
        return lineAddressType;
    }

    /**
     * Sets the value of the lineAddressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineAddressType }
     *     
     */
    public void setLineAddressType(LineAddressType value) {
        this.lineAddressType = value;
    }

    /**
     * Gets the value of the lineCoverage property.
     * 
     * @return
     *     possible object is
     *     {@link LineCoverage }
     *     
     */
    public LineCoverage getLineCoverage() {
        return lineCoverage;
    }

    /**
     * Sets the value of the lineCoverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineCoverage }
     *     
     */
    public void setLineCoverage(LineCoverage value) {
        this.lineCoverage = value;
    }

    /**
     * Gets the value of the lineItemCode property.
     * 
     * @return
     *     possible object is
     *     {@link LineItemCode }
     *     
     */
    public LineItemCode getLineItemCode() {
        return lineItemCode;
    }

    /**
     * Sets the value of the lineItemCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineItemCode }
     *     
     */
    public void setLineItemCode(LineItemCode value) {
        this.lineItemCode = value;
    }

    /**
     * Gets the value of the lineItemDescription property.
     * 
     * @return
     *     possible object is
     *     {@link LineItemDescription }
     *     
     */
    public LineItemDescription getLineItemDescription() {
        return lineItemDescription;
    }

    /**
     * Sets the value of the lineItemDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineItemDescription }
     *     
     */
    public void setLineItemDescription(LineItemDescription value) {
        this.lineItemDescription = value;
    }

    /**
     * Gets the value of the lineItemSoftGoodHCID property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getLineItemSoftGoodHCID() {
        return lineItemSoftGoodHCID;
    }

    /**
     * Sets the value of the lineItemSoftGoodHCID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setLineItemSoftGoodHCID(Object value) {
        this.lineItemSoftGoodHCID = value;
    }

    /**
     * Gets the value of the lineItemModifierCode property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getLineItemModifierCode() {
        return lineItemModifierCode;
    }

    /**
     * Sets the value of the lineItemModifierCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setLineItemModifierCode(Object value) {
        this.lineItemModifierCode = value;
    }

    /**
     * Gets the value of the requestType property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRequestType() {
        return requestType;
    }

    /**
     * Sets the value of the requestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRequestType(Object value) {
        this.requestType = value;
    }

    /**
     * Gets the value of the lineItemQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link LineItemQuantity }
     *     
     */
    public LineItemQuantity getLineItemQuantity() {
        return lineItemQuantity;
    }

    /**
     * Sets the value of the lineItemQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineItemQuantity }
     *     
     */
    public void setLineItemQuantity(LineItemQuantity value) {
        this.lineItemQuantity = value;
    }

    /**
     * Gets the value of the lineServiceStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link LineServiceStartDate }
     *     
     */
    public LineServiceStartDate getLineServiceStartDate() {
        return lineServiceStartDate;
    }

    /**
     * Sets the value of the lineServiceStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineServiceStartDate }
     *     
     */
    public void setLineServiceStartDate(LineServiceStartDate value) {
        this.lineServiceStartDate = value;
    }

    /**
     * Gets the value of the lineServiceExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getLineServiceExpirationDate() {
        return lineServiceExpirationDate;
    }

    /**
     * Sets the value of the lineServiceExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setLineServiceExpirationDate(Object value) {
        this.lineServiceExpirationDate = value;
    }

    /**
     * Gets the value of the lineDurationUnit property.
     * 
     * @return
     *     possible object is
     *     {@link LineDurationUnit }
     *     
     */
    public LineDurationUnit getLineDurationUnit() {
        return lineDurationUnit;
    }

    /**
     * Sets the value of the lineDurationUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineDurationUnit }
     *     
     */
    public void setLineDurationUnit(LineDurationUnit value) {
        this.lineDurationUnit = value;
    }

    /**
     * Gets the value of the lineDurationOfUse property.
     * 
     * @return
     *     possible object is
     *     {@link LineDurationOfUse }
     *     
     */
    public LineDurationOfUse getLineDurationOfUse() {
        return lineDurationOfUse;
    }

    /**
     * Sets the value of the lineDurationOfUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineDurationOfUse }
     *     
     */
    public void setLineDurationOfUse(LineDurationOfUse value) {
        this.lineDurationOfUse = value;
    }

    /**
     * Gets the value of the lineDeliveryType property.
     * 
     * @return
     *     possible object is
     *     {@link LineDeliveryType }
     *     
     */
    public LineDeliveryType getLineDeliveryType() {
        return lineDeliveryType;
    }

    /**
     * Sets the value of the lineDeliveryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineDeliveryType }
     *     
     */
    public void setLineDeliveryType(LineDeliveryType value) {
        this.lineDeliveryType = value;
    }

    /**
     * Gets the value of the lineNotes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineNotes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineNotes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineNotes }
     * 
     * 
     */
    public List<LineNotes> getLineNotes() {
        if (lineNotes == null) {
            lineNotes = new ArrayList<LineNotes>();
        }
        return this.lineNotes;
    }

    /**
     * Gets the value of the pricingInformation property.
     * 
     * @return
     *     possible object is
     *     {@link OrderEquipmentLine.PricingInformation }
     *     
     */
    public OrderEquipmentLine.PricingInformation getPricingInformation() {
        return pricingInformation;
    }

    /**
     * Sets the value of the pricingInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderEquipmentLine.PricingInformation }
     *     
     */
    public void setPricingInformation(OrderEquipmentLine.PricingInformation value) {
        this.pricingInformation = value;
    }


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
     *         &lt;element ref="{}Line_CoPay_Method"/&gt;
     *         &lt;element ref="{}Line_CoPay_Amount"/&gt;
     *         &lt;element ref="{}Line_Member_Liability"/&gt;
     *         &lt;element ref="{}Line_KP_Share"/&gt;
     *         &lt;element ref="{}Line_Medicare_Share"/&gt;
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
        "lineCoPayMethod",
        "lineCoPayAmount",
        "lineMemberLiability",
        "lineKPShare",
        "lineMedicareShare"
    })
    public static class PricingInformation {

        @XmlElement(name = "Line_CoPay_Method", required = true)
        protected LineCoPayMethod lineCoPayMethod;
        @XmlElement(name = "Line_CoPay_Amount", required = true)
        protected LineCoPayAmount lineCoPayAmount;
        @XmlElement(name = "Line_Member_Liability", required = true)
        protected LineMemberLiability lineMemberLiability;
        @XmlElement(name = "Line_KP_Share", required = true)
        protected LineKPShare lineKPShare;
        @XmlElement(name = "Line_Medicare_Share", required = true)
        protected LineMedicareShare lineMedicareShare;

        /**
         * Gets the value of the lineCoPayMethod property.
         * 
         * @return
         *     possible object is
         *     {@link LineCoPayMethod }
         *     
         */
        public LineCoPayMethod getLineCoPayMethod() {
            return lineCoPayMethod;
        }

        /**
         * Sets the value of the lineCoPayMethod property.
         * 
         * @param value
         *     allowed object is
         *     {@link LineCoPayMethod }
         *     
         */
        public void setLineCoPayMethod(LineCoPayMethod value) {
            this.lineCoPayMethod = value;
        }

        /**
         * Gets the value of the lineCoPayAmount property.
         * 
         * @return
         *     possible object is
         *     {@link LineCoPayAmount }
         *     
         */
        public LineCoPayAmount getLineCoPayAmount() {
            return lineCoPayAmount;
        }

        /**
         * Sets the value of the lineCoPayAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link LineCoPayAmount }
         *     
         */
        public void setLineCoPayAmount(LineCoPayAmount value) {
            this.lineCoPayAmount = value;
        }

        /**
         * Gets the value of the lineMemberLiability property.
         * 
         * @return
         *     possible object is
         *     {@link LineMemberLiability }
         *     
         */
        public LineMemberLiability getLineMemberLiability() {
            return lineMemberLiability;
        }

        /**
         * Sets the value of the lineMemberLiability property.
         * 
         * @param value
         *     allowed object is
         *     {@link LineMemberLiability }
         *     
         */
        public void setLineMemberLiability(LineMemberLiability value) {
            this.lineMemberLiability = value;
        }

        /**
         * Gets the value of the lineKPShare property.
         * 
         * @return
         *     possible object is
         *     {@link LineKPShare }
         *     
         */
        public LineKPShare getLineKPShare() {
            return lineKPShare;
        }

        /**
         * Sets the value of the lineKPShare property.
         * 
         * @param value
         *     allowed object is
         *     {@link LineKPShare }
         *     
         */
        public void setLineKPShare(LineKPShare value) {
            this.lineKPShare = value;
        }

        /**
         * Gets the value of the lineMedicareShare property.
         * 
         * @return
         *     possible object is
         *     {@link LineMedicareShare }
         *     
         */
        public LineMedicareShare getLineMedicareShare() {
            return lineMedicareShare;
        }

        /**
         * Sets the value of the lineMedicareShare property.
         * 
         * @param value
         *     allowed object is
         *     {@link LineMedicareShare }
         *     
         */
        public void setLineMedicareShare(LineMedicareShare value) {
            this.lineMedicareShare = value;
        }

    }

}
