package com.dicka.userserviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "hello-service-ribbon", 
		configuration = ConfigurationRibbon.class)
public class UserServiceRibbonApplication {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate templateForClient;
	
	@GetMapping(value = "/hi")
	public String getConsumeHelloService(@RequestParam(value = "name") String name){
		String greeting = templateForClient
				.getForObject("http://hello-service-ribbon/greet", String.class);
		return String.format("%s, %s", greeting, name);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceRibbonApplication.class, args);
	}
}

