package com.sparta.springtest.dto;

import com.sparta.springtest.domain.entity.Board;
import com.sparta.springtest.domain.entity.Comment;
import com.sparta.springtest.domain.entity.Tag;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String tags;

}