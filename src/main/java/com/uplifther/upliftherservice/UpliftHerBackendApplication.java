package com.uplifther.upliftherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "id.passageidentity.passage4j")
public class UpliftHerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpliftHerBackendApplication.class, args);
	}

}
