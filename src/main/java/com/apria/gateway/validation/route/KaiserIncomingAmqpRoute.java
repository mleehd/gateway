package com.apria.gateway.validation.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.apria.gateway.validation.app.IncomingRouterBean;
import com.apria.gateway.validation.app.exception.DuplicateOrderIdException;

@Component
public class KaiserIncomingAmqpRoute extends RouteBuilder {

	@Autowired
	IncomingRouterBean routerBean;

	@Override
	public void configure() throws Exception {
		
		onException(SAXException.class, DuplicateOrderIdException.class)
			.handled(true)
			.setHeader("exception_message", simple("${exception.message}"))
			.multicast()
				.parallelProcessing()
				.to("direct:sendEmail", "direct:sendErrorXML")
				.end()
		;
			
		from("direct:sendEmail")
			.log("Invalid XML -> ${headers.errorType}")
			.to("velocity:templates/emailNotification.vm")
			.log("*******Email Message is-------->${body}")
/*			.to("smtps://{{smtp.host}}:{{smtp.port}}"
				+ "?username={{emailNotification.noReply.fromEmail}}&password={{emailNotification.password}}"
				+ "&to={{emailNotification.error.toEmail}}")*/
		;
		
		from("direct:sendErrorXML")
			.bean(routerBean, "constructErrorXML")
			.log("*******Error XML is-------->${body}")
			//TODO: Send Error XML message to Error Queue
		;
		
		from("activemq:EDIOrder")
			.id("readXMLFromEDIOrderQueueRoute")
			.bean(routerBean, "validateXML")
			.log("*****Validated the XML***********")
			;
		 //TODO: Send the Kaiser XML to AMQ Queue for further processing
	}

}
