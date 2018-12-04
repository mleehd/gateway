package com.apria.gateway.validation.app;

public class ValidatorResponseDto {
	private String orderId;
	
	private String errorType;
	
	private Exception e;
	
	private String exceptionMessage;
	
	private String errorCode;
	
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
	
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	
	public void setE(Exception e) {
		this.e = e;
		this.exceptionMessage = e.getMessage();
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
