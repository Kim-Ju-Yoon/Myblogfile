package com.blog.service;

import java.util.ArrayList;

import com.blog.model.BoardVO;

public interface BoardService {
	// 게시물 목록 보기
	public ArrayList<BoardVO> list();
	// 게시판 상세 내용
	public BoardVO detail(BoardVO board);
}
