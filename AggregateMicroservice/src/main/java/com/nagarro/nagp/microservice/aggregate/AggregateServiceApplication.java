package com.nagarro.nagp.microservice.aggregate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication

public class AggregateServiceApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(AggregateServiceApplication.class, args);

	}
	
	@Bean(name = "restTemp")
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
