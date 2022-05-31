<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${freeboard.freeBoardNum }번글 수정페이지</h1>
	<form action="/freeBoard/freeBoardUpdate" method="post">
		<input type="hidden" name="freeBoardNum" value="${freeboard.freeBoardNum }"/>
		제목 : <input type="text" name="freeBoardTitle" value="${freeboard.freeBoardTitle }"><br/>
	<!--  	글쓴이 : <input type="text" name="writer" value="${board.writer }"><br/> -->
		본문 : <textarea name="freeBoardContent" rows="20" cols="100">${freeboard.freeBoardContent }</textarea><br/>
		<input type="hidden" name="searchType" value="${param.searchType}" />
		<input type="hidden" name="keyword" value="${param.keyword}" />
		<input type="hidden" name="pageNum" value="${param.pageNum }" />
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
		<input type="submit" value="글쓰기"> <input type="reset" value="초기화">
	</form>
	
</body>
</html>