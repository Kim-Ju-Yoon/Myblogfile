package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.model.BoardVO;
import com.blog.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService bs;

	// 게시판 리스트
	@RequestMapping(value = "/BoardList", method = RequestMethod.GET)
	public String BoardList(Model model) {
		model.addAttribute("list", bs.list());
		return "board/BoardList";
	}
	
	// 게시판 상세 페이지
	@RequestMapping(value = "/BoardDetail", method = RequestMethod.GET)
	public String BoardDetail(Model model,BoardVO board) {
		System.out.println(board);
		model.addAttribute("detail", bs.detail(board));
		return "board/BoardDetail";
	}
	
}
