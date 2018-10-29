package com.apria.gateway.validation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class PropertyConfiguration {

	@Configuration
	@Profile("!localhost")
	@PropertySource({
		"file:/data/validation/configuration.properties"
	})
	public class NonLocalhostConfiguration {
		
	}
	
	@Configuration
	@Profile("localhost")
	@PropertySource({
		"classpath:localhost/configuration.properties"
	})
	public class LocalhostConfiguration {
		
	}
}
