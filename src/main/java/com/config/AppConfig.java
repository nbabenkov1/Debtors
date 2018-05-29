package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by N.Babenkov on 19.04.2018.
 **/
@Configuration
@ComponentScan({"com.dao", "com.repository", "com.service"})
@PropertySource("/resources/config.properties")
@Import(DBConfig.class)
public class AppConfig {
}
