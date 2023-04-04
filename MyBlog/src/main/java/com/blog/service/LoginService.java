package com.blog.service;

import com.blog.model.LoginVO;

public interface LoginService {
	public LoginVO login(LoginVO member);
	public void memreg(LoginVO member);
}
