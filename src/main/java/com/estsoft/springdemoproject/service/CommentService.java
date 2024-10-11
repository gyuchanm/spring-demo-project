package com.estsoft.springdemoproject.service;

import com.estsoft.springdemoproject.entity.Comment;
import com.estsoft.springdemoproject.entity.Post;
import com.estsoft.springdemoproject.model.CommentRequest;
import com.estsoft.springdemoproject.repository.CommentRepository;
import com.estsoft.springdemoproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public void createComment(CommentRequest request) {
        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new RuntimeException("post not found"));

        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setPost(post);
        comment.setUserId(1L);
        comment.setIsDeleted(false);
        comment.setCreatedAt(LocalDateTime.now());

        commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findByIdAndIsDeleted(commentId, Boolean.FALSE)
                .orElseThrow(() -> new RuntimeException("삭제하려는 댓글이 존재하지 않습니다."));

        comment.setIsDeleted(Boolean.TRUE);
        comment.setDeletedAt(LocalDateTime.now());

        commentRepository.save(comment);
    }

    public List<Object[]> getMostCommentPost() {
        return commentRepository.findCommentCountByPost();
    }
}