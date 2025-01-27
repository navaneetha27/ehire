package com.example.ehire.service;

import com.example.ehire.model.Company;
import com.example.ehire.model.Review;
import com.example.ehire.repository.CompanyRepository;
import com.example.ehire.repository.ReviewRepository;
import com.example.ehire.service.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService  implements ReviewServiceImpl {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    CompanyService companyService;
    @Override
    public List<Review> getAllReview(Long id) {
        List<Review> reviews = reviewRepository.findByCompanyId(id);
        return reviews;
    }

    @Override
    public Review getReviewById(Long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isPresent()){
            return reviewOptional.get();
        }
        return null;
    }

    @Override
    public boolean postReviews(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Review companyReview, Long reviewId, Long companyId) {
        Company  company  = companyService.getCompanyById(companyId);
        if(company != null  && reviewRepository.existsById(reviewId)){
            reviewRepository.save(companyReview);
            return true;

        }
        return false;
    }

    @Override
    public boolean deleteReview(Long reviewId, Long companyId) {
        Company  company  = companyService.getCompanyById(companyId);
        if(company != null  && reviewRepository.existsById(reviewId)){
            Iterator<Review> reviews = company.getReviews().iterator();
            while(reviews.hasNext()){
                if(reviews.next().getId().equals(reviewId)){
                    reviews.remove();
                }
            }
            companyService.updateCompany(companyId, company);
            reviewRepository.deleteById(reviewId);
            return true;

        }
        return false;
    }
}
