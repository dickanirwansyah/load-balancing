package com.dicka.springcloudoauth2resourceserver;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableResourceServer
@RestController
public class SpringCloudOauth2ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOauth2ResourceServerApplication.class, args);
	}

	private Map<Integer, Account> mapAccount = new HashMap<Integer, Account>();
	
	@RequestMapping(value = "/acc")
	public Collection<Account> getAccountDetails(){
		if(ObjectUtils.isEmpty(mapAccount)){
			mapAccount.put(123, new Account(123, "savings account", "dicka", "BCA"));
			mapAccount.put(124, new Account(124, "primary account", "denada", "Mandiri"));
			mapAccount.put(125, new Account(124, "savings account", "sita", "CIMB"));
		}
		return mapAccount.values();
	}
}

