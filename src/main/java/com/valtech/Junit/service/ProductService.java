package com.valtech.Junit.service;

import com.valtech.Junit.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProductService {

	List<Product> findAll();
	void createProduct(Product product);
	public int findProductsLength();
}
