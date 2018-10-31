package com.apria.gateway.validation.app;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.apria.gateway.validation.dao.EDIOrderRepository;
import com.apria.gateway.validation.model.EDIOrder;


@Component("ediOrderService")
public class EDIOrderServiceImpl implements EDIOrderService, InitializingBean{

	@Resource
	private EDIOrderRepository ediOrderRepository;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.ediOrderRepository, "A ediOrderRepository must be set");  
	}
	
	@Override
	@Transactional
	public EDIOrder findById(final Long id) {
		return  ediOrderRepository.findOne(id);		
	}


	@Override
	@Transactional
	public EDIOrder findByEDIOrderId(String ediOrderId) {
		return ediOrderRepository.findByediOrderId(ediOrderId);
	}

	@Override
	@Transactional
	public EDIOrder save(EDIOrder ediOrder) {
		return ediOrderRepository.save(ediOrder);
	}

}
