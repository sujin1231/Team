package com.tp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tp.DTO.CommentDTO;
import com.tp.entity.Board;
import com.tp.entity.CommentEntity;
import com.tp.repository.BoardRepository;
import com.tp.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;
	private final BoardRepository boardRepository;
	
	public Long save(CommentDTO commentDTO) {
		/* 부모엔티티(BoardEntity) 조회*/
		Optional<Board> optionalBoard = boardRepository.findById(commentDTO.getBoardId());
		if(optionalBoard.isPresent()) {
			Board board = optionalBoard.get();
			CommentEntity commentEntity = toSaveEntity(commentDTO, board);
			return commentRepository.save(commentEntity).getId();
		}else {
			return null;
		}
		
		
	}

	private CommentEntity toSaveEntity(CommentDTO commentDTO, Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CommentDTO> findAll(Long boardId) {
		//select * from comment_table where board_id? order by id desc;
		Board board = boardRepository.findById(boardId).get();
		List<CommentEntity> commentEntityList = commentRepository.findAllByBoardOrderByIdDesc(board);
		/* EntityList -> DTOList */
		List<CommentDTO> commentDTOList = new ArrayList<>();
		for (CommentEntity commentEntity: commentEntityList) {
			CommentDTO commentDTO = CommentDTO.toCommentDTO(commentEntity, boardId);
		}
		return commentDTOList;
	}

	
}
