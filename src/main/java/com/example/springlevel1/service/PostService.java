package com.example.springlevel1.service;

import com.example.springlevel1.dto.PostRequestDto;
import com.example.springlevel1.dto.PostResponseDto;
import com.example.springlevel1.entity.Post;
import com.example.springlevel1.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);

        Post savedPost = postRepository.save(post);

        return new PostResponseDto(post);
    }

    public List<PostResponseDto> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(PostResponseDto::new)
                .toList();
    }


    public PostResponseDto getPost(Long id) {
        return new PostResponseDto(findPost(id));
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        Post post = findPost(id);
        post.checkPassword(requestDto.getPassword());
        post.update(requestDto);

        return new PostResponseDto(post);
    }

    public void deletePost(Long id, PostRequestDto requestDto) {
        Post post = findPost(id);
        post.checkPassword(requestDto.getPassword());
        postRepository.delete(post);
    }

    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시물은 존재하지 않습니다."));
    }
}
