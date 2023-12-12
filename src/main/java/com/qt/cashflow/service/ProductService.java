package com.qt.cashflow.service;



import com.qt.cashflow.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product addProduct(Product product);

    Product updateProduct(Long id, Product product);
}

























//    Product getProductById(Long id);
//    Product updateProduct(Long id, Product product);
//    void deleteProduct(Long id);