package com.valtech.Junit.controller;

import com.valtech.Junit.model.Product;
import com.valtech.Junit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JUnitController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getProduct() {
		return productService.findAll();
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public void ad(@RequestBody Product product) {
		productService.createProduct(product);
	}
}
