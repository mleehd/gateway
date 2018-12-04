package com.apria.gateway.validation.app;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
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
	
	public ValidatorResponseDto validate(String xml) throws Exception {
		Source source = new StreamSource(new StringReader(xml));
		ValidatorResponseDto dto = null;
		Validator validator = schema.newValidator();
		
		String orderId = null;
		try {
			orderId = getKaiserOrderId(xml);
		} catch (XMLStreamException e) {
			return getResponseDto(orderId, "SCHEMA_VIOLATION", e, "1000");
		}

		//check if XML conforms to schema
		try {
			validator.validate(source);
		} catch (SAXException e) {
			return getResponseDto(orderId, "SCHEMA_VIOLATION", e, "1000");
		}

		//Duplicate order check
        EDIOrder edi = ediOrderService.findByEDIOrderId(orderId);
        if (edi != null) {
        	System.out.println("KaiserXMLValidatorImpl.DuplicatedOrderFound. OrderId->" + edi.getEdiOrderId());
        	return getResponseDto(orderId, "DUPLICATE_ORDER", new DuplicateOrderIdException(orderId), "1001");
        }
        
        dto = new ValidatorResponseDto();
		dto.setOrderId(orderId);
        return dto;
	}
	
	private ValidatorResponseDto getResponseDto(String orderId, String errorType, Exception e, String errorCode) throws Exception {
		ValidatorResponseDto dto = new ValidatorResponseDto();
		dto.setOrderId(orderId);
		dto.setErrorType(errorType);
		dto.setE(e);
		dto.setErrorCode(errorCode);
		return dto;
	}
	
	private String getKaiserOrderId(String xml) throws XMLStreamException {

		// XMLInputFactory is not thread safe. Hence instantiating the object
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
