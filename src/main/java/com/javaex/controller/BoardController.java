package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//리스트 이동 리다이렉트
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("보드 리스트 도킹");
		List<BoardVo> boardList = boardService.list();
		model.addAttribute("bList", boardList);
		return "board/list";
	}
	//모디파이폼 포워드
	@RequestMapping("/modifyForm")
	public String modifyForm() {
	
		System.out.println("모디폼 도킹");
		return "board/modifyForm";
	}
	//리드 포워드
	@RequestMapping("/read")
	public String read() {
		System.out.println("리드폼 도킹");
		return "board/read";
	}
	//롸이트폼 포워드
	@RequestMapping("/writeForm")
	public String writeForm() {
		System.out.println("롸이트폼 도킹");
		return "board/writeForm";
	}
	//롸이트
	@RequestMapping("/write")
	public String write(){
		System.out.println("롸이트 완료");
		return "request:list";
	}
	
}
