package com.blog.mapper;

import java.util.ArrayList;

import com.blog.model.BoardVO;
import com.blog.model.CriteriaVO;


public interface BoardMapper {

	public ArrayList<BoardVO> list(CriteriaVO cri);
	
	public BoardVO detail(BoardVO board);
	
	public int total(CriteriaVO cri);
	
	public void write(BoardVO board);
	
	public void remove(BoardVO board);
	
	public void modify(BoardVO board);
}
