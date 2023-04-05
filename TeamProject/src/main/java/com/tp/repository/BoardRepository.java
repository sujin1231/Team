package com.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	
	
}
