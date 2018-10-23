package com.apria.gateway.validation.config;

import static org.apache.camel.component.jms.JmsComponent.jmsComponentAutoAcknowledge;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQPConfiguration {

    public static final String MY_DEFAULT_PROFILE = "myDefaultProfile";
    private static final String ACTIVEMQ = "activemq";


    @Bean
    CamelContextConfiguration contextConfiguration(@Value("${spring.activemq.user}") final String user,
                                                   @Value("${spring.activemq.password}") final String password,
                                                   @Value("${spring.activemq.broker-url}") final String url) {
        return new CamelContextConfiguration() {

            public void beforeApplicationStart(CamelContext context) {
/*                // your custom configuration goes here
                ThreadPoolProfile threadPoolProfile = new ThreadPoolProfile();
                threadPoolProfile.setId(MY_DEFAULT_PROFILE);
                threadPoolProfile.setPoolSize(10);
                threadPoolProfile.setMaxPoolSize(15);
                threadPoolProfile.setMaxQueueSize(250);
                threadPoolProfile.setKeepAliveTime(25L);
                threadPoolProfile.setRejectedPolicy(ThreadPoolRejectedPolicy.Abort);
                context.getExecutorServiceManager().registerThreadPoolProfile(threadPoolProfile);*/
                ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
                context.addComponent(ACTIVEMQ, jmsComponentAutoAcknowledge(connectionFactory));
            }

			public void afterApplicationStart(CamelContext camelContext) {
				// TODO Auto-generated method stub
				
			}
        };
    }

}
