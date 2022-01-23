package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;
	
	//로그인 폼
	@RequestMapping(value="/user/loginForm", method={RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("유저 콘츄롤러 로그인폼 도킹");
		
		return "/WEB-INF/views/user/loginForm.jsp";
	}
	
	
	//로그인
	@RequestMapping(value="/user/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo) {
		System.out.println("로그인 도킹");
	
		UserVo authUser = userDao.getUser(userVo);
		
		return "/WEB-INF/views/main/index.jsp";
		
		
	}
}
