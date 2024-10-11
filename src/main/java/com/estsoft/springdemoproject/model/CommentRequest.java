package com.estsoft.springdemoproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {

    private Long postId;
    private String content;
}