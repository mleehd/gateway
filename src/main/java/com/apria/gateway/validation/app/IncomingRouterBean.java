package com.apria.gateway.validation.app;

import java.io.StringWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.apria.gateway.err.jaxb.ErrorDetailType;
import com.apria.gateway.err.jaxb.ErrorType;
import com.apria.gateway.err.jaxb.IncomingEDIMessageErrorType;

@Component
public class IncomingRouterBean {

	@Resource(name = "xmlValidators")
	Map<String, XMLValidator> xmlValidators;

	public void validateXML(Exchange ex) throws Exception {
		// Validator
		XMLValidator validator = xmlValidators.get(GatewayVendorEnum.KAISER);
		ValidatorResponseDto dto = validator.validate(ex.getIn().getBody().toString());
		
		if (null != dto.getErrorType()) {
			ex.getIn().setHeader("orderId", dto.getOrderId());
			ex.getIn().setHeader("errorType", dto.getErrorType());
			throw dto.getE();
		}
	}
	
	public String constructErrorXML(Exchange ex) throws Exception {

		IncomingEDIMessageErrorType errorXML = new IncomingEDIMessageErrorType();
		errorXML.setOriginalMessage(ex.getIn().getBody().toString());
		ErrorDetailType errDetail = new ErrorDetailType();
		errorXML.setErrorDetail(errDetail);
		errorXML.getErrorDetail().setMessage(ex.getIn().getHeader("exception_message").toString());
		errorXML.getErrorDetail().setType(ErrorType.fromValue(ex.getIn().getHeader("errorType").toString()));
		JAXBContext context = JAXBContext.newInstance(IncomingEDIMessageErrorType.class);
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    JAXBElement<IncomingEDIMessageErrorType> root = new JAXBElement<IncomingEDIMessageErrorType>(new QName("http://edigateway.apria.com/error", "IncomingEDIMessageError"),
	    				IncomingEDIMessageErrorType.class, null, errorXML);
	    StringWriter sw = new StringWriter();
	    CDATAContentHandler cDataContentHandler = new CDATAContentHandler(sw, "UTF-8");
	    m.marshal(root, cDataContentHandler);

	    return sw.toString();
	}

}
