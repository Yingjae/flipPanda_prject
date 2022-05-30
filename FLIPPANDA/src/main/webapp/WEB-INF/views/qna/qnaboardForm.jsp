<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
		.detail {
		  font-size: 17px;
		  width: 90%;
		  margin: 0 auto;
		}
</style>
<head>
<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
       
</style>
<body>
<div class="contents">
   <div class="detail">       
     <h1 class="form-header">1:1 문의 작성</h1>
      <form action="/qna/qnaboardInsert" method="post">
             문의제목 : <input type="text" name="qnaTitle">
             작성자 : <input type="text" name="qnaWriter" value="${qnaboardList.qnaWriter}"><br/>
             본문 : <textarea name="qnaContent" row="20" cols="100"></textarea><br/>     
             <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
             <input type="submit" value="문의등록"><input type="reset" value="초기화">
	         <label><input type="checkbox" name="qnaSecret" value="qnaSecret">비공개</label>
     </form>
    </div>
</div>
      
	


</body>
</html>