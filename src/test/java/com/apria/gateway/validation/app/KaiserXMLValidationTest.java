package com.apria.gateway.validation.app;

import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.SAXParseException;

import com.apria.gateway.validation.app.EDIOrderService;
import com.apria.gateway.validation.app.KaiserXMLValidatorImpl;
import com.apria.gateway.validation.app.XMLValidator;
import com.apria.gateway.validation.app.exception.DuplicateOrderIdException;
import com.apria.gateway.validation.config.XMLValidationConfiguration;
import com.apria.gateway.validation.model.EDIOrder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { XMLValidationConfiguration.class, 
		KaiserXMLValidatorImpl.class

	})
public class KaiserXMLValidationTest {

	@Autowired
	XMLValidator xmlValidator;
    
    @MockBean
    private EDIOrderService ediOrderService;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        EDIOrder order = new EDIOrder();
        order.setEdiOrderId("GDUPLICATE290");
     
        Mockito.when(ediOrderService.findByEDIOrderId("GDUPLICATE290")).thenReturn(order);
    }
	
    @Test
	public void successTest() throws Exception {
		try {
			Path inputPath = Paths.get(getClass().getClassLoader().getResource("data/kaiser/success.xml").toURI());
			String input = new String(Files.readAllBytes(inputPath));
			xmlValidator.validate(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void schemaViolationTest() throws Exception {
		//exception.expect(SAXParseException.class);
		Path inputPath = Paths.get(getClass().getClassLoader().getResource("data/kaiser/invalid.xml").toURI());
		String input = new String(Files.readAllBytes(inputPath));
		ValidatorResponseDto dto = xmlValidator.validate(input);
		assertEquals("SCHEMA_VIOLATION", dto.getErrorType());
	}
	
	@Test
	public void duplicateOrderIdTest() throws Exception {
		//exception.expect(DuplicateOrderIdException.class);
		Path inputPath = Paths.get(getClass().getClassLoader().getResource("data/kaiser/duplicate_orderid.xml").toURI());
		String input = new String(Files.readAllBytes(inputPath));
		ValidatorResponseDto dto = xmlValidator.validate(input);
		assertEquals("DUPLICATE_ORDER", dto.getErrorType());
	}
	
	//@Test
	public void notWellformedXMLTest() throws Exception {
		Path inputPath = Paths.get(getClass().getClassLoader().getResource("data/kaiser/notwellformed.xml").toURI());
		String input = new String(Files.readAllBytes(inputPath));
		ValidatorResponseDto dto = xmlValidator.validate(input);
		assertEquals("NOTWELLFORMED_XML", dto.getErrorType());
	}

}
