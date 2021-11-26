package com.sparta.springtest.domain.entity;

import com.sparta.springtest.domain.Timestamped;
import com.sparta.springtest.dto.BoardDto;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Board extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;

    @Column
    private String content;

    @OneToMany(mappedBy="board")
    private List<Comment> comments;

    @OneToMany(mappedBy="board")
    private List<Tag> tags;

    public Board(BoardDto boardDto) {
        this.id=boardDto.getId();
        this.title=boardDto.getTitle();
        this.content=boardDto.getContent();
        this.tags=new ArrayList<>();
    }




}