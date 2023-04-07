package com.tp.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tp.entity.Review;
import com.tp.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewController {
	
	private final ReviewService reviewservice;
	
	
	// 리뷰페이지로 이동
//	@RequestMapping("/review")
//	public String review(Model model,
//			@PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
//			String keyword) {
//		
//		Page<Review> list = null;
//		
//		if(keyword == null) {
//			list = reviewservice.Content(pageable);
//		}else {
//			list = reviewservice.reviewSearch(keyword, pageable);
//		}
//		
//		model.addAttribute("list",list);
//		return "review/review";
//	}
	
	//리뷰 게시글 등록
	@RequestMapping("/review_register")
	public String review_write() {
		return "review/review_register";
	}

	@GetMapping("/review_save")
	public String reviewsave() {
		return "review/review_save";
	}

	@PostMapping("/review_save")
	public String reviewpostsave(Review review) {
		reviewservice.saveReview(review);
		return "redirect:/review";

	}

	// review -> board(전체) 이동
	@RequestMapping("/all")
	public String allview() {
		return "redirect:/board";
	}
	
	// 리뷰 게시물 상세보기
	@RequestMapping("/review_content")
	public String review_content(@RequestParam("num") Long num, Model model) {
		
		model.addAttribute("one", reviewservice.selectOne(num));
		return "review/review_content";
	}
	
	// 리뷰 게시물 수정
//	@GetMapping("/board/review_modify/{num}")
//	public String edit(@PathVariable("num") Long id, Model model) {
//	    ReviewDTO reviewDTO = reviewservice.
//	    model.addAttribute("post", boardDto);
//	    return "board/edit.html";
//	}
//
//  @PutMapping("/post/edit/{id}")
//	public String update(@PathVariable Long id, BoardUpdateDto requestDto){
//	    boardService.update(id,requestDto);
//	    return "redirect:/board/list";
//	}
	
	//추천게시글 페이지로 이동
//	@RequestMapping
		
}
