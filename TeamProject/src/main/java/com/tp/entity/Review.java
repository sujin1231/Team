package com.tp.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	
	@Column(length=50, nullable = false)
	private String genre;
	
	@Column(length=50, nullable = false)
	private String writer;
	
	@Column(length=50, nullable = false)
	private String title;
	
	@Column(length=2000)
	private String content;
	
	@Column
	private int hit;
	
	@CreationTimestamp
	@Column
	private Timestamp regdate;
	
	
    public void modify(String genre, String title, String content) {
        this.title = title;
        this.content = content;
        this.genre = genre;
        
    }
}
