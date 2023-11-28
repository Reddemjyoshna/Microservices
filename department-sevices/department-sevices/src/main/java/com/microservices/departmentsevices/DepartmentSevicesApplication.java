package com.microservices.departmentsevices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class DepartmentSevicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentSevicesApplication.class, args);
	}

}
