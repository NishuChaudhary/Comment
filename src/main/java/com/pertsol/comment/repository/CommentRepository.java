package com.pertsol.comment.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pertsol.comment.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{
	
	List<CommentEntity> findByusername(String byy);
	List<CommentEntity> findBydateofcomment(LocalDateTime dateOfComment);
	
}
