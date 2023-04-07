package com.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.model.BoardVO;
import com.blog.model.CriteriaVO;
import com.blog.model.PageVO;
import com.blog.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService bs;

	// 게시판 리스트
	@RequestMapping(value = "/BoardList", method = RequestMethod.GET)
	public String BoardList(Model model,CriteriaVO cri) {
		model.addAttribute("list", bs.list(cri));
		int total=bs.total(cri);
		model.addAttribute("paging", new PageVO(cri, total));
		return "board/BoardList";
	}
	
	// 게시판 상세 페이지
	@RequestMapping(value = "/BoardDetail", method = RequestMethod.GET)
	public String BoardDetail(Model model,BoardVO board) {
		System.out.println(board);
		model.addAttribute("detail", bs.detail(board));
		return "board/BoardDetail";
	}
	
	// 게시판 글쓰기 페이지(화면이동)
	@RequestMapping(value = "/Write", method = RequestMethod.GET)
	public String BoardWrite(HttpSession session) {
		session.getAttribute("login");
		return "board/Write";
	}
	
	// 게시판 글쓰기 페이지(기능구현)
	@RequestMapping(value = "/Write", method = RequestMethod.POST)
	public String WritePost(BoardVO board) {
		bs.write(board);
		return "redirect:/BoardList";
	}
	
	// 게시판 삭제 기능
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove (BoardVO board) {
		bs.remove(board);
		return "redirect:/BoardList";
	}
	
	// 게시판 수정기능
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify (BoardVO board) {
		bs.modify(board);
		return "redirect:/BoardList";
	}
}
