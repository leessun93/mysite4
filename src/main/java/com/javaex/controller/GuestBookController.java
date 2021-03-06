package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	
	@Autowired
	private GuestService guestService;
	
	//리스트 출력
	@RequestMapping("/List")
	public String addList(Model model) {
		
		System.out.println("리스트 페이지 도킹");
		List<GuestbookVo> gbList = guestService.getGuestList();
		
		model.addAttribute("gbList", gbList);
		
		return "/guestbook/addList.jsp";
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
	public String deleteForm(@ModelAttribute GuestbookVo guestbookVo) {
		
		System.out.println("딜리트폼 가즈아앗");
		
		return "/WEB-INF/views/guestbook/deleteForm.jsp";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("no") int no,
						 @RequestParam("password") String password) {
		System.out.println("삭제 완료다 돼삤따");
		GuestbookVo gVo = new GuestbookVo(no, password);
		guestService.remove(gVo);
		
		
		return "/WEB-INF/views/guestbook/addList.jsp";
	}

}
