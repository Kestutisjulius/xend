package com.javavilnius10.controller;

import com.javavilnius10.exception.ProductNotFoundException;
import com.javavilnius10.model.Product;
import com.javavilnius10.model.SalesLine;
import com.javavilnius10.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = productService.findAllProduct();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Product>getProductById(@PathVariable Long id) throws ProductNotFoundException {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.FOUND);
    }
    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        Product product = productService.findProductByName(name);
        return  new ResponseEntity<>(product, HttpStatus.FOUND);
    }
    @PostMapping()
    public ResponseEntity<Void>addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<Void>updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
