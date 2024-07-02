package com.pykube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PykubeBootMain {

	public static void main(String[] args) {
        SpringApplication.run(PykubeBootMain.class, args);
    }
	
}
