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
	
		// 리뷰페이지로
		@RequestMapping("/review")
		public String main(Model model, 
				@PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
				String keyword) {
			
			Page<Review> list = null;
			
			if(keyword == null) {
				list = reviewservice.Content(pageable);
			}else {
				list = reviewservice.reviewSearch(keyword, pageable);
			}
			
			int nowPage = list.getPageable().getPageNumber()+1;
			int startPage = Math.max(nowPage - 4, 1);
			int endPage = Math.min(nowPage + 5, list.getTotalPages());
			
			model.addAttribute("list", list);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			
			return "board/review";
		}
		
		
		//리뷰 게시글 등록
		@RequestMapping("/review_register")
		public String review_write() {
			return "board/review_register";
		}

		@GetMapping("/review_save")
		public String reviewsave() {
			return "board/review_save";
		}

		@PostMapping("/review_save")
		public String reviewpostsave(Review review) {
			reviewservice.saveReveiw(review);
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
			return "board/review_content";
		}
		
		// 리뷰 게시물 수정
		@GetMapping("/reveiew_modify")
		public String review_modify(@RequestParam Long num, Model model) {
			model.addAttribute("one", reviewservice.selectOne(num));
			return "board/review_modify";
		}
		
		@PostMapping("/review_sucmodify")
		public String review_sucmodify(Review review) {
			reviewservice.saveReveiw(review);
			return "redirect:/review_content?num=" + review.getNum();
		}
		
		
}
