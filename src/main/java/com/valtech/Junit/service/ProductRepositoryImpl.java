package com.valtech.Junit.service;

import com.valtech.Junit.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository{
	@Override
	public List <Product> findAll() {
		return null;
	}

	@Override
	public void createProduct(Product product) {
		//nothing yet;
	}

}
