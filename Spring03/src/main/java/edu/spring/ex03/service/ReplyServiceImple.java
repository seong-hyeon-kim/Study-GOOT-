package edu.spring.ex03.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.persistence.BoardDAO;
import edu.spring.ex03.persistence.ReplyDAO;

@Service
public class ReplyServiceImple implements ReplyService{

	private static final Logger logger = LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired
	private ReplyDAO replyDAO;
	@Autowired
	private BoardDAO boardDAO;
	
	// @Transactional
	// - 두 개의 데이터베이스 변경이 생길 때,
	// 위의 내용이 수행되었고, 아래 내용이 에러라면
	// 위의 내용은 rollback 되어야 한다
	// 이러한 기능을 해주는 어노테이션
	// - root-context.xml에서 설정
	
	@Transactional
	@Override
	public int create(ReplyVO vo) throws Exception{
		// 댓글이 증가하면 게시판의 댓글 개수(replyCnt)가 변경되어야 함
		// test_reply 테이블에 insert를 수행하면 test_board 테이블에 update를 수행한다.
		
		logger.info("create() 호출 : vo = " + vo.toString());
		replyDAO.insert(vo);
		logger.info("댓글 입력 성공");
		boardDAO.updateReplyCnt(1, vo.getBoardId());
		logger.info("게시판 댓글 개수 업데이트 성공");
		return 1;
	}

	@Override
	public List<ReplyVO> read(int boardId) {
		logger.info("read() 호출 : boardId = " + boardId); 
		return replyDAO.select(boardId);
	}

	@Override
	public int update(ReplyVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return replyDAO.update(vo);
	}
	
	@Transactional
	@Override
	public int delete(int replyId, int boardId) throws Exception{
		logger.info("delete() 호출 : replyId = " + replyId);
		replyDAO.delete(replyId);
		logger.info("댓글 삭제 성공");
		boardDAO.updateReplyCnt(-1, boardId);
		
		return 1;
	}

}
