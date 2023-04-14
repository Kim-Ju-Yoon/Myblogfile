package com.blog.model;

public class ReplyVO {
	
	private int rno;			// 댓글번호
	private String reply;		// 댓글내용
	private String id;			// 아이디
	private String replydate;	// 댓글작성일
	private int uid;			// 게시판번호
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReplydate() {
		return replydate;
	}
	public void setReplydate(String replydate) {
		this.replydate = replydate;
	}

	
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", reply=" + reply + ", id=" + id + ", replydate=" + replydate + ", uid=" + uid
				+ "]";
	}
	
	
}