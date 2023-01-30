package edu.spring.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 단순하게 reply.jsp 불러오기 위해 만들었음
@Controller
public class ReplyController {
	@GetMapping("/reply")
	public void reply() {
		
	} // end reply()
	
} // end ReplyController
