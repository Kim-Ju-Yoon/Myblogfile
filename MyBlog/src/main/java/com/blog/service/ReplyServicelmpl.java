package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.mapper.ReplyMapper;
import com.blog.model.CriteriaVO;
import com.blog.model.ReplyPageVO;
import com.blog.model.ReplyVO;

@Service
public class ReplyServicelmpl implements ReplyService {
	@Autowired
	ReplyMapper rm;

	// 댓글 쓰기를 위한 구현
	public int rewrite(ReplyVO reply) {
		return rm.rewrite(reply);
	}

	// 댓글 목록 리스트를 위한 구현
	public ReplyPageVO list(CriteriaVO cri, int uid) {
		return new ReplyPageVO(rm.rpycnt(uid), rm.list(cri, uid));
	}

	// 댓글 수정을 위한 구현
	public int modify(ReplyVO reply) {
		return rm.modify(reply);
	}

	// 댓글 삭제를 위한 구현
	public int remove(ReplyVO reply) {
		return rm.remove(reply);
	}

}
