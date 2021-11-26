package com.sparta.springtest.repository;

import com.sparta.springtest.domain.entity.Tag;
import com.sparta.springtest.domain.entity.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}