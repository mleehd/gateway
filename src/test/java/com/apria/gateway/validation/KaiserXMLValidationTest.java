package com.apria.gateway.validation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.SAXParseException;

import com.apria.gateway.validation.app.GatewayVendorEnum;
import com.apria.gateway.validation.app.XMLValidator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KaiserXMLValidationTest {

	@Resource(name="xmlValidators")
	Map<String, XMLValidator> xmlValidators;
	
	@Rule
  public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void successTest() throws Exception {
		try {
			XMLValidator validator = xmlValidators.get(GatewayVendorEnum.KAISER);
			Path inputPath = Paths.get(getClass().getClassLoader()
			     .getResource("data/kaiser/success.xml").toURI());
			String input = new String(Files.readAllBytes(inputPath));
			validator.validate(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void invalidDataTypeTest() throws Exception {
		exception.expect(SAXParseException.class);
		
		XMLValidator validator = xmlValidators.get(GatewayVendorEnum.KAISER);
		Path inputPath = Paths.get(getClass().getClassLoader().getResource("data/kaiser/invalid_datatype.xml").toURI());
		String input = new String(Files.readAllBytes(inputPath));
		validator.validate(input);
			
	}

}
