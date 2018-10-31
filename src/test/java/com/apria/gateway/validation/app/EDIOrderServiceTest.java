package com.apria.gateway.validation.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.apria.gateway.validation.config.XMLValidationConfiguration;
import com.apria.gateway.validation.dao.EDIOrderRepository;
import com.apria.gateway.validation.model.EDIOrder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { EDIOrderServiceImpl.class
	})
public class EDIOrderServiceTest {

    @Autowired
    private EDIOrderService ediOrderService;
 
    @MockBean
    private EDIOrderRepository ediOrderRepository;
    
    @Before
    public void setUp() {
        EDIOrder order = new EDIOrder();
        order.setEdiOrderId("10001");
     
        Mockito.when(ediOrderRepository.findByediOrderId(order.getEdiOrderId()))
          .thenReturn(order);
    }
    
    @Test
    public void validOrderIdTest() {
    	EDIOrder found = ediOrderService.findByEDIOrderId("10001");
      
         assertEquals(found.getEdiOrderId(), "10001");
     }
}
