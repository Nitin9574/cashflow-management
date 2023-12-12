package com.qt.cashflow.service;



import com.qt.cashflow.entity.Product;
import com.qt.cashflow.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProductOptional = productRepository.findById(id);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            // Update properties of existingProduct with values from updatedProduct
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setImage(updatedProduct.getImage());
            existingProduct.setCreated_date(updatedProduct.getCreated_date());
            existingProduct.setProduct_code(updatedProduct.getProduct_code());

            return productRepository.save(existingProduct);
        } else {
            throw new IllegalArgumentException("Product not found");
        }
    }

}






















        //    @Override
//    public Product updateProduct(Long id, Product product) {
//        if (productRepository.existsById(id)) {
//            product.setProduct_id(id);
//            return productRepository.save(product);
//        } else {
//            return "product does not exist"; // Handle the case where the product with the given id doesn't exist.
//        }
//    }

//    @Override
//    public Product getProductById(Long id) {
//        return productRepository.findById(id).orElse(null);
//    }

//    @Override
//    public void deleteProduct(Long id) {
//        productRepository.deleteById(id);
//    }