package com.tp.DTO;

import java.sql.Timestamp;

import com.tp.entity.Board;
import com.tp.entity.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReviewDTO {

	private Long num;
	private String genre;
	private String writer;
	private String title;
	private String content;
	private Timestamp regdate;
	private int hit;
	
	public static Review toEntity(final ReviewDTO dto) {
		return Review.builder()
				.num(dto.getNum())
				.genre(dto.getGenre())
				.writer(dto.getWriter())
				.title(dto.getTitle())
				.content(dto.getContent())
				.regdate(dto.getRegdate())
				.hit(0)
				.build();
	}
}
