package edu.spring.ex03.persistence;

import java.util.List;

import edu.spring.ex03.domain.BoardVO;
import edu.spring.ex03.pageutil.PageCriteria;

public interface BoardDAO {
	// ���
	int insert(BoardVO vo);
	
	// ��ü �˻�
	List<BoardVO> select();
	
	// �󼼰˻�(�ϳ��� �˻�)
	BoardVO select(int boardId);
	
	// ����
	int update(BoardVO vo);
	
	// ����
	int delete(int boardId);
	
	// ����¡ ó�� ����
	List<BoardVO> select(PageCriteria criteria);
	
	// �� �Խñ� ��
	int getTotalCounts();
	
	// memberId�� �� ã��
	List<BoardVO> select(String memberId);
	
	// �� �����̳� �������� �Խñ� ã��
	List<BoardVO> selectByTitleOrContent(String keyword);
	
	// ��� ��
	int updateReplyCnt(int amount, int boardId);
	
} // end BoardDAO
