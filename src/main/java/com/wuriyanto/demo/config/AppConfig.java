package com.wuriyanto.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);
    
    @Autowired
    Environment env;
    
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer () {
        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {

            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setContextPath("");
                factory.setPort(Integer.parseInt(env.getRequiredProperty("HTTP_PORT")));
            }
            
        };
    }
}