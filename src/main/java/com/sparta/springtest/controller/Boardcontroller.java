package com.sparta.springtest.controller;

import com.sparta.springtest.domain.entity.Board;
import com.sparta.springtest.dto.BoardDto;
import com.sparta.springtest.repository.BoardRepository;

import com.sparta.springtest.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class Boardcontroller {

    private final BoardService boardService;

    @PostMapping("/article")
    public Board setBoard(@RequestBody BoardDto boardDto){

        return boardService.setBoard(boardDto);
    }

    @GetMapping("/article/{id}")
    public Board getBoard(@PathVariable Long id){

        return boardService.getBoard(id);
    }
}
