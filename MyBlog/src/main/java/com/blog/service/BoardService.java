package com.blog.service;

import java.util.ArrayList;

import com.blog.model.BoardVO;
import com.blog.model.CriteriaVO;

public interface BoardService {
	// 게시물 목록 보기
	public ArrayList<BoardVO> list(CriteriaVO cri);

	// 게시판 상세 내용
	public BoardVO detail(BoardVO board);

	// 게시판 전체 갯수 설계
	public int total(CriteriaVO cri);

	// 글쓰기
	public void write(BoardVO board);
	
	// 글삭제
	public void remove(BoardVO board);
	
	// 글수정
	public void modify(BoardVO board);
	
}
