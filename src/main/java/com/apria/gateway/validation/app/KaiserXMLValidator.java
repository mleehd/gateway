package com.apria.gateway.validation.app;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

@Component(value="kaiserXMLValidator")
public class KaiserXMLValidator implements XMLValidator {

	@Autowired
	Schema schema;
	
	@Override
	public void validate(String xml) throws SAXException, IOException {
		Source source = new StreamSource(new StringReader(xml));

		Validator validator = schema.newValidator();
		validator.validate(source);
	}

}
