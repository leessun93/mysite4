package com.javaex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	
	
	//리스트 출력
	@RequestMapping(value="/List", method={RequestMethod.GET, RequestMethod.POST})
	public String addList(@ModelAttribute GuestbookVo guestbookVo) {
		
		System.out.println("리스트 페이지 도킹");
		List<GuestbookVo> guestbookList = new ArrayList<GuestbookVo>();
		
		return "/WEB-INF/views/guestbook/addList.jsp";
	}
	//에드
	@RequestMapping("/add")
	public String add(@RequestParam("name") String name,
					  @RequestParam("password") String password,
					  @RequestParam("content") String content) {
		System.out.println("에드 도킹");
		
		
		return "redirect:/guestbook/List";
	
	}
	
	
	//딜리트폼
	@RequestMapping("/deleteForm")
	public String deleteForm() {
		
		System.out.println("딜리트폼 가즈아앗");
		
		return "/WEB-INF/views/guestbook/deleteForm.jsp";
		
	}
	
	@RequestMapping("/delete")
	public String delete() {
		System.out.println("삭제 완료다 되삤따");
		
		return "/WEB-INF/views/guestbook/addList.jsp";
	}

}
