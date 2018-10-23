package com.apria.gateway.validation.config;

import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xml.sax.SAXException;

import com.apria.gateway.validation.app.GatewayVendorEnum;
import com.apria.gateway.validation.app.KaiserXMLValidator;
import com.apria.gateway.validation.app.XMLValidator;

@Configuration
public class XMLValidationConfiguration {
	
	@Value("${kaiser_inbound_xmlschema_path}")
	private String schemaPath;

	@Autowired
	KaiserXMLValidator xmlValidator;
	
	@Bean
	public Schema schemaBean() throws SAXException {
		final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		final Source xsdSource = new StreamSource(getClass().getClassLoader().getResourceAsStream(schemaPath));
		final Schema schema = schemaFactory.newSchema(xsdSource);

		return schema;
	}
	
	@Bean(name="xmlValidators")
	public Map<GatewayVendorEnum, XMLValidator> XMLValidatorBean() {
		Map<GatewayVendorEnum, XMLValidator> map = new HashMap<GatewayVendorEnum, XMLValidator>() { 
				{
					put(GatewayVendorEnum.KAISER, xmlValidator);
				}
		};
		
		return map;
	}
	
}
