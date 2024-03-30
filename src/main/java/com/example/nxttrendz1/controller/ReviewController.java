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
public class ReviewController {
    @Autowired
    public ReviewJpaService jservice;

    @GetMapping("reviews/{reviewId}/product")
    public Product getProductOfReviewId(@PathVariable("reviewId") int reviewId) {
        return jservice.getProductOfReviewId(reviewId);
    }

    @DeleteMapping("/products/reviews/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") int reviewId) {
        jservice.deleteReview(reviewId);
    }

    @PutMapping("/products/reviews/{reviewId}")
    public Review updateReview(@PathVariable("reviewId") int reviewId, @RequestBody Review robj) {
        return jservice.updateReview(reviewId, robj);
    }

    @GetMapping("/products/reviews/{reviewId}")
    public Review getReviewOfProduct(@PathVariable("reviewId") int reviewId) {
        return jservice.getReviewOfProduct(reviewId);
    }

    @PostMapping("/products/reviews")
    public Review addReviewToProduct(@RequestBody Review robj) {
        return jservice.addReviewToProduct(robj);
    }

    @GetMapping("/products/reviews")
    public ArrayList<Review> getProductsReviews() {
        return jservice.getProductsReviews();
    }

}