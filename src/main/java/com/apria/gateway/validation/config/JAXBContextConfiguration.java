package com.apria.gateway.validation.config;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apria.gateway.err.jaxb.ErrorMessage;
import com.apria.gateway.jaxb.OrderEquipmentLine;

@Configuration
public class JAXBContextConfiguration {

	@Bean(name="errorXML")
	public JAXBContext ErrorXMLJAXB() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(ErrorMessage.class);
		return context;
	}
	
	@Bean(name="lineConfirmation")
	public JAXBContext LineConfirmationJAXB() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(OrderEquipmentLine.class);
		return context;
	}

}
