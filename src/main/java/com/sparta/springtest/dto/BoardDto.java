package com.sparta.springtest.dto;

import com.sparta.springtest.domain.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    //폼데이터를 서버에서 사용하려면 객체로 만들어야하고 이를위해 DTO필요
    // 클라이언트가 보낸 정보를 DTO라는것으로 만들어서 컨트롤러에 보냄
    private Long id;

    private String title;


    public Board toEntity() { //폼데이터를 갖는 DTO를 Entity로 바꾼다
        Board build = Board.builder()
                .id(id)
                .title(title)

                .build();
        return build;
    }
    @Builder
    public BoardDto(Long id, String title) {
        this.id = id;

        this.title = title;


    }


}