package com.estsoft.springdemoproject.repository;

import com.estsoft.springdemoproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByIsDeletedOrderByCreatedAtDesc(Boolean isDeleted);
    // select * from where id = :postId AND is_deleted = :isDeleted
    // learned query
    Post findByIdAndIsDeleted(Long postId, Boolean isDeleted);
}