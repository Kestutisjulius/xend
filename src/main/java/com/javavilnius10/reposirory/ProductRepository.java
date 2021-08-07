package com.javavilnius10.reposirory;

import com.javavilnius10.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.productName = ?1")
    Product getProductByProductName(String name);

    void deleteProductById(Long id);
}