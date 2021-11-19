package com.sparta.springtest.service;
import com.sparta.springtest.domain.entity.Board;
import com.sparta.springtest.dto.BoardDto;
import com.sparta.springtest.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public Board setBoard(BoardDto boardDto){
        Board board = new Board();
        board.setContent(boardDto.getContent());
        boardRepository.save(board);
        return board;
    }

    public Board getBoard(Long id){
        return boardRepository.findById(id).get();
    }



}
