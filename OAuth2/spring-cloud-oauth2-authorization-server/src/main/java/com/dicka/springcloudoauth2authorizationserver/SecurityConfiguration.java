package com.dicka.springcloudoauth2authorizationserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends GlobalAuthenticationConfigurerAdapter{

	/** spring security 5 **/
	
	public void init(AuthenticationManagerBuilder authBuilder) throws Exception{
		authBuilder.inMemoryAuthentication()
			.withUser("dicka")
			/** default in memory gunakan {noop} **/
			.password("{noop}secret")
			.roles("USER", "ADMIN")
				.and()
			.withUser("denada")
			.password("{noop}denada")
			.roles("USER");
	}
}
