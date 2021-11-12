package com.sparta.springtest;

import com.sparta.springtest.dto.BoardDto;
import com.sparta.springtest.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Boardcontroller {
    private BoardService boardService;

    public Boardcontroller(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<BoardDto> boardDtoList = boardService.getBoardList();
        model.addAttribute("postList", boardDtoList);
        return "index";
    }
    @GetMapping("/post")
    public String post() {
        return "index";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);
        return "index";
    }
}
