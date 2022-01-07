package com.valtech.Junit.stub;

import com.valtech.Junit.model.Product;
import com.valtech.Junit.service.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryStub implements ProductRepository {

	List<Product> productList=new ArrayList();

	@Override
	public List <Product> findAll() {

		Product product = new Product(1, "iphone");
		productList.add(product);
		return productList;
	}

	@Override
	public void createProduct(Product product) {

		this.productList.add(product);
	}
}
