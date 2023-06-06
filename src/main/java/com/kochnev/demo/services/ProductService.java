package com.kochnev.demo.services;

import com.kochnev.demo.constatns.ProductType;
import com.kochnev.demo.entities.Product;
import com.kochnev.demo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByType (ProductType productType) {
        return productRepository.findByProductType(productType);
    }
}

