package com.estsoft.springdemoproject.controller;

import com.estsoft.springdemoproject.model.CommentRequest;
import com.estsoft.springdemoproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment")
    public ResponseEntity<Void> createComment(@RequestBody CommentRequest request) {
        commentService.createComment(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/most/commented")
    public List<Object[]> getMostCommentPost() {
        return commentService.getMostCommentPost();
    }
}