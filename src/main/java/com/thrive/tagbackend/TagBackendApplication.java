package com.thrive.tagbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TagBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TagBackendApplication.class, args);
	}

}
