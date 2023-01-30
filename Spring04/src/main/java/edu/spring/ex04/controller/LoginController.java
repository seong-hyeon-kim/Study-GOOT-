package edu.spring.ex04.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/member")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("/login")
	public void loginGET() {
		logger.info("loginGET() ȣ��");
	}
	
	@PostMapping("/login")
	public String loginPOST(String memberId, String password, HttpServletRequest request) {
		logger.info("loginPOST() ȣ��");
		if(memberId.equals("test") && password.equals("1234")) {
			logger.info("�α��� ����");
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberId);
			
			// ���ǿ��� targetURL ��������
			String targetURL = (String) session.getAttribute("targetURL");
			logger.info("targetURL : " + targetURL);
			
			if(targetURL != null) {
				session.removeAttribute("targetURL");
				return "redirect:" + targetURL;
			} else {
				return "redirect:/board/list";
			}
			
			
		} else {
			logger.info("�α��� ����");
			return "redirect:/member/login";
		}
		
	} // end loginPOST
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		logger.info("logout() ȣ��");
		HttpSession session = request.getSession();
		session.removeAttribute("memberId");
		
		return "redirect:/board/list";
	}
	
}

















