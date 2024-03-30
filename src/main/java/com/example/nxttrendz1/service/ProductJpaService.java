/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.nxttrendz1.service;

import com.example.nxttrendz1.repository.*;
import com.example.nxttrendz1.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductJpaService implements ProductRepository {
    @Autowired
    private ProductJpaRepository jrepository;

    @Override
    public void deleteProduct(int productId) {
        try {
            jrepository.deleteById(productId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Product updateProduct(int productId, Product pobj) {
        try {
            Product tobj = jrepository.findById(productId).get();
            if (pobj.getProductName() != null)
                tobj.setProductName(pobj.getProductName());
            if (pobj.getPrice() != 0.0)
                tobj.setPrice(pobj.getPrice());
            jrepository.save(tobj);
            return tobj;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product getProductById(int productId) {
        try {
            return jrepository.findById(productId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product addProduct(Product pobj) {
        jrepository.save(pobj);
        return pobj;
    }

    @Override
    public ArrayList<Product> getProducts() {
        List<Product> plist = jrepository.findAll();
        ArrayList<Product> palist = new ArrayList<>(plist);
        return palist;
    }
}