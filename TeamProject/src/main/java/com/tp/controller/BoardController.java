package com.tp.controller;

import java.sql.Timestamp;
import java.util.List;

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
//import com.tp.entity.BoardVO;
import com.tp.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardservice;
	
	@RequestMapping("/main")
	public String mainboard() {
		return "main/main";
	}
	
	// 페이징, 게시물 검색, 게시물 목록 보기
	@RequestMapping("/board")
	public String main(Model model, 
			@PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
			String keyword) {
		
		Page<Board> list = null;
		
		if(keyword == null) {
			list = boardservice.Content(pageable);
		}else {
			list = boardservice.boardSearch(keyword, pageable);
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
		
		return "board/list";
	}
	
	//장르
	@GetMapping("/genre")
	public String getGenre() {
		
		return "board/register";
	}
	
	@PostMapping("/genre")
	public String postGenre(Model model, @RequestParam String genre) {
			
		model.addAttribute("genre", genre);
		
		return "board/content";
	}
	
	//카테고리
	@GetMapping("/category")
	public String getCategory() {
		
		return "board/register";
	}
	
	@PostMapping("/category")
	public String postCategory(Model model, @RequestParam String category) {
			
		model.addAttribute("category", category);
		
		return "board/content";
	}
	
	//게시물 작성
	@RequestMapping("register")
	public String write() {
		return "board/register";
	}
	
	//게시물 저장(GET)
	@GetMapping("/save")
	public String saveForm() {
		
		return "board/list";
	}
	
	//게시물 저장(POST)
	@PostMapping("/save")
	public String postsave(Board board, 
			MultipartFile file, 
			@RequestParam("genre") String genre,
			@RequestParam("category") String category) throws Exception {
		
		boardservice.save(board, file);
		
		return "redirect:/board";
		
	}

	
	//게시물 상세보기
	@RequestMapping("/content")
	public String content(@RequestParam("num") Long num, Model model, HttpServletRequest request) {
		boardservice.updateHit(num);
		model.addAttribute("one", boardservice.selectOne(num));
		return "board/content";
	}

	// 게시물 삭제
	@RequestMapping("delete")
	public String delete(@RequestParam Long num) {
		boardservice.delete(num);
		return "redirect:/board";
	}
	
	// 게시물 수정
	@GetMapping("modify")
	public String modify(@RequestParam Long num, Model model) {
		model.addAttribute("one", boardservice.selectOne(num));
		return "board/board_modify";
	}
	
	// 게시물 수정 후 수정된 결과 보기
	@PostMapping("modify")
	public String modifyAfter(Board board, MultipartFile file) throws Exception {
		
		Timestamp now = new Timestamp(System.currentTimeMillis());
		board.setRegdate(now);
		
		boardservice.save(board, file);
		return "redirect:/content?num=" + board.getNum();
	}
	


}
