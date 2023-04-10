package com.tp.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tp.entity.Board;
import com.tp.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CategoryController {

	private final BoardService boardservice;
	
	@RequestMapping("/ro")
	public String findByGenreRo(
			String genre, 
			Model model,
			@PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
			String keyword) {
		
		Page<Board> list = null;
		
		if(keyword == null) {
			list = boardservice.genreList("로맨스", pageable);
		}
		else {
			list = boardservice.genreAndSearch("로맨스", keyword, pageable);
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
		
		return "genre/ro/list";
	}
	
	@RequestMapping("/fa")
	public String findByGenreFo(String genre, Model model,
			@PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
			String keyword) {
		
		Page<Board> list = null;
		
		if(keyword == null) {
			list = boardservice.genreList("판타지", pageable);
		}else {
			list = boardservice.genreAndSearch("판타지", keyword, pageable);
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
		return "genre/fa/list";
	}
	
	@RequestMapping("/co")
	public String findByGenreCo(String genre, Model model,
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

		
		model.addAttribute("list", list);
		return "genre/co/list";
	}
	
	@RequestMapping("/act")
	public String findByGenreAct(String genre, Model model,
			@PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
			String keyword) {
		
		Page<Board> list = null;
		
		if(keyword == null) {
			list = boardservice.genreList("액션", pageable);
		}else {
			list = boardservice.genreAndSearch("액션", keyword, pageable);
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
		return "genre/act/list";
	}
	
	@RequestMapping("/horror")
	public String findByGenreHorror(String genre, Model model,
			@PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
			String keyword) {
		
		Page<Board> list = null;
		
		if(keyword == null) {
			list = boardservice.genreList("공포", pageable);
		}else {
			list = boardservice.genreAndSearch("공포", keyword, pageable);
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
		return "genre/horror/list";
	}
	
}
