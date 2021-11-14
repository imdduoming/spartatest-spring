package com.sparta.springtest.service;

import com.sparta.springtest.domain.entity.Board;
import com.sparta.springtest.dto.BoardDto;
import com.sparta.springtest.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }


}
