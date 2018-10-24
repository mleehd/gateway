package com.apria.gateway.validation.app;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.camel.Body;
import org.springframework.stereotype.Component;

@Component
public class IncomingRouterBean {

	@Resource(name = "xmlValidators")
	Map<String, XMLValidator> xmlValidators;

	public void validateXML(@Body String body) throws Exception {
		// TODO: Evaluate body and fork the logic. For now, it will always use Kaiser
		// Validator
		XMLValidator validator = xmlValidators.get(GatewayVendorEnum.KAISER);
		validator.validate(body);
	}

	public void handleException(@Body String body) {
		//TODO: Send email
	}
}
