<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인이 되어 있다면 글을 추가하는 로직 -->
	<form action="/insertMyCollection" method="post">
		제목 : <input type="text" name="collectionTitle">
		<input type="hidden" name="userNum" value="<sec:authentication property="principal.member.userNum"/>"><br/>
		<!-- 사진 업로드 자리 -->
		본문 : <textarea name="collectionContent" rows="20" cols="100"></textarea><br/>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
		<input type="submit" value="작성">
	</form>
</body>
</html>