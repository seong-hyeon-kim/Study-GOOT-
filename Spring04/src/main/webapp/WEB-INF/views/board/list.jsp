<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>게시판 메인 페이지</title>
</head>
<body>
	<h1>게시판 메인</h1>
	<c:if test="${empty memberId}">
		<button type="button" id="btn_login">로그인</button>
	</c:if>
	
	
	<c:if test="${not empty memberId}">
		<button type="button" id="btn_logout">로그아웃</button>	
	</c:if>
	
	
	<hr>
	<a href="register">새 글 작성</a>
	<a href="test?data1=한글&data2=abc1234def">로그인이 필요한 메뉴</a>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$('#btn_login').click(function(){
				var target = encodeURI('/ex04/member/login');
				location = target;
			}); // end btn_login.click();
			
			$('#btn_logout').click(function(){
				location = '../member/logout';
			}); // end btn_logout.click();
		})
	</script>
	
</body>
</html>