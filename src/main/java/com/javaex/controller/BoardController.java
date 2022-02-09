package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//리스트 이동 리다이렉트
	@RequestMapping("/List")
	public String list(Model model) {
		System.out.println("보드 리스트 도킹");
		List<BoardVo> boardList = boardService.list();
		model.addAttribute("bList", boardList);
		return "board/list";
	}
	
	//리스트 + 페이징
	@RequestMapping("/List2")
	public String list2(Model model,
						@RequestParam(value = "crtPage", required= false, defaultValue = "1") int crtPage) {
		System.out.println("보드 리스트2 도킹");
		System.out.println(crtPage);
		
		//해당페이지의 글 리스트 10개
		Map<String, Object> pMap = boardService.getBoardList2(crtPage);
		
		
		System.out.println("고고고고고고고고고");
		System.out.println(pMap);
		System.out.println("~!~!~!~!~!~!~!");
		
		model.addAttribute("pMap", pMap);
		return "board/list";
	
	}
	
	
	
	//모디파이폼 포워드
	@RequestMapping("/modifyForm")
	public String modifyForm(@RequestParam("no") int no, Model model) {
		System.out.println("모디폼 도킹");
		BoardVo boardvo = boardService.modifyForm(no);
		model.addAttribute("board", boardvo);
		
		return "board/modifyForm";
	}
	@RequestMapping("/modify")
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("모디했다!");
		boardService.modify(boardVo);
		
		return "redirect:List";
	}
	
	//리드 포워드
	@RequestMapping("/read")
	public String read(@RequestParam("no") int no, Model model) {
		System.out.println("리드폼 도킹");
		BoardVo boardVo = boardService.getoneList(no);
		
		model.addAttribute("board", boardVo);
		return "board/read";
	}
	//롸이트폼 포워드
	@RequestMapping("/writeForm")
	public String writeForm(@SessionAttribute(value="authUser", required=false) UserVo authVo) {
		System.out.println("롸이트폼 도킹");
		
		
		if(authVo != null) {
			return "board/writeForm";
		}
		else { // 잘못된 접근 처리
			return "redirect:/main";
		}
	}
	//롸이트
	@RequestMapping("/write")
	public String write(@SessionAttribute(value="authUser", required=false) UserVo authVo,
						@ModelAttribute BoardVo boardVo){
		System.out.println("롸이트 도킹");
		boardService.write(boardVo, authVo);
		return "redirect:List";
	}
	//딜리트
	@RequestMapping("/delete")
	public String delete(@RequestParam("no") int no) {
		System.out.println("딜리트");
		boardService.delete(no);
		return "redirect:List";
	}
	
}
