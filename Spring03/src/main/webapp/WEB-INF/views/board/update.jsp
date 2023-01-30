<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 페이지</title>
</head>
<body>
	<h2>글 수정 페이지</h2>
	<form action="update" method="POST">
	<input type="hidden" name="page" value="${page} ">
	<div>
			<p>글 번호 : ${vo.boardId }</p>
			<input type="hidden" name="boardId" value="${vo.boardId }">			
		</div>
		<div>
			<p>제목 : </p>
			<input type="text" name="boardTitle" value="${vo.boardTitle }">			
		</div>
		<div>
			<p>작성자 : ${vo.memberId }</p>
			<p>작성일 : ${vo.boardDateCreated }</p>
			<br>
		</div>
		<div>
			<p>내용 : </p>
			<textarea rows="20" cols="120" name="boardContent">${vo.boardContent }</textarea>
		</div>
		<div>
			<input type="submit" value="수정">
		</div>
	
	</form>

</body>
</html>