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

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.*;

@Service
public class ReviewJpaService implements ReviewRepository {

    @Autowired
    private ReviewJpaRepository jrepository;
    @Autowired
    private ProductJpaRepository pjrepository;

    @Override
    public Product getProductOfReviewId(int reviewId) {
        try {
            Review robj = jrepository.findById(reviewId).get();
            Product pobj = robj.getProduct();
            return pobj;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteReview(int reviewId) {
        try {
            jrepository.deleteById(reviewId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Review updateReview(int reviewId, Review robj) {
        try {
            Review trobj = jrepository.findById(reviewId).get();
            if (robj.getReviewContent() != null)
                trobj.setReviewContent(robj.getReviewContent());
            if (robj.getRating() != 0)
                trobj.setRating(robj.getRating());
            Product tpobj = robj.getProduct();
            int pid = tpobj.getProductId();
            Product pobj = pjrepository.findById(pid).get();
            trobj.setProduct(pobj);
            jrepository.save(trobj);
            return trobj;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Review getReviewOfProduct(int reviewId) {
        try {
            return jrepository.findById(reviewId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Review addReviewToProduct(Review robj) {
        Product pobj = robj.getProduct();
        int productId = pobj.getProductId();
        try {
            Product obj = pjrepository.findById(productId).get();
            robj.setProduct(obj);
            jrepository.save(robj);
            return robj;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ArrayList<Review> getProductsReviews() {
        List<Review> prlist = jrepository.findAll();
        ArrayList<Review> pralist = new ArrayList<>(prlist);
        return pralist;
    }

}