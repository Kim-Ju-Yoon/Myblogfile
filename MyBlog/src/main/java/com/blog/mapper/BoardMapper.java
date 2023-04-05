package com.blog.mapper;

import java.util.ArrayList;

import com.blog.model.BoardVO;


public interface BoardMapper {

	public ArrayList<BoardVO> list();
	
	public BoardVO detail(BoardVO board);
}
