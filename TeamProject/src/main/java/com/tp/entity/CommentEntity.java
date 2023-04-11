package com.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tp.DTO.CommentDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "comment_table")
public class CommentEntity extends BoardBaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20, nullable = false)
	private String commentWriter;
	 
	@Column
	private String commentContents;
	
	/* Board:Comment = 1:N */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "num")
	private Board board;
	
	private CommentEntity toSaveEntity(CommentDTO commentDTO, Board board) {
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setCommentWriter(commentDTO.getCommentWriter());
		commentEntity.setCommentContents(commentDTO.getCommentContents());
		commentEntity.setBoard(board);
		return commentEntity;
	}
	
}
