package edu.spring.ex03.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex03.domain.ReplyVO;

@Repository
public class ReplyDAOImple implements ReplyDAO {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReplyDAOImple.class);
	private static final String NAMESPACE = 
			// mapper에 NAMESPACE와 같게 설정 해야함
			"edu.spring.ex03.ReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ReplyVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	} // end insert()

	@Override
	public List<ReplyVO> select(int boardId) {
		logger.info("select() 호출 : boardId = " + boardId);
		return sqlSession.selectList(NAMESPACE + ".select_all_by_board_id", boardId);
	} // end select()

	@Override
	public int update(ReplyVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	} // end update()

	@Override
	public int delete(int replyId) {
		logger.info("delete() 호출 : replyId = " + replyId);
		return sqlSession.delete(NAMESPACE + ".delete", replyId);
	} // end delete()

} // end ReplyDAOImple
