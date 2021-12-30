package com.valtech.Junit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JUnitServiceImpl implements JUnitService {

	@Autowired
	SomeDependency someDependency;

	public String pop() {
		return someDependency.display();

	}

	JUnitServiceImpl(SomeDependency someDependency) {
		this.someDependency = someDependency;
	}
	JUnitServiceImpl() {
		this.someDependency = someDependency;
	}
}
