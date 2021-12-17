package com.valtech.Junit.service;

import org.apache.tomcat.util.descriptor.web.Injectable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JUnitServiceTest { 

	/*
	 * @BeforeEach public void setup() { this.someDependency = new SomeDependency();
	 * }
	 */
	//@Mock
	//SomeDependency someDependency=new SomeDependency();
	
	//@InjectMocks
	JUnitService jUnitService=new JUnitServiceImpl();


	@Test
	public void popTest() {
		//when(someDependency.display()).thenReturn("sss");
		String testName = jUnitService.pop();
		assertEquals("thank you", testName);
	}
}