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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginpost(HttpSession session, LoginVO member) {
		
		if (ls.login(member)==null) {
			return "member/login";
			} else {	
				// 세션 영역에 저장              속성이름       속성 값
				session.setAttribute("login", ls.login(member));
				return "redirect:/MainHome";	
			}
	}
}