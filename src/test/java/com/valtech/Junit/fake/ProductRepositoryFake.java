package com.valtech.Junit.fake;


import com.valtech.Junit.model.Product;
import com.valtech.Junit.service.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryFake implements ProductRepository {

    List <Product> productList=new ArrayList();

    @Override
    public List <Product> findAll() {

        return productList;
    }

    @Override
    public void createProduct(Product product) {

        this.productList.add(product);
    }
}
