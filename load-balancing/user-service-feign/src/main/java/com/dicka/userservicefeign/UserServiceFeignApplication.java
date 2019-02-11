package com.dicka.userservicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class UserServiceFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceFeignApplication.class, args);
	}

	@Autowired
	private HelloFeignClient feignClient;
	
	@GetMapping(value = "/")
	public String getHallo(){
		return feignClient.hello();
	}
}

