package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService bs;

	
	@RequestMapping(value = "/BoardList", method = RequestMethod.GET)
	public String BoardList(Model model) {
		model.addAttribute("list", bs.list());
		return "board/BoardList";
	}
	
}
