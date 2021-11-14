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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
public class Boardcontroller {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardService boardService;


    @PostMapping("/post")
    public Long create(@RequestBody BoardDto boardDto) {
        boardService.savePost()
    }
    // 리파지터리 객체 자동 삽입 됨! 위에서 @RequiredArgsConstructor 했음!

    @GetMapping("/articles")
    public String index(Model model) { // 뷰 페이지로 데이터 전달을 위한 Model 객체 자동 삽입 됨!
        // 모든 Article을 가져옴
        // Iterable 인터페이스는 ArrayList의 부모 인터페이스
        Iterable<Board> boardList = boardRepository.findAll();
        // 뷰 페이지로 articles 전달!
        model.addAttribute("arti", boardList);
        // 뷰 페이지 설정
        return "index";
    }
}
