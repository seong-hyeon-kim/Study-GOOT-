<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	margin: 0 auto;
	width: 870px;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>댓글</title>
</head>
<body>
	<div style="text-align: center;">
		작성자 입력 : <input type="text" id="memberId">
		댓글입력 : <input type="text" id="replyContent">
		<button id="btn_add">작성</button>
	</div>
	<div style="text-align: center;">
		<div id="replies"></div>
	</div>
	<div>
		<br><br><br><br><br><br><br><br><br><br><br>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			getAllReplies();
			$('#btn_add').click(function() {
				var boardId = 16; // 게시판 번호 데이터
				var memberId = $('#memberId').val(); // 작성자 데이터
				var replyContent = $('#replyContent').val(); // 댓글 내용
				var obj = {
						'boardId' : boardId,
						'memberId' : memberId,
						'replyContent' : replyContent
				};
				console.log(obj);
				
				// $.ajax로 송수신
				$.ajax({
					type : 'POST',
					url : 'replies',
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'POST'
					},
					data : JSON.stringify(obj), // JSON으로 변환
					success : function(result, status) {
						console.log(result);
						console.log(status);
						if(result == 1) {
							alert('댓글 입력 성공');
							getAllReplies();
						}
					}
				}); // end ajax()
			}); // end btn_add.click
			
			// 게시판 댓글 전체 가져오기
			function getAllReplies() {
				var boardId = 16;
				
				var url = 'replies/all/' + boardId;
				
				$.getJSON(
						url,
						function(data) {
							// data : 서버에서 온 list 데이터가 저장되어 있음.
							// getJSON()에서 json 데이터는 자동으로 parsing됨.
							console.log(data);
						
							var memberId = $('#memberId').val()
							var list = ''; // 댓글 데이터를 HTML에 표현할 문자열 변수
							
							// $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
							$(data).each(function() {
								// this : 컬렉션의 한 줄 데이터를 의미
								console.log(this);
							
								var replyDateCreated = new Date(this.replyDateCreated);
								var disabled = '';
								var readonly = '';
								if(memberId == this.memberId) {
									disabled = '';
									readonly = '';
								}
								
								list += '<div class="reply_item">'
									+ '<pre>'
									+ '<input type="hidden" id="replyId" value="'+ this.replyId +'" />'
									+ '<input type="hidden" id="memberId" value="'+ this.memberId +'" />'
									+ this.memberId
									+ '&nbsp;&nbsp;' // 공백
									+ '<input type="text" id="replyContent" value="'+ this.replyContent +'" ' + readonly + ' />'
									+ '&nbsp;&nbsp;'
									+ replyDateCreated
									+ '&nbsp;&nbsp;'
									+ '<button class="btn_update" style="border: none; border-radius: 5px;" ' + disabled + '>수정</button>'
									+ '&nbsp;&nbsp;'
									+ '<button class="btn_delete" style="border: none; border-radius: 5px;" ' + disabled + '>삭제</button>'
									+ '</pre>'
									+ '</div>';
								
							}); // end each()
							$('#replies').html(list);
							
						} // end function()
						
				); // end getJSON()
				
			} // end getAllReplies()
			
			// 수정 버튼을 클릭하면 선택된 댓글 수정
			// reply item 밑에 btn_update에 클릭 이벤트를 주겠다는 함수
			$('#replies').on('click', '.reply_item .btn_update', function() {
				console.log(this);
				
				// 선택된 댓글의 replyId, replyContent 값을 지정
				// pevAll() : 선택된 노드 이전에 있는 모든 형제 노드를 접관
				var replyId = $(this).prevAll('#replyId').val();
				var replyContent = $(this).prevAll('#replyContent').val();
				console.log("선택된 댓글 번호 : " + replyId + ", 댓글 내용 : " + replyContent); 
				
				// ajax 요청
				$.ajax({
					type : 'PUT',
					url : 'replies/' + replyId,
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'PUT'
					},
					data : JSON.stringify({'replyContent' : replyContent}),
					success : function(result) {
						console.log(result);
						if(result == 1) {
							alert('댓글 수정 성공!');
							getAllReplies();
						}
					}
				}); // end ajax()
			}); // end replies.on()
			
			// 댓글 삭제 기능
			$('#replies').on('click', '.reply_item .btn_delete', function() {
				console.log(this);
				var boardId = 16;
				var replyId = $(this).prevAll('#replyId').val();
				console.log("선택된 댓글 번호 : " + replyId);
				
				$.ajax({
					type : 'DELETE',
					url : 'replies/' + replyId,
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'DELETE'
					},
					data : JSON.stringify({
						'boardId' : boardId
					}),
					success : function(result) {
						console.log(result);
						if(result == 1) {
							alert('댓글 삭제 완료!');
							getAllReplies();
						}
					}
				}) // end ajax()
			}) // end replies.on()
			
		}); // end document
	</script>

</body>
</html>