package com.apria.gateway.validation.dao;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class HikariDataSourceTest {
    @Autowired
    private DataSource dataSource;
    
    @TestConfiguration
	static class Data {
		@Bean
		public DataSource dataSource() {
			return DataSourceBuilder.create().username("").password("").url("").driverClassName("").build();
		}
	}

    @Test
    public void hikariConnectionPoolIsConfigured() {
        assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.getClass().getName());
    }
}
