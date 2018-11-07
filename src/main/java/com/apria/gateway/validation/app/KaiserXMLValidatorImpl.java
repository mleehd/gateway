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
import org.xml.sax.SAXException;

import com.apria.gateway.validation.app.exception.DuplicateOrderIdException;
import com.apria.gateway.validation.model.EDIOrder;

@Component(value="kaiserXMLValidator")
public class KaiserXMLValidatorImpl implements XMLValidator {

	@Autowired
	private Schema schema;
	
	@Autowired
	private EDIOrderService ediOrderService;
	
	@Override
	public ValidatorResponseDto validate(String xml) throws Exception {
		Source source = new StreamSource(new StringReader(xml));
		ValidatorResponseDto dto = new ValidatorResponseDto();
		
		String orderId = getKaiserOrderId(xml);
		dto.setOrderId(orderId);
		
		Validator validator = schema.newValidator();
		try {
			validator.validate(source);
		} catch (SAXException e) {
			dto.setErrorType("SCHEMA_VIOLATION");
			dto.setE(e);
			return dto;
		}

        EDIOrder edi = ediOrderService.findByEDIOrderId(orderId);
        if (edi != null) {
        	System.out.println("KaiserXMLValidatorImpl.validate. OrderId->" + edi.getEdiOrderId());
        	dto.setErrorType("DUPLICATE_ORDER");
        	dto.setE(new DuplicateOrderIdException(orderId));
        }
        
        return dto;
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
