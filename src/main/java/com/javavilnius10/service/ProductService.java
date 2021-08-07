package com.javavilnius10.service;

import com.javavilnius10.exception.ProductNotFoundException;
import com.javavilnius10.model.Product;
import com.javavilnius10.reposirory.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }
    public void addProduct(Product product) {
        productRepository.save(product);
    }
    public Product findProductById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id: " + id + " -> not exist!"));
    }
    public void updateProduct(Product product) {
        productRepository.save(product);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteProductById(id);
    }

    public Product findProductByName(String name)  {
        return productRepository.getProductByProductName(name);
    }
}
