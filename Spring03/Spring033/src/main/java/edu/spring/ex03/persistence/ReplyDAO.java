package edu.spring.ex03.persistence;

import java.util.List;

import edu.spring.ex03.domain.ReplyVO;

public interface ReplyDAO {
	// 댓글 등록
	int insert(ReplyVO vo);
	
	// 댓글 다 보여주는거
	List<ReplyVO> select(int boardId);
	
	// 댓글 수정
	int update(ReplyVO vo);
	
	// 댓글 삭제
	int delete(int replyId);
	
} // end ReplyDAO
