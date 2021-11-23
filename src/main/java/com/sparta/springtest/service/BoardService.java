package com.sparta.springtest.service;
import com.sparta.springtest.domain.entity.Board;
import com.sparta.springtest.domain.entity.Comment;
import com.sparta.springtest.dto.BoardCommentDto;
import com.sparta.springtest.dto.BoardDto;
import com.sparta.springtest.repository.BoardRepository;
import com.sparta.springtest.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public Board setBoard(BoardDto boardDto){
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        boardRepository.save(board);
        return board;
    }

    public Board getBoard(Long id){

        return boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

    }

    @Transactional // 처리도중 오류가 났을 때 rollback 해주기 위해서
    public void setArticleComment(BoardCommentDto boardCommentDto){
        Board board = boardRepository.findById(boardCommentDto.getIdx()).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        Comment comment = new Comment(boardCommentDto, board);
        commentRepository.save(comment);
    }










}
