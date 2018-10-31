package com.apria.gateway.validation.app;

import com.apria.gateway.validation.model.EDIOrder;

public interface EDIOrderService {
	public EDIOrder findById(final Long id);
	
	public EDIOrder findByEDIOrderId(final String ediOrderId);

	public EDIOrder save(EDIOrder ediOrder);
}
