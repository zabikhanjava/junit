package com.valtech.Junit.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

	
	@Bean
	public SomeDependency popppp()
	{
		return new SomeDependency();
	}

@Bean
public JUnitServiceImpl pop()
{
	JUnitServiceImpl j=new JUnitServiceImpl(popppp());
	return j;
	
}
}
