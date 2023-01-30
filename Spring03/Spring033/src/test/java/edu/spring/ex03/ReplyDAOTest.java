package edu.spring.ex03;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.persistence.ReplyDAO;import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class ReplyDAOTest {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReplyDAOTest.class);
	
	@Autowired
	private ReplyDAO dao;
	
	@Test
	public void testDAO() {
		testInsert();
//		testSelectAll();
//		testUpdate();
//		testDelete();
	} // end testDAO()


	private void testInsert() {
		ReplyVO vo = new ReplyVO(0, 5, "test5", "댓글5", null);
		int result = dao.insert(vo);
		logger.info(result + "행 삽입");
	} // end testInsert()
	
	private void testSelectAll() {
		List<ReplyVO> list = dao.select(3);
		logger.info(list.size() + "");
		for(ReplyVO vo : list) {
			logger.info(vo.toString());
		}
		
	} // end testSelectAll()
	
	private void testUpdate() {
		ReplyVO vo = new ReplyVO(1, 0, null, "수정", null);
		int result = dao.update(vo);
		if(result == 1) {
			logger.info(result + "행 수정");
		}
	} // end testUpdate()
	
	private void testDelete() {
		int result = dao.delete(1);
		if(result == 1) {
			logger.info(result + "행 삭제");
		}
	} // end testDelte()
	
} // end ReplyDAOTest



