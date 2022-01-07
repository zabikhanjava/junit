package com.valtech.Junit.service;


import com.valtech.Junit.model.Product;

import java.util.List;

public interface ProductRepository   {
    List<Product> findAll();
    void createProduct(Product product);
}
