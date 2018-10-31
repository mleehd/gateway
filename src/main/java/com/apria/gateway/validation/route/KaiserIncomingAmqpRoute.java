package com.apria.gateway.validation.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apria.gateway.validation.app.IncomingRouterBean;

@Component
public class KaiserIncomingAmqpRoute extends RouteBuilder {

	@Autowired
	IncomingRouterBean routerBean;

	@Override
	public void configure() throws Exception {
		
		onException(Exception.class)
			.handled(true)
			//TODO: Multicast the error XML to errorQueue and send email
			.setHeader("subject", constant("Invalid XML from Kaiser"))
			.to("smtps://{{smtp.host}}:{{smtp.port}}"
					+ "?username={{emailNotification.noReply.fromEmail}}&password={{emailNotification.password}}"
					+ "&to={{emailNotification.error.toEmail}}")
			;
		
		from("activemq:EDIOrder")
			.id("readXMLFromNewOrderQueueRoute")
			//TODO: Save it in JDG/Infinispan
			.bean(routerBean, "validateXML")
			.log("*****Validated the XML***********")
			;
		  //TODO: Call the service that does transformation
	}

}
