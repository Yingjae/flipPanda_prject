<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${cVO.collectionNum }번 게시글 수정페이지입니다.</h1>

	<form action="/updateMyCollection" method="post">
		<input type="hidden" name="collectionNum" value="${cVO.collectionNum }"/>
		제목 : <input type="text" name="collectionTitle" value="${cVO.collectionTitle }">
		<input type="hidden" name="userNum" value="${cVO.userNum }"><br/>
		본문 : <textarea name="collectionContent" rows="20" cols="100">${cVO.collectionContent }</textarea><br/>
		<input type="submit" value="수정">
	</form>
</body>
</html>