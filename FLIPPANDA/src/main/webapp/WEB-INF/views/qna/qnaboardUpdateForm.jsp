<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <h1>1:1 문의 수정</h1>
       <form action="/qna/qnaboardUpdate" method="post">
            <input type="hidden" name="qnaNum" value="${qnaboard.qnaNum }"/>
            문의제목 : <input type="text" name="qnaTitle" value="${qnaboard.qnaTitle }">
            작성자 : <input type="text" name="qnaWriter" value="${qnaboard.qnaWriter }"> 유저번호 : <input type="text" name="userNum" value="${qnaboard.userNum }"><br/>
            본문 : <textarea name="qnaContent" row="20" cols="100">${qnaboard.qnaContent }</textarea><br/>
            <input type="hidden" name="qnasearchType" value="${param.qnasearchType }" />
		    <input type="hidden" name="qnakeyword" value="${param.qnakeyword }" />
		    <input type="hidden" name="qnapageNum" value="${param.qnapageNum }" />
		    <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
            <input type="submit" value="등록"><input type="reset" value="초기화">
       </form>

</body>
</html>