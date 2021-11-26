package com.sparta.springtest.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.springtest.domain.Timestamped;
import com.sparta.springtest.dto.BoardCommentDto;

import com.sparta.springtest.dto.BoardDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Tag extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column
    private String content;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "article_idx", nullable = false)
    private Board board;



}