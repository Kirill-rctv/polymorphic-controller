package com.kochnev.demo.controllers;

import com.kochnev.demo.constatns.ProductType;
import com.kochnev.demo.entities.Product;
import com.kochnev.demo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping("/new")
    @Transactional
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") UUID id) {
        Optional<Product> productData = productService.findById(id);

        try {
            if (productData.isPresent()) {
                return new ResponseEntity<>(productData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Product> updateById(@PathVariable("id") UUID id, @RequestBody Product product) {
        Optional<Product> productData = productService.findById(id);

        try {
            if (productData.isPresent() &&
                    (productData.get().getId() == product.getId() &&
                            productData.get().getClass().equals(product.getClass()))) {
                return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") UUID id) {
        try {
            productService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getByProductType(@RequestParam("productType") ProductType productType) {
        return new ResponseEntity<>(productService.findByType(productType), HttpStatus.OK);
    }
}

