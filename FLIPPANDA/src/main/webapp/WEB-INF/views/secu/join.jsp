<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입창</h1>
	<form action="/secu/join" method="post">
		아이디 : <input type="text" name="userId" required ><br/>
		비밀번호 : <input type="text" name="userPw" required><br/>
		이름 :  <input type="text" name="userName" required><br/>
		닉네임 : <input type="text" name="userNick" required><br/>
		주소 : <input type="text" name="userAddress" required><br/>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
		<input type="submit" value="가입하기">
	</form>
</body>
</html>