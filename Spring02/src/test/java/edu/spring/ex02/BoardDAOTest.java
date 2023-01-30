package edu.spring.ex02;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;
import edu.spring.ex02.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class BoardDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Autowired
	private BoardDAO dao;
	
	@Test
	public void testDAO() {
		// testInsert();
		// testSelectAll();
		// testSelectByBoardId();
		// testUpdate();
		// testDelete();
		// testSelectPaging();
		// testTotalCounts();
		testSelectSearch();
	}

	private void testSelectSearch() {
		// List<BoardVO> list = dao.select("ki");
		List<BoardVO> list = dao.selectByTitleOrContent("3");
		for(BoardVO vo : list) {
			logger.info(vo.toString());
		}
		
	}

	private void testTotalCounts() {
		int totalCounts = dao.getTotalCounts();
		logger.info("�� �Խñ� �� : " + totalCounts);
		
	}

	private void testSelectPaging() {
		PageCriteria criteria = new PageCriteria(1, 3);
		List<BoardVO> list = dao.select(criteria);
		for(BoardVO vo : list) {
			logger.info(vo.toString());
		}
		
	}

	private void testDelete() {
		int result = dao.delete(2);
		if(result == 1) {
			logger.info("delete ����");
		} else {
			logger.info("delete ����");
		}
		
	} // end testDelete()

	private void testUpdate() {
		BoardVO vo = new BoardVO(5, "update", "update", null, null, 0);
		int result = dao.update(vo);
		if(result == 1) {
			logger.info("update ����");
		} else {
			logger.info("update ����");
		}
		
	} // end testUpdate()

	private void testSelectByBoardId() {
		BoardVO vo = dao.select(1);
		logger.info(vo.toString());
		
	} // end testSelectByBoardId()

	private void testSelectAll() {
		List<BoardVO> list = dao.select();
		for(BoardVO vo : list) {
			logger.info(vo.toString());
		}
		
	} // end testSelectAll()

	private void testInsert() {
		BoardVO vo = new BoardVO(0, "4", "hello", "kim", null, 0);
		int result = dao.insert(vo);
		if(result == 1) {
			logger.info("insert ����");
		} else {
			logger.info("insert ����");
		}
		
	} // end testInsert()
	
	
		
} // end DataSourceTedst
