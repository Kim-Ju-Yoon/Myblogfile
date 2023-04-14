package com.blog.service;

import com.blog.model.CriteriaVO;
import com.blog.model.ReplyPageVO;
import com.blog.model.ReplyVO;

//댓글 관련 서비스
public interface ReplyService {
	// 댓글 쓰기를 위한 설계
	public int rewrite(ReplyVO reply);
	// 댓글 목록 리스트를 위한 설계
	//public ArrayList<ReplyVO> list(int uid);
	public ReplyPageVO list(CriteriaVO cri, int uid);
	// 댓글 수정을 위한 설계
	public int modify(ReplyVO reply);
	// 댓글 삭제를 위한 설계
	public int remove(ReplyVO reply);
}