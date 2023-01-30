<%@page import="edu.spring.ex03.pageutil.PageMaker"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
<style type="text/css">
table, th, td {
	border-style: solid;
	border-width: 1px;
	text-align: center;
}

ul {
	list-style-type: none;
}

li {
	display: inline-block;
}
</style>
<meta charset="UTF-8">
<title>게시판 메인 페이지</title>
</head>
<body>
<i class="fas fa-cloud"></i>
<i class="fas fa-cloud"></i>

	<h1>게시판 메인</h1>
	
	
	<br>
	<a href="register"><input type="button" value="글 작성"></a>
	<hr>

	<table>
		<thead>
			<tr>
				<th style="width: 60px">번호</th>
				<th style="width: 700px">제목</th>
				<th style="width: 120px">작성자</th>
				<th style="width: 100px">작성일</th>
				<th style="width: 60px">댓글수</th>
			</tr>
		</thead>

		<tbody>
         <c:forEach var="vo" items="${list }">
            <tr>
               <td>${vo.boardId}</td>
               <td><a href="detail?boardId=${vo.boardId}&page=${pageMaker.criteria.page}">${vo.boardTitle}</a></td>
               <td>${vo.memberId}</td>
               <fmt:formatDate value="${vo.boardDateCreated}"
               pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated"/>
               <td>${boardDateCreated}</td>
               <td>${vo.replyCnt}</td>
            </tr>

			</c:forEach>

		</tbody>

	</table>

	<ul>
		<c:if test="${pageMaker.isHasPrev()}">
			<li><a href="list?page=${pageMaker.getStartPageNo() - 1}">이전</a></li>
		</c:if>
	
		<c:forEach var="i" begin="${pageMaker.startPageNo }" end="${pageMaker.endPageNo }">
			<li><a href="list?page=${i}">${i }</a></li>
		</c:forEach>
		
		<c:if test="${pageMaker.isHasNext()}">
			<li><a href="list?page=${pageMaker.getEndPageNo() + 1}">다음</a></li>
		</c:if>
		
		
		
	</ul>

	<!-- BoardControlller -> registerPOST() 에서 보낸 데이터 저장 -->
	<input type="hidden" id="insertAlert" value="${insert_result}">
		
	<script type="text/javascript">
		var result = $('#insertAlert').val();
		if(result == 'success') {
			alert('새 글 작성 성공!');
		}
	</script>

</body>
</html>





