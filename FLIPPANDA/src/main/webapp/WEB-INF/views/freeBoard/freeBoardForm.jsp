<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/freeBoard/freeBoardInsert" method="post">
		제목 : <input type="text" name="freeBoardTitle"><br/>
	 <!-- <input type="hidden" name="userNum" value="${userNum}"><br/> 	-->
 	    user :  <input type="text" name="userNum" value="4" readonly/></br>	
		본문 : <textarea name="freeBoardContent" rows="20" cols="100"></textarea><br/>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
		<input type="submit" value="writing"> <input type="reset" value="reset">
	</form>
	
</body>
</html>