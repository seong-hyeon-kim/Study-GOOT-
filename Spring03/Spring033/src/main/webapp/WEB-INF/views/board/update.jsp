<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	margin: 0 auto;
	width: 870px;
}
</style>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>
	<h2>글 수정 페이지</h2>
	<form action="update" method="POST">
		<div>
			<p>글 번호 : ${vo.boardId }</p>
			<input type="hidden" name="boardId" value="${vo.boardId }">
		</div>
		<div>
			<p>제목 : <input type="text" name="boardTitle" value="${vo.boardTitle }"></p>
		</div>
		<div>
			<p>작성자 : ${vo.memberId }</p>
			<fmt:formatDate value="${vo.boardDateCreated }"
			pattern="yyyy년 MM월 dd일 HH:mm:ss" var="boardDateCreated"/>
			<p>작성일 : ${boardDateCreated }</p>
		</div>
		<div>
			<p>내용 : </p>
			<textarea rows="20" cols="120" name="boardContent">${vo.boardContent }</textarea>
		</div>
		<div>
			<input type="hidden" name="page" value="${page }">
		</div>
		<div>
			<input type="submit" value="등록">
		</div>
	</form>

</body>
</html>