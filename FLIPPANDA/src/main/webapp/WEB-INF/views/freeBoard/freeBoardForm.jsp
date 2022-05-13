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
		닉네임 : <input type="text" name="writer" disabled><br/> 
		본문 : <textarea name="freeBoardContent" rows="20" cols="100"></textarea><br/>
		<input type="submit" value="writing"> <input type="reset" value="reset">
	</form>
	
</body>
</html>