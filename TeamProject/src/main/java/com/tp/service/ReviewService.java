package com.tp.service;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tp.DTO.ReviewDTO;
import com.tp.entity.Board;
import com.tp.entity.Review;
import com.tp.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {


	private final ReviewRepository reviewRepository;
	
	
	@Transactional
	public void saveReveiw(Review review) {
		
		reviewRepository.save(review);
		
	}
	public Page<Review> Content(Pageable pageable){
		return reviewRepository.findAll(pageable);
	}
	
//	@Transactional
//	public List<Review> Content() {
//		
//		List<Review> reviewlist = reviewRepository.findAll();
//		List<ReviewDTO> reviewtolist = new ArrayList<>();
//		
//		for(Review review : reviewlist) {
//			ReviewDTO reviewDTO = ReviewDTO.builder()
//					.num(review.getNum())
//					.content(review.getContent())
//					.genre(review.getGenre())
//					.hit(review.getHit())
//					.regdate(review.getRegdate())
//					.title(review.getTitle())
//					.writer(review.getWriter())
//					.build();
//			reviewtolist.add(reviewDTO);
//		
//	}
//			return reviewlist;
//	}
	
	@Transactional
	public ReviewDTO selectOne(Long num) {
		Optional<Review> review = reviewRepository.findById(num);
		
		Review review1 = review.get();
		
		ReviewDTO dto = ReviewDTO.builder()
				.num(review1.getNum())
				.content(review1.getContent())
				.writer(review1.getWriter())
				.genre(review1.getGenre())
				.hit(review1.getHit())
				.regdate(review1.getRegdate())
				.title(review1.getTitle())
				.build();
		
		return dto;
	}
	

	public Page<Review> reviewSearch(String keyword, Pageable pageable) {
		return reviewRepository.findByContentContaining(keyword, pageable);
	}
	
	//리뷰 게시글 수정
//   @Transactional
//    public Long update(final Long num, final ReviewDTO params) {
//        Review entity = reviewRepository.findById(num)
//                .orElseThrow(() -> new CustomException("ErrorCode.POSTS_NOT_FOUND"));
//        entity.update(params.getTitle(), params.getContent(), params.getGenre());
//        return num;
//    }
	
}

