package com.pertsol.comment.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Comments")
public class CommentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;     //A unique identifier for each comment,
	
	@Column(name="Username", nullable = false)
	private String username;        //The username or name of the commenter. 
	
	@Column(name="Text", nullable = false)
	private String text;            //The content of the comment. 
	
	@Column(name="dateofcomment", nullable = false)
	private LocalDateTime dateofcomment;   //The date and time when the comment was posted. 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDateofcomment() {
		return dateofcomment;
	}

	public void setDateofcomment(LocalDateTime dateofcomment) {
		this.dateofcomment = dateofcomment;
	}

	@Override
	public String toString() {
		return "CommentEntity [id=" + id + ", username=" + username + ", text=" + text + ", dateofcomment=" + dateofcomment + "]";
	}
	

}