package edu.spring.ex03.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.service.ReplyService;

// * RESTful url�� �ǹ�
// /replies (POST) : ��� �߰�(insert)
// /replies/all/���� (GET) : �ش� �� ��ȣ(boardId)�� ��� ��� �˻�(select)
// /replies/���� (PUT) : �ش� ��� ��ȣ(replyId)�� ������ ����(update)
// /replies/���� (DELETE) : �ش� ��� ��ȣ(replyId)�� ����� ����(delete)

@RestController
@RequestMapping(value="/replies")
public class ReplyRESTController {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyRESTController.class);
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping // POST : ��� �Է�
	public ResponseEntity<Integer> createReply(@RequestBody ReplyVO vo) {
		// @RequestBody
		// - Ŭ���̾�Ʈ���� ���۹��� json �����͸� �ڹ� ��ü�� ��ȯ ���ִ� annotation
		logger.info("createReply() ȣ�� : vo = " + vo.toString());
		
		// ResponseEntity<T> : REST ��Ŀ��� �����͸� ������ �� ���̴� ��ü
		// - �����Ϳ� HttpStatus�� ����
		// - <T> : �������� �ϴ� ������ Ÿ��
		int result = replyService.create(vo);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
		
	} // end createReply()
	
	@GetMapping("/all/{boardId}") // GET: ��� ����(all)
	public ResponseEntity<List<ReplyVO>> readReplies(@PathVariable("boardId") int boardId) {
		// @PathVariable("boardId") : /all/{boardId} ���� ������ ������ ����
		
		List<ReplyVO> list = replyService.read(boardId);
		return new ResponseEntity<List<ReplyVO>>(list, HttpStatus.OK);
		
	} // end readReplies()
	
	@PutMapping("/{replyId}") // PUT : ��� ����
	public ResponseEntity<Integer> updateReply(
			@PathVariable("replyId") int replyId,
			@RequestBody ReplyVO vo) {
		vo.setReplyId(replyId);
		int result = replyService.update(vo);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
		
	} // end updateReply()
	
	@DeleteMapping("/{replyId}") // DELETE : ��� ����
	public ResponseEntity<Integer> deleteReply(@PathVariable("replyId") int replyId) {
		logger.info("replyId = " + replyId);
		int result = replyService.delete(replyId);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end deleteReply()

} // end ReplyRESTController
