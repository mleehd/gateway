package com.apria.gateway.validation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apria.gateway.validation.app.GatewayVendorEnum;
import com.apria.gateway.validation.app.XMLValidator;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Resource(name="xmlValidators")
	Map<String, XMLValidator> xmlValidators;
	
	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);

	}

	public void run(String... args) throws Exception {

		XMLValidator validator = xmlValidators.get(GatewayVendorEnum.KAISER);
		Path inputPath = Paths.get("/users/vkonda/tmp/sample.xml");
		String input = new String(Files.readAllBytes(inputPath));
		validator.validate(input);
		System.out.println("********Successfully validated XML***********");
	}
}
