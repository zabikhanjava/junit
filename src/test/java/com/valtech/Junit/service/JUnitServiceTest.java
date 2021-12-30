package com.valtech.Junit.service;

import org.apache.tomcat.util.descriptor.web.Injectable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,loader=AnnotationConfigContextLoader.class)
public class JUnitServiceTest {
	/*
	 * @Mock SomeDependency someDependency;
	 * 
	 * @InjectMocks
	 */
	@Autowired
	JUnitServiceImpl jUnitService;

	@Test
	public void popTest() {
		// when(someDependency.display()).thenReturn("thank you");
		String testName = jUnitService.pop();
		assertEquals("thank you", testName);
	}
}