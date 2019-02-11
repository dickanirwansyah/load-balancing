package com.dicka.userserviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class ConfigurationRibbon {

	@Autowired
	private IClientConfig ribbonConfigClient;
	
	@Bean
	public IPing ribbonPing(IClientConfig clientConfig){
		return new PingUrl();
	}
	
	@Bean
	public IRule ribbonRule(IClientConfig ruleConfig){
		return new AvailabilityFilteringRule();
	}
}
