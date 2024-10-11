package com.estsoft.springdemoproject.controller;

import com.estsoft.springdemoproject.entity.Post;
import com.estsoft.springdemoproject.model.PostRequest;
import com.estsoft.springdemoproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/post/list")
    public ResponseEntity<List<Post>> getPostList(
            @RequestParam(name = "isDeleted", defaultValue = "false") Boolean isDeleted
    ) {
        return ResponseEntity.ok(postService.getPostList(isDeleted));
    }

    @PostMapping("/post")
    public ResponseEntity<String> getPostList(@RequestBody PostRequest postRequest) {
        postService.createPost(postRequest);

        return ResponseEntity.ok("SUCCESS");
    }
}