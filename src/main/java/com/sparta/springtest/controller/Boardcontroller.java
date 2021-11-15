package com.sparta.springtest.controller;

import com.sparta.springtest.domain.entity.Board;
import com.sparta.springtest.dto.BoardDto;
import com.sparta.springtest.repository.BoardRepository;

import com.sparta.springtest.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
        return "redirect:/";
    }

}
