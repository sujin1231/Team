package com.tp.DTO;

import java.time.LocalDateTime;

import com.tp.entity.CommentEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDTO {

	private Long id;
	private String commentWriter;
	private String commentContents;
	private Long boardId;
//	private LocalDateTime commentCreatedTime;
	
	public static CommentDTO toCommentDTO(CommentEntity commentEntity, Long boardId) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(commentEntity.getId());
		commentDTO.setCommentWriter(commentEntity.getCommentContents());
//		commentDTO.setCommentCreatedTime(commentEntity.get);
		commentDTO.setBoardId(boardId);
		return commentDTO;
	}
}
