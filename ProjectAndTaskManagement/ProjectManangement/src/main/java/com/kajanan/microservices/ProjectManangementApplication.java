package com.kajanan.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages="com.kajanan.microservices.commonmodel.project.Project")

public class ProjectManangementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManangementApplication.class, args);
	}

}
