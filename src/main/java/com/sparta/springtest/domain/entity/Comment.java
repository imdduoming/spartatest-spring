package com.sparta.springtest.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.springtest.domain.Timestamped;
import com.sparta.springtest.dto.BoardCommentDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String comment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="article_idx", nullable = false)
    private Board board;

    public Comment(BoardCommentDto boardCommentDto, Board board) {
        this.comment = boardCommentDto.getComment();
        this.board = board;
    }

}