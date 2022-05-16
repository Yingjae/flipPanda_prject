<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/updateTest" method="post">
		<input type="text" name="userName" placeholder="userName" value="${userData.userName }"/>
		<input type="text" name="userAddress" placeholder="userAddress" value="${userData.userAddress }"/>
		<input type="text" name="userPw" placeholder="userPw" value="${userData.userPw }"/>
		<input type="text" name="userNick" placeholder="userNick" value="${userData.userNick }"/>
		<input type="hidden" name="userNum" value="${userData.userNum }"/>
		<input type="submit" />
	</form>
</body>
</html>