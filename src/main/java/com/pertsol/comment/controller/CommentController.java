package com.pertsol.comment.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pertsol.comment.entity.CommentEntity;
import com.pertsol.comment.service.CommentService;

@RestController
@RequestMapping("/api/v2/comments")
public class CommentController {
	
	
	@Autowired
	private CommentService commentService;
	
	
	@GetMapping
	public List<CommentEntity> getAllComments(){
		return commentService.getAllComments();
	}
	
	@GetMapping("/search")
	public List<CommentEntity> searchComments(@RequestParam(required = false) String username,
											  @RequestParam(required = false) String date){
		
		if(username != null) {
			return commentService.getCommentsByUsername(username);
			
		}
		else if(date != null) {
			LocalDateTime dateOfComment = LocalDateTime.parse(date);
			return commentService.getCommentsByDate(dateOfComment);
		}
		
		return null;
	}
	
	@PostMapping
	public CommentEntity createComment(@RequestBody CommentEntity comment){
		return commentService.saveComments(comment);
	}
	
	@PutMapping("/{id}")
	public CommentEntity updateComment(@PathVariable Long id, @RequestBody CommentEntity comment){
		return commentService.updateComments(id, comment);
	}
	
	@DeleteMapping("/{id}")
	public void deleteComment(@PathVariable Long id){
		commentService.deleteComment(id);
	}

}
