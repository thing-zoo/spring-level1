package com.example.springlevel1.service;

import com.example.springlevel1.dto.PostRequestDto;
import com.example.springlevel1.dto.PostResponseDto;
import com.example.springlevel1.entity.Post;
import com.example.springlevel1.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);

        Post savedPost = blogRepository.save(post);

        return new PostResponseDto(post);
    }

    public List<PostResponseDto> getPosts() {
        return blogRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(PostResponseDto::new)
                .toList();
    }


    public PostResponseDto getPostById(Long id) {
        return new PostResponseDto(findPost(id));
    }

    private Post findPost(Long id) {
        return blogRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시물은 존재하지 않습니다."));
    }

    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        Post post = findPost(id);
        if (Objects.equals(post.getPassword(), requestDto.getPassword())) {
            post.update(requestDto);
        }
        return new PostResponseDto(post);
    }
}
