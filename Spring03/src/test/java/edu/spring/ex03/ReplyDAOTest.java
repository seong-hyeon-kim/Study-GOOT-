package edu.spring.ex03;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.persistence.ReplyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class ReplyDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(ReplyDAOTest.class);

	@Autowired
	private ReplyDAO dao; // 다형성
	
	@Test
	public void testDAO() {
		// testInsert();
		testSelect();
		// testUpdate();
		// testDelete();
	}
	
	private void testDelete() {
		int result = dao.delete(3);
		logger.info(result + "행 삭제");
		
	}

	private void testUpdate() {
		ReplyVO vo = new ReplyVO(4, 3, null, "수정됨", null);
		int result = dao.update(vo);
		logger.info(result + "행 변경");
		
	}

	private void testSelect() {
		List<ReplyVO> list = dao.select(3);
		logger.info(list.size() + "");
		for(ReplyVO vo : list) {
			logger.info(vo.toString());
		}
		
	}

	private void testInsert() {
		ReplyVO vo = new ReplyVO(0, 3, "test", "댓글", null);
		int result = dao.insert(vo);
		logger.info(result + "행 삽입");
	} // testInsert()
	

	
	
} // end DataSourceTedst
