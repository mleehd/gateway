package com.apria.gateway.validation.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.apria.gateway.validation.app.Constants;
import com.apria.gateway.validation.app.IncomingRouterBean;
import com.apria.gateway.validation.app.exception.DuplicateOrderIdException;

@Component
public class ProcessMessageRoute extends RouteBuilder {

	@Autowired
	IncomingRouterBean routerBean;

	@SuppressWarnings("unchecked")
	@Override
	public void configure() throws Exception {
		
		onException(Exception.class)
			.handled(true)
			.log("****Exception occured. Body is ${body}")
			.to("activemq:EDIOrderError")
			;
		
		JaxbDataFormat jaxbDataFormat = new JaxbDataFormat();
		jaxbDataFormat.setContextPath("com.apria.gateway.jaxb");
			
		from("direct:processMessage")
			.doTry().id("do-try-bean-validator")
				.bean(routerBean, "validateXML")
				.setHeader(Constants.ORDER_MSG_STRING_HEADER, simple("${body}"))
				.unmarshal(jaxbDataFormat)
				.log("Message is -> ${body}")
				.bean(routerBean, "saveXMLMessageToDB")
			.doCatch(SAXException.class, DuplicateOrderIdException.class)
				.log("***Exceptin thrown ****. Exception is --> ${exception.message}.")
				.to("direct:validation-error-route").routeId("validation-error-route")
			.doCatch(Exception.class)
				.log("***Generic Exceptin thrown ****. Exception is --> ${exception.message}.")
				.to("activemq:EDIOrderError")
			.endDoTry()
			.doFinally()
			.end()
			.log("*****Validated the XML***********")
		;
		
		from("direct:validation-error-route")
			.routeId("validation-error-route").routeDescription("validation-error-route")
			.id("commhub-mq-error-route").description("validation-error-route")
		.multicast()
			.parallelProcessing()
			.routeId("direct:validation-error-route->multicast->parallelprocessing")
			.to("direct:sendErrorEmail", "direct:sendErrorXML").routeId("to:direct:sendErrorEmail,direct:sendErrorXML")
		.end()
		;
		
		from("direct:sendErrorEmail")
		.log("Invalid XML -> ${headers.errorType}")
		.to("velocity:templates/emailNotification.vm")
		.log("*******Email Message is-------->${body}")
/*			.to("smtps://{{smtp.host}}:{{smtp.port}}"
			+ "?username={{emailNotification.noReply.fromEmail}}&password={{emailNotification.password}}"
			+ "&to={{emailNotification.error.toEmail}}")*/
		;
	
		from("direct:sendErrorXML")
			.bean(routerBean, "ThrowNullPointer")
			.log("*******Error XML is-------->${body}")
	
		;
		
	}

}
