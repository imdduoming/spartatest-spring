package com.sparta.springtest.service;
import com.sparta.springtest.domain.entity.Board;
import com.sparta.springtest.domain.entity.Comment;
import com.sparta.springtest.domain.entity.Tag;
import com.sparta.springtest.dto.BoardCommentDto;
import com.sparta.springtest.dto.BoardDto;
import com.sparta.springtest.repository.BoardRepository;
import com.sparta.springtest.repository.CommentRepository;
import com.sparta.springtest.repository.TagRepository;
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
    private final TagRepository tagRepository;

    public Board setBoard(BoardDto boardDto){
        String tags =boardDto.getTags();
        String[] tagArray = tags.split(",");

        List<Tag> tagList = new ArrayList<>();
        for (int i = 0; i < tagArray.length; i++) {
            Tag tag=new Tag();
            tag.setContent(tagArray[i]);
            tagRepository.save(tag);
            tagList.add(tag);
        }
        Board board = new Board();

        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        board.setTags(tagList);
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
