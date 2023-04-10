package com.tp.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

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
public class CoController {
	
	private final BoardService boardservice;

	@RequestMapping("/co_board")
	public String roBoard(Model model,
			String genre,
			@PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
			String keyword) {
		
		Page<Board> list = null;
		
		if(keyword == null) {
			list = boardservice.genreList("코미디", pageable);
		}else {
			list = boardservice.genreAndSearch("코미디", keyword, pageable);
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
		
		return "genre/co/list";
	}
	
	@RequestMapping("/co_review")
	public String roReview(Model model,
			String genre,
			String category,
			@PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
			String keyword) {
		
		Page<Board> list = null;
		
		if(keyword == null) {
			list = boardservice.GenreAndCategory("코미디", "리뷰", pageable);
		}else {
			list = boardservice.genreAndSearch("코미디", keyword, pageable);
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
		
		return "genre/co/list";
	}
	
	@RequestMapping("/co_recom")
	public String roRecom(Model model,
			@PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
			String keyword) {
		
		Page<Board> list = null;
		
		if(keyword == null) {
			list = boardservice.GenreAndCategory("코미디", "추천", pageable);
		}else {
			list = boardservice.genreAndSearch("코미디", keyword, pageable);
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
		
		return "genre/co/list";
	}
	
	@RequestMapping("/co_info")
	public String roInfo(Model model,
			@PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
			String keyword) {
		
		Page<Board> list = null;
		
		if(keyword == null) {
			list = boardservice.GenreAndCategory("코미디", "정보", pageable);
		}else {
			list = boardservice.genreAndSearch("코미디", keyword, pageable);
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
		
		return "genre/co/list";
	}
	
	//게시물 상세보기
	@RequestMapping("co_content")
	public String content(@RequestParam("num") Long num, Model model, HttpServletRequest request) {
		boardservice.updateHit(num);
		model.addAttribute("one", boardservice.selectOne(num));
		return "genre/co/content";
	}
	
	// 게시물 수정
	@GetMapping("co_modify")
	public String modify(@RequestParam Long num, Model model) {
		model.addAttribute("one", boardservice.selectOne(num));
		return "genre/co/modify";
	}
	
	// 게시물 수정 후 수정된 결과 보기
	@PostMapping("co_modify")
	public String modifyAfter(Board board, MultipartFile file) throws Exception {
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		board.setRegdate(now);
		
		boardservice.save(board, file);
		return "redirect:/co_content?num=" + board.getNum();
	}
	
}
