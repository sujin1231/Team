package com.tp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tp.entity.Review;
import com.tp.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {
	
	private final ReviewRepository reviewRepository;
	
	// 리뷰 게시물 저장
	public void saveReview(Review review) {
		reviewRepository.save(review);
	}	
	
	// 리뷰 게시물 하나 가져오기
	public Review selectOne(Long num) {
		return reviewRepository.findById(num).get();
	}
	
	// 페이징 처리, 리뷰 게시물 전체
	public Page<Review> Content(Pageable pageable) {
		return reviewRepository.findAll(pageable);
	}
	
	// 게시물 검색(제목)
	public Page<Review> reviewSearch(String keyword, Pageable pageable) {
		return reviewRepository.findByTitleContaining(keyword, pageable);
	}
	
	
}
