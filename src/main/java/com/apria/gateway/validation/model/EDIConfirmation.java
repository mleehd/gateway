package com.apria.gateway.validation.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="edi_confirmation")
public class EDIConfirmation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="order_id")
    private String ediOrderId;

	@Column(name="line_item_referral_id")
    private String referralId;
    
    @Column(name="line_item_order_data")
    @Lob
    private String lineItemOrderData;
    
    @Column(name="line_item_confirmation_data")
    @Lob
    private String lineItemConfirmationData;
    
	@Column(name="type")
    private String type;
    
    @Column(name="status")
    private String status;
    
    @Column(name="created_date", columnDefinition="DATETIME")
    private LocalDateTime createdDate;

    @Column(name="modified_date", columnDefinition="DATETIME")
    private LocalDateTime modifiedDate;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable=false, updatable = false, insertable = false)
	private EDIOrder ediorder;
	
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
	
    public String getReferralId() {
		return referralId;
	}

	public void setReferralId(String referralId) {
		this.referralId = referralId;
	}

	public String getLineItemOrderData() {
		return lineItemOrderData;
	}

	public void setLineItemOrderData(String lineItemOrderData) {
		this.lineItemOrderData = lineItemOrderData;
	}

	public String getLineItemConfirmationData() {
		return lineItemConfirmationData;
	}

	public void setLineItemConfirmationData(String lineItemConfirmationData) {
		this.lineItemConfirmationData = lineItemConfirmationData;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
