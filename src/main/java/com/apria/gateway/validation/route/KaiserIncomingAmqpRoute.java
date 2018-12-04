package com.apria.gateway.validation.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.apria.gateway.validation.app.Constants;

@Component
public class KaiserIncomingAmqpRoute extends RouteBuilder {


	@Override
	public void configure() throws Exception {
		
		from("activemq:EDIOrder").id("readXMLFromEDIOrderQueueRoute")
			.setHeader(Constants.ORDER_TYPE_HEADER, simple("NEW_ORDER"))
			.to("direct:processMessage");	

	}

}
