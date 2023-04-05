package com.tp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

	Page<Review> findByContentContaining(String keyword, Pageable pageable);
	
}
