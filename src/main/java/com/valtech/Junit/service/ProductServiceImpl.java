package com.valtech.Junit.service;

import com.valtech.Junit.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


	@Autowired
	ProductRepository productRepository;
	@Autowired
	EmailService emailService;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public void createProduct(Product product) {
		productRepository.createProduct(product);
	}

	@Override
	public int findProductsLength() {
		return productRepository.findAll().size();
	}

	/*public ProductServiceImpl(ProductRepository productRepository, EmailService emailService) {
		this.productRepository = productRepository;
		this.emailService=emailService;
	}*/

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ProductServiceImpl(EmailService emailService) {
		this.emailService = emailService;
	}

	public ProductServiceImpl(ProductRepository productRepository, EmailService emailService) {
		this.productRepository = productRepository;
		this.emailService = emailService;
	}

	public ProductServiceImpl() {
	}
}
