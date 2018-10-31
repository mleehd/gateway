package com.apria.gateway.validation.app;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import com.apria.gateway.jaxb.KPOrder;

@RunWith(SpringRunner.class)
public class KaiserXMLJAXBTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void unmarshalTest() throws Exception {
		try {
			JAXBContext jc = JAXBContext.newInstance("com.apria.gateway.jaxb");
			Unmarshaller u = jc.createUnmarshaller();
			InputStream is = new ClassPathResource("/data/kaiser/success.xml").getInputStream();
			KPOrder order = ((JAXBElement<KPOrder>) u.unmarshal(is)).getValue();
			assertEquals(order.getOrderHeader().getOrder().getVendorID().getContent(), "Apria");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void invalidDataTypeTest() throws Exception {
	}

}
