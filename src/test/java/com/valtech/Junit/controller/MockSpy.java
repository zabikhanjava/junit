package com.valtech.Junit.controller;

import com.valtech.Junit.dummy.EmailServiceDummy;
import com.valtech.Junit.fake.ProductRepositoryFake;
import com.valtech.Junit.mock.ProductRepositoryMock;
import com.valtech.Junit.model.Product;
import com.valtech.Junit.spy.ProductRepositorySpy;
import com.valtech.Junit.stub.ProductRepositoryStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)//SpringExtension.class)

public class MockSpy {

	@Mock
	private List<String> mockList;

	@Spy
	private List<String> spyList = new ArrayList();

	@Test
	public void testMockList() {
		//by default, calling the methods of mock object will do nothing
		mockList.add("test");

		Mockito.verify(mockList).add("test");
		assertEquals(0, mockList.size());
		assertNull(mockList.get(0));
	}

	@Test
	public void testSpyList() {
		//spy object will call the real method when not stub
		spyList.add("test");

		Mockito.verify(spyList).add("test");
		assertEquals(1, spyList.size());
		assertEquals("test", spyList.get(0));
	}

	@Test
	public void testMockWithStub() {
		//try stubbing a method
		String expected = "Mock 100";
		when(mockList.get(100)).thenReturn(expected);

		assertEquals(expected, mockList.get(100));
	}

	@Test
	public void testSpyWithStub() {
		//stubbing a spy method will result the same as the mock object
		String expected = "Spy 100";
		//take note of using doReturn instead of when
		doReturn(expected).when(spyList).get(100);

		assertEquals(expected, spyList.get(100));
	}
}