package com.example.springlevel1.controller;

import com.example.springlevel1.dto.PostRequestDto;
import com.example.springlevel1.dto.PostResponseDto;
import com.example.springlevel1.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    // 게시글 작성
    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return blogService.createPost(requestDto);
    }

    // 전체 게시글 조회
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts() {
        return blogService.getPosts();
    }

}
