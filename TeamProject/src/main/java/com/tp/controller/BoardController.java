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
import org.springframework.web.multipart.MultipartFile;

import com.tp.entity.Board;
//import com.tp.entity.BoardVO;
import com.tp.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardservice;
	
	@RequestMapping("/board")
	public String main(Model model) {
		
		List<Board> list = boardservice.Content();
		model.addAttribute("list", list);
	
		return "board/list";
	}
	
	@RequestMapping("register")
	public String write() {
		return "board/register";
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
	
	
	@GetMapping("/save")
	public String saveForm() {
//			@RequestParam("title") String title,
//            @RequestParam("writer") String writer,
//			@RequestParam("genre") String genre,
//            @RequestParam("category") String category,
//            @RequestParam("content") String content,
//            @RequestParam("filename") String filename,
//            @RequestParam("filepath") String filepath,
//            Model model
//			) {
//		//데이터 처리 후 view로 전달
//		model.addAttribute("title", title);
//        model.addAttribute("writer", writer);
//        model.addAttribute("genre", genre);
//        model.addAttribute("category", category);
//        model.addAttribute("content", content);
//        model.addAttribute("filename", filename);
//        model.addAttribute("filepath", filepath);
		return "board/list";
	}
	
	@PostMapping("/save")
	public String postsave(Board board, MultipartFile file) throws Exception {
		
		boardservice.save(board, file);
		
		return "redirect:/board";
		
	}

	
	//게시물 상세보기
	@RequestMapping("/content")
	public String content(@RequestParam("num") Long num, Model model) {
		
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
		boardservice.save(board, file);
		return "redirect:/content?num=" + board.getNum();
	}
	
	// 페이징
	@GetMapping("test")
	public String pages(Model model, @RequestParam(required = false, defaultValue = "0", value = "page") int page) {
		
//		Page<Board> boards = boardservice.page(pageable);
		
//		int total = listpage.getTotalPages();
//		
//		model.addAttribute("board", listpage.getContent());
//		model.addAttribute("total", total);
		
//		model.addAttribute("post", boardservice.page(pageable));
//		model.addAttribute("pre", pageable.previousOrFirst().getPageNumber());
//		model.addAttribute("next", pageable.next().getPageNumber());
		
		return "board/list";
	}

}
