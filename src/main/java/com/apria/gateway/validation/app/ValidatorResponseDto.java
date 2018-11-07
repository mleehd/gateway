package com.apria.gateway.validation.app;

public class ValidatorResponseDto {
	private String orderId;
	
	private String errorType;
	
	private Exception e;
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	public Exception getE() {
		return e;
	}

	public void setE(Exception e) {
		this.e = e;
	}

}
