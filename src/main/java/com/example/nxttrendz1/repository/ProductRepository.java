/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz1.repository;

import java.util.*;
import com.example.nxttrendz1.model.*;

public interface ProductRepository {
    // void deleteProduct(int productId);
    void deleteProduct(int productId);

    Product updateProduct(int productId, Product pobj);

    Product getProductById(int productId);

    Product addProduct(Product pobj);

    ArrayList<Product> getProducts();
}