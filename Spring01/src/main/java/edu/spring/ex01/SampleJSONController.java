package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.spring.ex01.domain.ProductVO;

@Controller
public class SampleJSONController {
	private static final Logger logger = LoggerFactory.getLogger(SampleJSONController.class);
	
	@GetMapping("/json1")
	public String json1() {
		logger.info("json1() ȣ��");
		return "sample1"; // jsp ȣ��
	} // end json1()
	
	@GetMapping("/json2")
	@ResponseBody
	public String json2() {
		logger.info("json2() ȣ��");
		return "Hello, Spring";
	}
	
	@GetMapping("/json3")
	@ResponseBody
	public ProductVO json3() {
		logger.info("json3() ȣ��");
		return new ProductVO("�߱���", 10000);
	} // end json3()
	
}
