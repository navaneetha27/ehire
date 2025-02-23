package com.example.ehire.repository;

import com.example.ehire.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository  extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long id);
}
