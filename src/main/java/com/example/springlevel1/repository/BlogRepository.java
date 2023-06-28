package com.example.springlevel1.repository;


import com.example.springlevel1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface BlogRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByOrderByCreatedAtDesc();
}
