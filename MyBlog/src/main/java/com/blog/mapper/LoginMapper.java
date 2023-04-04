package com.blog.mapper;

import com.blog.model.LoginVO;

public interface LoginMapper {
	public LoginVO login(LoginVO member);

	public void memreg(LoginVO member);
}
