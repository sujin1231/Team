package com.tp.controller;

import java.sql.Timestamp;
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
import org.springframework.web.multipart.MultipartFile;

import com.tp.entity.Board;
import com.tp.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RecomController {
	
	private final BoardService boardService;
	
	
	// 리뷰 페이지로 이동
	@RequestMapping("/recom")
	public String findByBun(String bun, 
			Model model,
			@PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
			String keyword) {
		
		Page<Board> list = null;
		
		if(keyword == null) {
			list = boardService.CategoryList("추천", pageable);
		}else {
			list = boardService.CategoryAndSearch("추천", keyword, pageable);
		}
		
		// 현재페이지 가져오는 nowPage
		int nowPage = list.getPageable().getPageNumber()+1;
		
		//Math.max() 는 둘 중 큰걸 반환 min 은 반대
		int startPage = Math.max(nowPage - 4, 1);
		int endPage = Math.min(nowPage + 5, list.getTotalPages());
		
		model.addAttribute("list", list);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("list", list);
		return "recom/recom";
	}

	@GetMapping("/recom_save")
	public String reviewsave() {
		return "recom/recom";
	}

	@PostMapping("/recom_save")
	public String reviewSave(Board board, MultipartFile file) throws Exception {
		boardService.save(board, file);
		return "redirect:/recom";

	}

	// 리뷰 게시물 상세보기
	@RequestMapping("/recom_content")
	public String review_content(@RequestParam("num") Long num, Model model) {
		
		model.addAttribute("one", boardService.selectOne(num));
		return "recom/recom_content";
	}
	
	// 리뷰 게시물 수정
	@GetMapping("recom_modify")
	public String modify(@RequestParam("num") Long num, Model model) {
	    model.addAttribute("one", boardService.selectOne(num));
	    return "recom/recom_modify";
	}

	// 리뷰 게시물 수정 후 확인
	@PostMapping("recom_modify")
	public String modifyAfter(Board board, MultipartFile file) throws Exception {
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		board.setRegdate(now);
		System.out.println(board.getRegdate());
		System.out.println(now);
		
		boardService.save(board, file);
		return "redirect:/recom_content?num=" + board.getNum();
	}

}
