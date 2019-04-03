package com.qa.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PlanControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanControllerApplication.class, args);
	}

}
