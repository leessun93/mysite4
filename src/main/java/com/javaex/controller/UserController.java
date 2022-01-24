package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//로그인 폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("유저 콘츄롤러 로그인폼 도킹");
		return "user/loginForm";
	}
	
	
	
	//로그인
	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("콘츄롤러 로그인 도킹");
	
		UserVo authUser = userService.login(userVo);
		
		if(authUser != null) {//로긴성공
			//세션에저장
			System.out.println("로긴성공");
			session.setAttribute("authUser", authUser);
			
			return "redirect:/main";
		}else {
			
			return "redirect:loginForm?result=fail";
		}
		
		
	}
	
	
	
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:loginForm";
	}
}
