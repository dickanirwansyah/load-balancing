package com.dicka.springcloudoauth2security;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableOAuth2Sso
public class EmployeeController extends WebSecurityConfigurerAdapter{

	/** konfigurasi security **/
	@Override
	public void configure(HttpSecurity security) throws Exception {
		security.authorizeRequests()
			.antMatchers("/", "/emp").permitAll()
			.anyRequest().authenticated();
	}
	
	/** test **/
	@Autowired
	private OAuth2ClientContext clientContext;

	Map<String, Employee> empMap = new HashMap<String, Employee>();
	
	/** mendapatkan token untuk resource server **/
	@RequestMapping(value = "/acc_token", method = RequestMethod.GET)
	public String getToken(){
		String token = clientContext.getAccessToken().getValue();
		System.out.println("access_token : "+token);
		return token;
	}
	
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public Collection<Employee> getEmployees(){
		if (ObjectUtils.isEmpty(empMap)){
			empMap.put("1", new Employee("emp001", "muhammad dicka nirwansyah", "software engineer", 600000));
			empMap.put("2", new Employee("emp002", "denada rosa florina", "teacher", 350000));
			empMap.put("3", new Employee("emp003", "adelia syiva tiara", "public speaking", 400000));
		}
		return empMap.values();
	}
	
	@RequestMapping(value = "/emp/{empId}")
	public Collection<Employee> getEmployees2(@PathVariable("empId") String empId){
		empMap.put(empId, new Employee("emp002", "denada rosa florina", "teacher", 350000));
		return empMap.values();
	}
}
