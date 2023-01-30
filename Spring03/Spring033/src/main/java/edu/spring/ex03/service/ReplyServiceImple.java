package edu.spring.ex03.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.persistence.ReplyDAO;

// ReplyDAO�� BoardDAO�� �� ���� ���ؼ� ���񽺸� ���
@Service
public class ReplyServiceImple implements ReplyService {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired
	private ReplyDAO replyDAO;

	@Override
	public int create(ReplyVO vo) {
		logger.info("create() ȣ�� : vo = " + vo.toString());
		return replyDAO.insert(vo);
	} // end create()

	@Override
	public List<ReplyVO> read(int boardId) {
		logger.info("read() ȣ�� : boardId = " + boardId);
		return replyDAO.select(boardId);
	} // end read()

	@Override
	public int update(ReplyVO vo) {
		logger.info("update() ȣ�� : vo = " + vo.toString());
		return replyDAO.update(vo);
	} // end update()

	@Override
	public int delete(int replyId) {
		logger.info("delete() ȣ�� : replyId = " + replyId);
		return replyDAO.delete(replyId);
	} // end delete()

} // end ReplyServiceImple
