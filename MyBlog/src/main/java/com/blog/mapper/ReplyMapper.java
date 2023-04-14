package com.blog.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.blog.model.CriteriaVO;
import com.blog.model.ReplyVO;

// 댓글 관련 mapper
public interface ReplyMapper {
	// 댓글 쓰기를 위한 구현
	// return타입이 int일때, 1이면 insert성공
	// 0이면 insert실패
	public int rewrite(ReplyVO reply);

	// 댓글 목록리스트를 위한 구현
	// public ArrayList<ReplyVO> list(int bno);
	public ArrayList<ReplyVO> list(@Param("cri") CriteriaVO cri, @Param("uid") int uid);

	public int rpycnt(int uid);

	// 댓글 수정을 위한 구현
	public int modify(ReplyVO reply);

	// 댓글 삭제를 위한 구현
	public int remove(ReplyVO reply);

}