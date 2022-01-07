package com.valtech.Junit.mock;

import com.valtech.Junit.model.Product;
import com.valtech.Junit.service.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRepositoryMock implements ProductRepository {

    int calledCount = 0;
    Product product;

    @Override
    public List<Product> findAll() {

        return null;
    }

    @Override
    public void createProduct(Product product) {

        calledCount++;
        this.product = product;
    }
    public void verify(Product productCheck,int times)
    {
        assertEquals(times,calledCount);
        assertEquals(product,productCheck);
    }
}