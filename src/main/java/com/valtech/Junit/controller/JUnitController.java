package com.valtech.Junit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.Junit.service.JUnitService;

@RestController
public class JUnitController {

	@Autowired
	JUnitService jUnitService;

	@RequestMapping(value = "/some", method = RequestMethod.GET)
	public String someStringSend() {
		return jUnitService.pop();

	}
}
