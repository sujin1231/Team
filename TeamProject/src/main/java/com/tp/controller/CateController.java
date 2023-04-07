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
public class CateController {

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
				int nextp = endPage+1;
				int prep = startPage-1;
				
				model.addAttribute("list", list);
				model.addAttribute("nowPage", nowPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
				model.addAttribute("nextPage", nextp);
				model.addAttribute("prePage", prep);
		
		
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping("/fa")
	public String findByGenreFo(String genre, Model model,
			@PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
			String keyword) {
		
		Page<Board> list = null;
		
		if(keyword == null) {
			list = boardservice.genreList("판타지", pageable);
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
		return "board/list";
	}
}
