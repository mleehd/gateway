package com.apria.gateway.validation;

import java.io.FileInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.apria.gateway.jaxb.KPOrder;


@RunWith(SpringRunner.class)
public class KaiserXMLJAXBTest {
	
	@Rule
  public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void unmarshalTest() throws Exception {
		try {
			JAXBContext jc = JAXBContext.newInstance("com.apria.gateway");
			Unmarshaller u = jc.createUnmarshaller();
			KPOrder order = (KPOrder)u.unmarshal(
			    new FileInputStream("data/kaiser/success.xml"));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void invalidDataTypeTest() throws Exception {
	}

}
