package com.blog.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.mapper.BoardMapper;
import com.blog.model.BoardVO;
import com.blog.model.CriteriaVO;

@Service
public class BoardServicelmpl implements BoardService {
	
	@Autowired
	BoardMapper bm;	// board 테이블 mapper
	// 게시판 리스트
	public ArrayList<BoardVO> list(CriteriaVO cri) {
		return bm.list(cri);
	}
	
	// 게시판 상세 내용
	@Transactional
	public BoardVO detail(BoardVO board) {
		bm.countup(board);
		return bm.detail(board);
	}
	
	// 게시판 전체 갯수 설계
	public int total(CriteriaVO cri) {
		return bm.total(cri);
	}
	
	// 글쓰기
	public void write(BoardVO board) {
		bm.write(board);
	}
	
	// 글삭제
	public void remove(BoardVO board) {
		bm.remove(board);
	}
	
	// 글수정
	public void modify(BoardVO board) {
		bm.modify(board);
	}
	
	
}
