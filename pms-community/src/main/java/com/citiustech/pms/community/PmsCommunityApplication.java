package com.citiustech.pms.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PmsCommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmsCommunityApplication.class, args);
	}

}
