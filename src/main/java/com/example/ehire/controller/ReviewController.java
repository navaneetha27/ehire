package com.example.ehire.controller;

import com.example.ehire.model.Review;
import com.example.ehire.service.impl.CompanyServiceImpl;
import com.example.ehire.service.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    @Autowired
    ReviewServiceImpl reviewService;


    @GetMapping("/reviews")
    public ResponseEntity<Object> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReview(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<Object> postReview(@PathVariable Long companyId, @RequestBody  Review review){
        boolean isReviewPublished = reviewService.postReviews(companyId, review);
        return isReviewPublished ?  new ResponseEntity<>("Review added succesfully", HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Object> getReview(@PathVariable Long reviewId, @PathVariable Long companyId){
        Review review = reviewService.getReviewById(reviewId);
        if(review == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(review, HttpStatus.OK);
    }
    

    @PostMapping("/reviews/{reviewId}")
    public ResponseEntity<Object> updateReview(@PathVariable Long reviewId, @PathVariable Long companyId, @RequestBody Review companyReview){
        boolean isUpdated = reviewService.updateReview(companyReview, reviewId, companyId);
        if(!isUpdated)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return   new ResponseEntity<>("Review updated", HttpStatus.OK);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Object> deleteReview(@PathVariable Long reviewId, @PathVariable Long companyId) {
        boolean isDeleted = reviewService.deleteReview(reviewId, companyId);
        if(!isDeleted)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return   new ResponseEntity<>("Review is Deleted", HttpStatus.OK);
    }

}
