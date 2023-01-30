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
	// - �� ���� �����ͺ��̽� ������ ���� ��,
	// ���� ������ ����Ǿ���, �Ʒ� ������ �������
	// ���� ������ rollback �Ǿ�� �Ѵ�
	// �̷��� ����� ���ִ� ������̼�
	// - root-context.xml���� ����
	
	@Transactional
	@Override
	public int create(ReplyVO vo) throws Exception{
		// ����� �����ϸ� �Խ����� ��� ����(replyCnt)�� ����Ǿ�� ��
		// test_reply ���̺� insert�� �����ϸ� test_board ���̺� update�� �����Ѵ�.
		
		logger.info("create() ȣ�� : vo = " + vo.toString());
		replyDAO.insert(vo);
		logger.info("��� �Է� ����");
		boardDAO.updateReplyCnt(1, vo.getBoardId());
		logger.info("�Խ��� ��� ���� ������Ʈ ����");
		return 1;
	}

	@Override
	public List<ReplyVO> read(int boardId) {
		logger.info("read() ȣ�� : boardId = " + boardId); 
		return replyDAO.select(boardId);
	}

	@Override
	public int update(ReplyVO vo) {
		logger.info("update() ȣ�� : vo = " + vo.toString());
		return replyDAO.update(vo);
	}
	
	@Transactional
	@Override
	public int delete(int replyId, int boardId) throws Exception{
		logger.info("delete() ȣ�� : replyId = " + replyId);
		replyDAO.delete(replyId);
		logger.info("��� ���� ����");
		boardDAO.updateReplyCnt(-1, boardId);
		
		return 1;
	}

}
