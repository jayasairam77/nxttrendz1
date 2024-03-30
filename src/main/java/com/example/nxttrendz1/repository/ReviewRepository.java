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

public interface ReviewRepository {
    Product getProductOfReviewId(int reviewId);
    void deleteReview(int reviewId);
    Review updateReview(int reviewId, Review robj);

    Review getReviewOfProduct(int reviewId);

    Review addReviewToProduct(Review robj);

    ArrayList<Review> getProductsReviews();

}