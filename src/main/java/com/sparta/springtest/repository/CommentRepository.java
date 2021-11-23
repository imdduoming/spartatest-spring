package com.sparta.springtest.repository;

import com.sparta.springtest.domain.entity.Board;
import com.sparta.springtest.domain.entity.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}