<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 글을 추가하는 로직 -->
	<form action="/insertMyCollection" method="post">
		제목 : <input type="text" name="collectionTitle">
		작성자 : <input type="text" name="userNum" ><br/>
		본문 : <textarea name="collectionContent" rows="20" cols="100"></textarea><br/>
		<input type="submit" value="작성">
	</form>
</body>
</html>