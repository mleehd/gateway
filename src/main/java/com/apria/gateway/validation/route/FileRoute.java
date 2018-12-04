package com.apria.gateway.validation.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
    	from("file:/users/vkonda/inbox")
			.routeId("readDataFromFile")
			.log("*******Read content from file ${body}")
			;
		 //TODO: Send the Kaiser XML to AMQ Queue for further processing
	}

}
