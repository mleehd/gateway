package com.apria.gateway.validation.app;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apria.gateway.validation.app.exception.DuplicateOrderIdException;
import com.apria.gateway.validation.model.EDIOrder;

@Component(value="kaiserXMLValidator")
public class KaiserXMLValidatorImpl implements XMLValidator {

	@Autowired
	private Schema schema;
	
	@Autowired
	private EDIOrderService ediOrderService;
	
	@Override
	public void validate(String xml) throws Exception {
		Source source = new StreamSource(new StringReader(xml));

		Validator validator = schema.newValidator();
		validator.validate(source);
		
		String orderId = getKaiserOrderId(xml);
        EDIOrder edi = ediOrderService.findByEDIOrderId(orderId);
        if (edi != null) {
        	System.out.println("KaiserXMLValidatorImpl.validate. OrderId->" + edi.getEdiOrderId());
        	throw new DuplicateOrderIdException(orderId);
        }
	}
	
	private String getKaiserOrderId(String xml) throws Exception {
		//XMLInputFactory is not thread safe. Hence instantiating the object 
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		InputStream in = new ByteArrayInputStream(xml.getBytes());
		XMLStreamReader streamReader = inputFactory.createXMLStreamReader(in);

		String orderId = null;
		while (streamReader.hasNext()) {
			if (streamReader.isStartElement() && (streamReader.getLocalName().equalsIgnoreCase("KP_Order_ID"))) {
				orderId = streamReader.getElementText();
				System.out.println("KP_Order_ID : " + orderId);
				break;
			}
			streamReader.next();
		}
		
		return orderId;
	}
	
	public void setEDIOrderService(EDIOrderService ediOrderService) {
		this.ediOrderService = ediOrderService;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}
}
