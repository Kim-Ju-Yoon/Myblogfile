package com.blog.model;

public class BoardVO {
	// 게시판번호 (bno)
	private int uid;
	// 제목 (title)
	private String title;
	// 내용 (content)
	private String content;
	// 작성일자 (regdate)
	private String regdate;
	// 조회수 (cnt)
	private int count;
	// 아이디 (id)
	private String id;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BoardVO [uid=" + uid + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", count="
				+ count + ", id=" + id + "]";
	}
}