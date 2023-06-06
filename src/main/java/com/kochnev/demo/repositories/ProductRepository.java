package com.kochnev.demo.repositories;

import com.kochnev.demo.constatns.ProductType;
import com.kochnev.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByProductType(ProductType productType);
}
