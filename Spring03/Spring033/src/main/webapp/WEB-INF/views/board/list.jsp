<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
table, th, td {
	border-style: solid;
	border-width: 1px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

ul {
	list-style-type: none;
	margin-left: 23%;
}

li {
	display: inline-block;
}

th {
	background: #7adf7f;
}

h1 {
	margin-left: 20%;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border-radius: 5px;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
	border-radius: 5px;
}

</style>
<meta charset="UTF-8">
<title>게시판 메인 페이지</title>
</head>
<body>
	<h1>게시판 메인</h1>
	<br>
	<a href="register"><input type="button" value="글 작성"
	style="margin-left: 20%; background-color: #4CAF50; border-radius: 5px; color: white; padding: 8px 16px; border: none;"></a>
	<hr style="margin-left: 20%; margin-right: 20%;">
	
	<table>
		<thead>
			<tr>
				<th style="width: 60px">번호</th>
				<th style="width: 700px">제목</th>
				<th style="width: 120px">작성자</th>
				<th style="width: 100px">작성일</th>
				<th style="width: 60px">댓글 수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.boardId }</td>
					<td><a href="detail?boardId=${vo.boardId }&page=${pageMaker.criteria.page }">${vo.boardTitle }</a></td>
					<td>${vo.memberId }</td>
					<!-- fmt taglib 추가해서 작성날짜를 받아오기 전에 날짜형식을 변경해서 보여준다. -->
					<fmt:formatDate value="${vo.boardDateCreated }"
					pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated"/>
					<td>${boardDateCreated }</td>
					<td>${vo.replyCnt }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<ul class="pagination">
		<c:if test="${pageMaker.isHasPrev() }">
			<li><a href="list?page=${pageMaker.startPageNo - 1 }">Preview</a></li>
		</c:if>
		<c:forEach var="i" begin="${pageMaker.startPageNo }" end="${pageMaker.endPageNo }">
			<li><a href="list?page=${i }" class="active">${i }</a></li>
		</c:forEach>
		<c:if test="${pageMaker.isHasNext() }">
			<li><a href="list?page=${pageMaker.endPageNo + 1 }">Next</a></li>
		</c:if>
	</ul>
	<br>
	<!-- BoardController -> registerPOST() 에서  보낸 데이터 저장 -->
	<input type="hidden" id="insertAlert" value="${insert_result }" >
	
	<!-- jQuery를 쓰기 위해 위에 추가했음 -->
	<script type="text/javascript">
		var result = $('#insertAlert').val();
		if(result == 'success') {
			alert('새 글 작성 성공!>ㅁ<');
		}
	</script>

</body>
</html>