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

    @Column(name="edi_order_number")
    private String ediOrderId;

    @Column(name="edi_order_data")
    @Lob
    private String ediOrderData;

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
