package com.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.model.LoginVO;
import com.blog.service.LoginService;

@Controller
public class MemberController {

	@Autowired
	LoginService ls;
	
	
	// 메인 페이지
		@RequestMapping(value = "/MainHome", method = RequestMethod.GET)
		public String login () {
			return "MainHome";
		}

		// 로그인 서버
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginpost(HttpSession session, LoginVO member) {
		
		if (ls.login(member)==null) {
			return "MemberPage";
			} else {	
				// 세션 영역에 저장              속성이름       속성 값
				session.setAttribute("login", ls.login(member));
				return "redirect:/MainHome";	
			}
	}
	
	// 회원가입서버
		@RequestMapping(value = "/member", method = RequestMethod.POST) // memberin.jsp의 폼 안에 내용을 가져오기 post 방식
		public String memberPost (LoginVO member) {
			System.out.println(member);
			ls.memreg(member);
			return "MemberPage";
		}

	
	
}