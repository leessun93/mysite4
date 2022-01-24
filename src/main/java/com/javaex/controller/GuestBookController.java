package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	//리스트 출력
	@RequestMapping(value="/List", method={RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		
		System.out.println("리스트 페이지 도킹");
		List<GuestbookVo> gbList = guestbookDao.getList();
		
		model.addAttribute("gbList", gbList);
		
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
	public String deleteForm(@ModelAttribute GuestbookVo guestbookVo) {
		
		System.out.println("딜리트폼 가즈아앗");
		
		return "/WEB-INF/views/guestbook/deleteForm.jsp";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("no") int no,
						 @RequestParam("password") String password) {
		System.out.println("삭제 완료다 돼삤따");
		GuestbookVo gVo = new GuestbookVo(no, password);
		guestbookDao.delete(gVo);
		
		
		return "/WEB-INF/views/guestbook/addList.jsp";
	}

}
