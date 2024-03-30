/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.nxttrendz1.controller;

import com.example.nxttrendz1.model.*;
import com.example.nxttrendz1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ProductController {

    @Autowired
    public ProductJpaService jservice;

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId) {
        jservice.deleteProduct(productId);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product pobj) {
        return jservice.updateProduct(productId, pobj);
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable("productId") int productId) {
        return jservice.getProductById(productId);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product pobj) {
        return jservice.addProduct(pobj);
    }

    @GetMapping("/products")
    public ArrayList<Product> getProducts() {
        return jservice.getProducts();
    }

}