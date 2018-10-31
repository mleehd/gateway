package com.apria.gateway.validation.app.exception;

public class DuplicateOrderIdException extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public DuplicateOrderIdException(String orderId) {
        super("Duplicate Order Id found. Order Id is ->" +  orderId);
    }

}
