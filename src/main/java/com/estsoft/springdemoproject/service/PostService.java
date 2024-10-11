package com.estsoft.springdemoproject.service;

import com.estsoft.springdemoproject.entity.Post;
import com.estsoft.springdemoproject.model.PostRequest;
import com.estsoft.springdemoproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getPostList(Boolean isDeleted) {
        return postRepository.findAllByIsDeletedOrderByCreatedAtDesc(isDeleted);
    }

    public Post getPost(Long postId, Boolean isDeleted) {
        return postRepository.findByIdAndIsDeleted(postId, isDeleted);
    }

    @Transactional
    public void createPost(PostRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setCategoryId(request.getCategoryId());
        post.setUserId(request.getUserId());
        post.setContent(request.getContent());
        post.setIsDeleted(false);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());

        postRepository.save(post);
    }
}