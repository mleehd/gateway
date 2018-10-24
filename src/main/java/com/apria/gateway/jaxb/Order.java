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
 * <p>Java class for Order complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Order"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}Vendor_ID"/&gt;
 *         &lt;element ref="{}KP_Order_ID"/&gt;
 *         &lt;element ref="{}Vendor_Order_ID"/&gt;
 *         &lt;element ref="{}Notification_Sent_Date"/&gt;
 *         &lt;element ref="{}Notification_Sent_Time"/&gt;
 *         &lt;element ref="{}Order_Location"/&gt;
 *         &lt;element ref="{}Transaction_Type"/&gt;
 *         &lt;element ref="{}Patient" minOccurs="0"/&gt;
 *         &lt;element name="Referring_Physician" type="{}Physician" minOccurs="0"/&gt;
 *         &lt;element name="Diagnosis" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{}ICD_CD" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element ref="{}ICD_IND" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="POS_Type_Code" type="{}Place_Of_Service" minOccurs="0"/&gt;
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
@XmlType(name = "Order", propOrder = {
    "vendorID",
    "kpOrderID",
    "vendorOrderID",
    "notificationSentDate",
    "notificationSentTime",
    "orderLocation",
    "transactionType",
    "patient",
    "referringPhysician",
    "diagnosis",
    "posTypeCode",
    "generic1",
    "generic2",
    "generic3"
})
public class Order {

    @XmlElement(name = "Vendor_ID", required = true)
    protected VendorID vendorID;
    @XmlElement(name = "KP_Order_ID", required = true)
    protected KPOrderID kpOrderID;
    @XmlElement(name = "Vendor_Order_ID", required = true)
    protected VendorOrderID vendorOrderID;
    @XmlElement(name = "Notification_Sent_Date", required = true)
    protected NotificationSentDate notificationSentDate;
    @XmlElement(name = "Notification_Sent_Time", required = true)
    protected NotificationSentTime notificationSentTime;
    @XmlElement(name = "Order_Location", required = true)
    protected OrderLocation orderLocation;
    @XmlElement(name = "Transaction_Type", required = true)
    protected TransactionType transactionType;
    @XmlElement(name = "Patient")
    protected Patient patient;
    @XmlElement(name = "Referring_Physician")
    protected Physician referringPhysician;
    @XmlElement(name = "Diagnosis")
    protected Order.Diagnosis diagnosis;
    @XmlElement(name = "POS_Type_Code")
    protected PlaceOfService posTypeCode;
    @XmlElement(name = "Generic_1")
    protected Object generic1;
    @XmlElement(name = "Generic_2")
    protected Object generic2;
    @XmlElement(name = "Generic_3")
    protected Object generic3;

    /**
     * Gets the value of the vendorID property.
     * 
     * @return
     *     possible object is
     *     {@link VendorID }
     *     
     */
    public VendorID getVendorID() {
        return vendorID;
    }

    /**
     * Sets the value of the vendorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link VendorID }
     *     
     */
    public void setVendorID(VendorID value) {
        this.vendorID = value;
    }

    /**
     * Gets the value of the kpOrderID property.
     * 
     * @return
     *     possible object is
     *     {@link KPOrderID }
     *     
     */
    public KPOrderID getKPOrderID() {
        return kpOrderID;
    }

    /**
     * Sets the value of the kpOrderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link KPOrderID }
     *     
     */
    public void setKPOrderID(KPOrderID value) {
        this.kpOrderID = value;
    }

    /**
     * Gets the value of the vendorOrderID property.
     * 
     * @return
     *     possible object is
     *     {@link VendorOrderID }
     *     
     */
    public VendorOrderID getVendorOrderID() {
        return vendorOrderID;
    }

    /**
     * Sets the value of the vendorOrderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link VendorOrderID }
     *     
     */
    public void setVendorOrderID(VendorOrderID value) {
        this.vendorOrderID = value;
    }

    /**
     * Gets the value of the notificationSentDate property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationSentDate }
     *     
     */
    public NotificationSentDate getNotificationSentDate() {
        return notificationSentDate;
    }

    /**
     * Sets the value of the notificationSentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationSentDate }
     *     
     */
    public void setNotificationSentDate(NotificationSentDate value) {
        this.notificationSentDate = value;
    }

    /**
     * Gets the value of the notificationSentTime property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationSentTime }
     *     
     */
    public NotificationSentTime getNotificationSentTime() {
        return notificationSentTime;
    }

    /**
     * Sets the value of the notificationSentTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationSentTime }
     *     
     */
    public void setNotificationSentTime(NotificationSentTime value) {
        this.notificationSentTime = value;
    }

    /**
     * Gets the value of the orderLocation property.
     * 
     * @return
     *     possible object is
     *     {@link OrderLocation }
     *     
     */
    public OrderLocation getOrderLocation() {
        return orderLocation;
    }

    /**
     * Sets the value of the orderLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderLocation }
     *     
     */
    public void setOrderLocation(OrderLocation value) {
        this.orderLocation = value;
    }

    /**
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionType }
     *     
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionType }
     *     
     */
    public void setTransactionType(TransactionType value) {
        this.transactionType = value;
    }

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link Patient }
     *     
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link Patient }
     *     
     */
    public void setPatient(Patient value) {
        this.patient = value;
    }

    /**
     * Gets the value of the referringPhysician property.
     * 
     * @return
     *     possible object is
     *     {@link Physician }
     *     
     */
    public Physician getReferringPhysician() {
        return referringPhysician;
    }

    /**
     * Sets the value of the referringPhysician property.
     * 
     * @param value
     *     allowed object is
     *     {@link Physician }
     *     
     */
    public void setReferringPhysician(Physician value) {
        this.referringPhysician = value;
    }

    /**
     * Gets the value of the diagnosis property.
     * 
     * @return
     *     possible object is
     *     {@link Order.Diagnosis }
     *     
     */
    public Order.Diagnosis getDiagnosis() {
        return diagnosis;
    }

    /**
     * Sets the value of the diagnosis property.
     * 
     * @param value
     *     allowed object is
     *     {@link Order.Diagnosis }
     *     
     */
    public void setDiagnosis(Order.Diagnosis value) {
        this.diagnosis = value;
    }

    /**
     * Gets the value of the posTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link PlaceOfService }
     *     
     */
    public PlaceOfService getPOSTypeCode() {
        return posTypeCode;
    }

    /**
     * Sets the value of the posTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlaceOfService }
     *     
     */
    public void setPOSTypeCode(PlaceOfService value) {
        this.posTypeCode = value;
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
     *         &lt;element ref="{}ICD_CD" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element ref="{}ICD_IND" minOccurs="0"/&gt;
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
        "icdcd",
        "icdind"
    })
    public static class Diagnosis {

        @XmlElement(name = "ICD_CD")
        protected List<ICDCD> icdcd;
        @XmlElement(name = "ICD_IND")
        protected ICDIND icdind;

        /**
         * Gets the value of the icdcd property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the icdcd property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getICDCD().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ICDCD }
         * 
         * 
         */
        public List<ICDCD> getICDCD() {
            if (icdcd == null) {
                icdcd = new ArrayList<ICDCD>();
            }
            return this.icdcd;
        }

        /**
         * Gets the value of the icdind property.
         * 
         * @return
         *     possible object is
         *     {@link ICDIND }
         *     
         */
        public ICDIND getICDIND() {
            return icdind;
        }

        /**
         * Sets the value of the icdind property.
         * 
         * @param value
         *     allowed object is
         *     {@link ICDIND }
         *     
         */
        public void setICDIND(ICDIND value) {
            this.icdind = value;
        }

    }

}