package com.estsoft.springdemoproject.repository;

import com.estsoft.springdemoproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findByIdAndIsDeleted(Long commentId, Boolean isDeleted);
}