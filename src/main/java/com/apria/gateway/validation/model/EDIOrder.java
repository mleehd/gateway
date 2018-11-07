package com.apria.gateway.validation.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="edi_order")
public class EDIOrder {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="order_id")
    private String ediOrderId;

    @Column(name="order_xml")
    @Lob
    private String ediOrderData;
    
	@Column(name="type")
    private String orderType;
    
    @Column(name="status")
    private String status;
    
    @Column(name="error_type")
    private String errorType;

    @Column(name="error_message")
    private String errorMsg;

    @Column(name="created_date", columnDefinition="DATETIME")
    private LocalDateTime createdDate;

    @Column(name="modified_date", columnDefinition="DATETIME")
    private LocalDateTime modifiedDate;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEdiOrderId() {
		return ediOrderId;
	}

	public void setEdiOrderId(String ediOrderNumber) {
		this.ediOrderId = ediOrderNumber;
	}

	public String getEdiOrderData() {
		return ediOrderData;
	}

	public void setEdiOrderData(String ediOrderData) {
		this.ediOrderData = ediOrderData;
	}
	
    public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
