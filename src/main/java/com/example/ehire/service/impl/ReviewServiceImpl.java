package com.example.ehire.service.impl;

import com.example.ehire.model.Review;

import java.util.List;

public interface ReviewServiceImpl {

    List<Review> getAllReview(Long id);
    Review getReviewById(Long Id);

    boolean postReviews(Long companyId, Review review);

    boolean updateReview(Review companyReview, Long reviewId, Long companyId);

    boolean deleteReview(Long reviewId, Long companyId);
}
