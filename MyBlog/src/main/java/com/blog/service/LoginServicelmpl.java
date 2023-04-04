package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.mapper.LoginMapper;
import com.blog.model.LoginVO;

@Service
public class LoginServicelmpl implements LoginService {

	@Autowired
	LoginMapper lm;
	
	public LoginVO login(LoginVO member) {
		System.out.println("service="+member);
		System.out.println("service return="+lm.login(member));
		return lm.login(member);
	}

}
