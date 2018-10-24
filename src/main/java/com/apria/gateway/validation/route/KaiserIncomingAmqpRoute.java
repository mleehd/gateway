/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
			.setHeader("subject", constant("Invalid XML from Kaiser"))
			.to("smtps://{{smtp.host}}:{{smtp.port}}"
					+ "?username={{emailNotification.noReply.fromEmail}}&password={{emailNotification.password}}"
					+ "&to={{emailNotification.error.toEmail}}")
			;
		
		from("activemq:neworder.queue")
			.id("readXMLFromNewOrderQueueRoute")
			.bean(routerBean, "validateXML")
			.log("*****Validated the XML***********")
			;
	}

}
