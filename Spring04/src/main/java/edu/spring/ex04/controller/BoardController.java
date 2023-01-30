package edu.spring.ex04.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@GetMapping("/list")
	public void list() {
		logger.info("list() ȣ��");
	}
	
	@GetMapping("register")
	public void register() {
		logger.info("register() ȣ��");
	}
	
	@GetMapping("/test")
	public void test(String data1, String data2, Model model) {
		logger.info("test() ȣ��");
		model.addAttribute("data1", data1);
		model.addAttribute("data2", data2);
	}
	
	
	
}
