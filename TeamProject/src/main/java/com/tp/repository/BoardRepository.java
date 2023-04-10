package com.tp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tp.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	Page<Board> findByTitleContaining(String keyword, Pageable pageable);
	
	Page<Board> findByCategory(String category, Pageable pageable);
	
	Page<Board> findByGenre(String genre, Pageable pageable);
	
	Page<Board> findByGenreAndTitleContaining(String genre, String title, Pageable pageable);
	
	Page<Board> findByCategoryAndTitleContaining(String category, String title, Pageable pageable);
	
	Page<Board> findByGenreAndCategory(String genre, String category, Pageable pageable);
}
