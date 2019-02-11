package com.dicka.helloserviceribbon;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloServiceRibbonApplication {

	private static Logger log = LoggerFactory.getLogger(HelloServiceRibbonApplication.class);
	
	@GetMapping(value = "/greet")
	public String getGreet(){
		log.info("access routes :/greet");
		List<String> greets = Arrays.asList("hello", "assalamualaikum", "apakabar");
		Random random = new Random();
		int rand = random.nextInt(greets.size());
		return greets.get(rand);
	}
	
	@GetMapping(value = "/")
	public String getHallo(){
		log.info("access routes :/");
		return "Hi !!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HelloServiceRibbonApplication.class, args);
	}
}

