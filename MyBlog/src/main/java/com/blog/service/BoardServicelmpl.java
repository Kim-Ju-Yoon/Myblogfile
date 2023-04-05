package com.blog.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.mapper.BoardMapper;
import com.blog.model.BoardVO;

@Service
public class BoardServicelmpl implements BoardService {
	
	@Autowired
	BoardMapper bm;	// board 테이블 mapper

	public ArrayList<BoardVO> list() {
		return bm.list();
	}
}
