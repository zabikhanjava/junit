package com.valtech.Junit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JUnitServiceImpl implements JUnitService {

	SomeDependency someDependency;

	/*
	 * @Autowired JUnitServiceImpl() { this.someDependency = someDependency; }
	 */
	public String pop() {
		return someDependency.display();

	}

}
