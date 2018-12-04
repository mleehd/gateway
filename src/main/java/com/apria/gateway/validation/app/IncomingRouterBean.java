package com.apria.gateway.validation.app;

import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.apria.gateway.err.jaxb.ErrorMessage;
import com.apria.gateway.jaxb.KPOrder;
import com.apria.gateway.jaxb.OrderEquipment;
import com.apria.gateway.jaxb.OrderEquipmentLine;
import com.apria.gateway.validation.model.EDIConfirmation;
import com.apria.gateway.validation.model.EDIOrder;


@Component
public class IncomingRouterBean {
	
	@Value("${errorxml.vendor}")
	private String vendor;
	
	@Value("${errorxml.source}")
	private String source;
	
	@Resource(name = "xmlValidators")
	Map<String, XMLValidator> xmlValidators;
	
	@Resource
	EDIOrderService orderService;
	
	@Resource(name="errorXML")
	JAXBContext errorJAXB;
	
	@Resource(name="lineConfirmation")
	JAXBContext lineConfirmationJAXB;
	
	public void validateXML(Exchange ex) throws Exception {

		XMLValidator validator = xmlValidators.get(GatewayVendorEnum.KAISER);
		ValidatorResponseDto dto = validator.validate(ex.getIn().getBody().toString());
		
		ex.getIn().setHeader(Constants.RESPONSE_DTO_HEADER, dto);
		if ((dto != null) && (dto.getE() != null)) {
			throw new NullPointerException("Exception thrown purposefully");
			//throw dto.getE();
		}
	}
	
	public void ThrowNullPointer(Exchange ex) {
		throw new NullPointerException("Exception thrown purposefully from ThrowNullPointer");
	}
	public void saveXMLMessageToDB(Exchange ex) throws Exception {
		KPOrder xmlOrder = (KPOrder)ex.getIn().getBody();
		ex.getIn().setBody(ex.getIn().getHeader(Constants.ORDER_MSG_STRING_HEADER).toString());
		ValidatorResponseDto dto = (ValidatorResponseDto) ex.getIn().getHeader(Constants.RESPONSE_DTO_HEADER);
		
		EDIOrder order = new EDIOrder();
		order.setEdiOrderId(dto.getOrderId());
		order.setEdiOrderData(ex.getIn().getHeader(Constants.ORDER_MSG_STRING_HEADER).toString());
		order.setOrderType(ex.getIn().getHeader(Constants.ORDER_TYPE_HEADER).toString());
		order.setCreatedDate(LocalDateTime.now());
		order.setModifiedDate(LocalDateTime.now());
		order.setStatus(Constants.ORDER_STATUS);
		
		
		OrderEquipment oe = xmlOrder.getOrderEquipment().get(0);
		List<EDIConfirmation> confirmations = oe.getOrderEquipmentLine().stream().map(oel -> {
			EDIConfirmation confirmation = new EDIConfirmation();
			confirmation.setEdiOrderId(dto.getOrderId());
			confirmation.setType("LINE_ITEM");
			confirmation.setStatus("RECEIVED");
			confirmation.setReferralId(oel.getLineItemReferralID());
			
		    Marshaller m;
			try {
				m = lineConfirmationJAXB.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				JAXBElement<OrderEquipmentLine> root =  
						new JAXBElement<OrderEquipmentLine>(new QName("", "Order_Equipment_Line"), OrderEquipmentLine.class, null, oel);
				StringWriter sw = new StringWriter();
			    m.marshal(root, sw);
			    confirmation.setLineItemOrderData(sw.toString());;
			} catch (JAXBException e) {
				throw new RuntimeException(e);
			}
			confirmation.setCreatedDate(LocalDateTime.now());
			confirmation.setModifiedDate(LocalDateTime.now());
			return confirmation;
		}).collect(Collectors.toList());
		
		order.setConfirmations(confirmations);
		orderService.save(order);
		throw new NullPointerException("Exception thrown purposefully from ThrowNullPointer");
	}
	
	public String constructErrorXML(Exchange ex) throws Exception {
		ErrorMessage errorXML = new ErrorMessage();
		errorXML.setOriginalMessage(ex.getIn().getBody().toString());
		ValidatorResponseDto dto = (ValidatorResponseDto) ex.getIn().getHeader(Constants.RESPONSE_DTO_HEADER);
		errorXML.setDetails(dto.getE().getMessage());
		errorXML.setDescription(dto.getErrorType());
		errorXML.setTimestamp(LocalDateTime.now().toString());
		errorXML.setVendor(vendor);
		errorXML.setSource(source);
	    Marshaller m = errorJAXB.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    JAXBElement<ErrorMessage> root =  new JAXBElement<ErrorMessage>(new QName("", "errorMessage"), ErrorMessage.class, null, errorXML);
	    StringWriter sw = new StringWriter();
	    CDATAContentHandler cDataContentHandler = new CDATAContentHandler(sw, "UTF-8");
	    m.marshal(root, cDataContentHandler);

	    return sw.toString();
	}

}
