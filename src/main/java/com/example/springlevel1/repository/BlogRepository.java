package com.example.springlevel1.repository;


import com.example.springlevel1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Post, Long> {

}
