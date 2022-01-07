package com.valtech.Junit.service;

import com.valtech.Junit.dummy.EmailServiceDummy;
import com.valtech.Junit.fake.ProductRepositoryFake;
import com.valtech.Junit.mock.ProductRepositoryMock;
import com.valtech.Junit.model.Product;
import com.valtech.Junit.spy.ProductRepositorySpy;
import com.valtech.Junit.stub.ProductRepositoryStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)
public class productServiceTest {

    @Test
    public void givenProductToAddShouldReturnAddedProductFake() {
        Product product = new Product(1, "iphone");
        ProductRepository productRepository = new ProductRepositoryFake();
        ProductService productService = new ProductServiceImpl(productRepository);
        productService.createProduct(product);
        assertEquals(1,productService.findAll().size());

    }

    @Test
    public void givenProductToAddShouldReturnAddedProductDummy() {
        Product product = new Product(1, "iphone");
        ProductRepository productRepository = new ProductRepositoryFake();
        EmailService emailService = new EmailServiceDummy();
        ProductService productService = new ProductServiceImpl(productRepository,emailService);
        productService.createProduct(product);
        assertEquals(1,productService.findAll().size());
    }

    @Test
    public void givenGetAllProductsShouldReturnListOfAllProductStub() {
        ProductRepository productRepository = new ProductRepositoryStub();
        ProductService productService = new ProductServiceImpl(productRepository);
        assertEquals(1,productService.findAll().size());
    }

    @Test
    public void givenGetAllProductsShouldReturnListOfAllProductSpy() {
        Product product = new Product(1, "iphone");
        ProductRepositorySpy productRepository = new ProductRepositorySpy();
        ProductService productService = new ProductServiceImpl(productRepository);
        productService.createProduct(product);
        productService.createProduct(product);
        assertEquals(2,productRepository.getCalledCount());
        assertEquals(true,productRepository.checkcalledwithsave(product));
    }
    @Test
    public void givenGetAllProductsShouldReturnListOfAllProductMock() {
        Product product = new Product(1, "iphone");
        ProductRepositoryMock productRepository = new ProductRepositoryMock();
        ProductService productService = new ProductServiceImpl(productRepository);
        productService.createProduct(product);
        productService.createProduct(product);
        productRepository.verify(product,2);
    } @Test
    public void givenProductToAddShouldReturnAddedProductFakeWithMockito() {
        Product product = new Product(1, "iphone");
        List<Product> productListExpected=new ArrayList<>();
        productListExpected.add(product);
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        ProductService productService = new ProductServiceImpl(productRepository);
        Mockito.when(productRepository.findAll()).thenReturn(productListExpected);
        //productService.createProduct(product);
        List<Product> productListActual=productService.findAll();
        assertEquals(productListExpected,productListActual);
        assertEquals(1,productService.findProductsLength());
    }

    @Test
    public void givenProductToAddShouldReturnAddedProductDummyWithMockito() {
        Product product = new Product(1, "iphone");
        ProductRepository productRepository = new ProductRepositoryFake();
        EmailService emailService = Mockito.mock(EmailService.class);
        emailService.sendEmail();
        ProductService productService = new ProductServiceImpl(productRepository,emailService);
        productService.createProduct(product);
        assertEquals(1,productService.findAll().size());
    }

    @Test
    public void givenGetAllProductsShouldReturnListOfAllProductStubWithMockito() {
        Product product = new Product(1, "iphone");
        List<Product> productListExpected=new ArrayList<>();
        productListExpected.add(product);
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        ProductService productService = new ProductServiceImpl(productRepository);
        Mockito.when(productRepository.findAll()).thenReturn(productListExpected);
        //productService.createProduct(product);
        List<Product> productListActual=productService.findAll();
        assertEquals(productListExpected,productListActual);
        assertEquals(1,productService.findProductsLength());
    }

    @Test
    public void givenGetAllProductsShouldReturnListOfAllProductSpyWithMockito() {
        Product product = new Product(1, "iphone");
        ProductRepository productRepository = Mockito.spy(ProductRepository.class);
        ProductService productService = new ProductServiceImpl(productRepository);
        productService.createProduct(product);
        productService.createProduct(product);
        Mockito.verify(productRepository,Mockito.times(2)).createProduct(product);
    }
    @Test
    public void givenGetAllProductsShouldReturnListOfAllProductMockWithMockito() {
        Product product = new Product(1, "iphone");
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        ProductService productService = new ProductServiceImpl(productRepository);
        productService.createProduct(product);
        productService.createProduct(product);
        Mockito.verify(productRepository,Mockito.times(2)).createProduct(product);
    }
}