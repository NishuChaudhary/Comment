package com.pertsol.comment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pertsol.comment.entity.CommentEntity;
import com.pertsol.comment.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public List<CommentEntity> getAllComments(){
		return commentRepository.findAll();      //Retrieve all comments 
	}
	
	public List<CommentEntity> getCommentsByUsername(String username){
		return commentRepository.findByusername(username);       //Retrieve comments by username 
	}
	
	public List<CommentEntity> getCommentsByDate(LocalDateTime dateOfComment){
		return commentRepository.findBydateofcomment(dateOfComment);    //Retrieve comments by date
	}
	
	public CommentEntity saveComments(CommentEntity comments){
		return commentRepository.save(comments);  
	}
	
	public CommentEntity updateComments(Long id, CommentEntity comments) {
		Optional<CommentEntity> comment= commentRepository.findById(id);
		if(comment.isPresent()) {
			CommentEntity existingcomment = comment.get();
			existingcomment.setUsername(comments.getUsername());
			existingcomment.setDateofcomment(comments.getDateofcomment());
			existingcomment.setId(comments.getId());
			existingcomment.setText(comments.getText());
			return commentRepository.save(existingcomment);
		}
		else {
			throw new RuntimeException("Comment not found");
		}
	}
	
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}

}
