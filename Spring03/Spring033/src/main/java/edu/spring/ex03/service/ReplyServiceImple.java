package edu.spring.ex03.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.persistence.ReplyDAO;

// ReplyDAO와 BoardDAO를 다 쓰기 위해서 서비스를 사용
@Service
public class ReplyServiceImple implements ReplyService {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired
	private ReplyDAO replyDAO;

	@Override
	public int create(ReplyVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return replyDAO.insert(vo);
	} // end create()

	@Override
	public List<ReplyVO> read(int boardId) {
		logger.info("read() 호출 : boardId = " + boardId);
		return replyDAO.select(boardId);
	} // end read()

	@Override
	public int update(ReplyVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return replyDAO.update(vo);
	} // end update()

	@Override
	public int delete(int replyId) {
		logger.info("delete() 호출 : replyId = " + replyId);
		return replyDAO.delete(replyId);
	} // end delete()

} // end ReplyServiceImple
