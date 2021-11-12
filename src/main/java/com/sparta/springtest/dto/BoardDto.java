package com.sparta.springtest.dto;

import com.sparta.springtest.domain.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;

    private String title;


    public Board toEntity() {
        Board build = Board.builder()
                .id(id)
                .title(title)

                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id,String title) {
        this.id = id;

        this.title = title;

    }
}