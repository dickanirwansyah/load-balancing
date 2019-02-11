package com.dicka.helloservicefeign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;



@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HelloServiceFeignApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HelloServiceFeignApplication.class, args);
	}
	
	private static final Logger log = LoggerFactory.getLogger(HelloServiceFeignApplication.class);
	
	@Value("${spring.application.name}")
	private String appName;
	
	//@Autowired
	//@Lazy
	//EurekaClient eurekaClient;
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@GetMapping(value = "/")
	public String getHallo(){
		//ServiceInstance instance = (ServiceInstance) client.getServices();
		//return "hello world from : "+instance.getServiceId()+" : "+instance.getHost()+" : "
			//	+instance.getPort(); 
		log.info("routes : /");
		ServiceInstance instance = loadBalancer.choose("hello-service-feign");
		return "hello world from : "+instance.getServiceId()+" : "+instance.getHost()+" : "
			+instance.getPort();
		//return String.format("Hello from '%s' : ", 
			//	eurekaClient.getApplication(appName).getName());
	}
}

