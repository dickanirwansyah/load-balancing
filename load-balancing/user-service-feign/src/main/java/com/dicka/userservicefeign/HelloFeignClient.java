package com.dicka.userservicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("hello-service-feign")
public interface HelloFeignClient {

	@GetMapping(value = "/")
	String hello();
	
}
