package edu.spring.ex03.persistence;

import java.util.List;

import edu.spring.ex03.domain.BoardVO;
import edu.spring.ex03.pageutil.PageCriteria;

public interface BoardDAO {
	// 등록
	int insert(BoardVO vo);
	
	// 전체 검색
	List<BoardVO> select();
	
	// 상세검색(하나만 검색)
	BoardVO select(int boardId);
	
	// 수정
	int update(BoardVO vo);
	
	// 삭제
	int delete(int boardId);
	
	// 페이징 처리 관련
	List<BoardVO> select(PageCriteria criteria);
	
	// 총 게시글 수
	int getTotalCounts();
	
	// memberId로 글 찾기
	List<BoardVO> select(String memberId);
	
	// 글 제목이나 내용으로 게시글 찾기
	List<BoardVO> selectByTitleOrContent(String keyword);
	
	// 댓글 수
	int updateReplyCnt(int amount, int boardId);
	
} // end BoardDAO
