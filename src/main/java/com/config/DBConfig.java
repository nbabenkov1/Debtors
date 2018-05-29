package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by N.Babenkov on 19.04.2018.
 **/
@Configuration
@PropertySource("classpath:oracle.properties")
public class DBConfig {
    @Value("${ds.driverClassName}")
    String driverClassName;
    @Value("${ds.url}")
    String url;
    @Value("${ds.user}")
    String userName;
    @Value("${ds.pass}")
    String pass;

    @Bean
    public DriverManagerDataSource dataSource (){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url,userName,pass);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
