package com.valtech.Junit.service;

import com.valtech.Junit.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TestConfig {


    @Bean
    public ProductRepository someDependencyInterfaceInstance() {
        return new ProductRepositoryImpl();
    }
    @Bean
    public EmailService emailServiceInstance() {
        return new EmailServiceImpl();
    }

    @Bean
    public ProductService pop() {
        ProductService productService = new ProductServiceImpl(someDependencyInterfaceInstance(),emailServiceInstance());
        return productService;

    }
}

