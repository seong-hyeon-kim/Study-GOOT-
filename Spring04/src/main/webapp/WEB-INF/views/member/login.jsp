<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<h1>로그인</h1>
<form action="login" method="POST">
	<input type="text" name="memberId"
	placeholder="memberId" required="required" autofocus="autofocus">
	<br>
	<input type="password" name="password" placeholder="password" required="required"><br>
	<input type="submit" value="로그인">
	
</form>

</body>
</html>