package edu.spring.ex02;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class BoardControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(BoardControllerTest.class);

	 @Autowired
	 private WebApplicationContext wac;
	 
	 // MVC ������ ���� �׽�Ʈ�ϴ� mock-up ��ü
	 private MockMvc mock;
	 
	 @Before
	 public void beforeTest() {
		 logger.info("beforeTest() ȣ��");
		 // ��Ʈ�ѷ� �޼ҵ忡�� ��û�� ���� �� �ִ� mockup ��ü ����
		 mock = MockMvcBuilders.webAppContextSetup(wac).build();
	 } // end beforeTest()
	 
	 @Test
	 public void test() {
		 testList();
	 } // end test()
	 
	 private void testList() {
		 logger.info("testList() ȣ��");
		 MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String> ();
		 params.add("page", "1");
		 params.add("numsPerPage", "2");
		 
		 RequestBuilder requestBuilder = get("/board/list").params(params);
		 
		 try {
			 mock.perform(requestBuilder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
	 } // end testList()
			
	
 
} // end BoardControllerTest





























