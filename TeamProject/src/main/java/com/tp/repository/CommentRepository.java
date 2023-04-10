package com.tp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Board;
import com.tp.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
	List<CommentEntity> findAllByBoardOrderByIdDesc(Board board);
}
