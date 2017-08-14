package com.restu.labs;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@ComponentScan
public class SpringBootWebApplication {
	final static Logger logger = Logger.getLogger(SpringBootWebApplication.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}
