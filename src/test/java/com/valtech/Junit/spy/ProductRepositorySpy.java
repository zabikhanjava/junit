package com.valtech.Junit.spy;

import com.valtech.Junit.model.Product;
import com.valtech.Junit.service.ProductRepository;

import java.util.List;

public class ProductRepositorySpy implements ProductRepository {

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

    public int getCalledCount() {

        return calledCount;
    }
    public boolean checkcalledwithsave(Product argumentProduct)
    {
        return argumentProduct.equals(product);
    }
}
