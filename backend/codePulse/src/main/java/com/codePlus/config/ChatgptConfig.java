package com.codePlus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ChatgptConfig {
	
	@Bean
	public RestTemplate template() {
	   return new RestTemplate();
	}


}
