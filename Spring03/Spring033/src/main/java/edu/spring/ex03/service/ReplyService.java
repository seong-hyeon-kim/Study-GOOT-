package edu.spring.ex03.service;

import java.util.List;

import edu.spring.ex03.domain.ReplyVO;

public interface ReplyService {
	// C : Create
	int create(ReplyVO vo);
	
	// R : Read
	List<ReplyVO> read(int boardId);
	
	// U : Update
	int update(ReplyVO vo);
	
	// D : Delete
	int delete(int replyId);
	
} // end ReplyService
