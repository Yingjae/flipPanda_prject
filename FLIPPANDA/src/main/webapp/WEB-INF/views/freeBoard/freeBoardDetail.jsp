<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1 class="text text-primary">${freeboard.freeBoardNum }</h1>
		<div class="row">
			<div class="col-md-9">
				<input type="text" class="form-control" value="title : ${freeboard.freeBoardTitle }">
			</div>
	 		<div class="col-md-3">
					<input type="text" class="form-control" value="Nickname : ${freeBoard.freeBoardNick }" />
			</div>  
		</div>
		<textarea rows="10" class="form-control">${freeboard.freeBoardContent }</textarea>
		<div class="row">
			<div class="col-md-3">created date :</div>
			<div class="col-md-3">${freeboard.regDate }</div>
			<div class="col-md-3">modified date :</div>
			<div class="col-md-3">${freeboard.updateDate } </div>
		</div> 
		<div class="row">
			<div class="col-md-4">
				<a href="/freeBoard/freeBoardList?pageNum=${param.pageNum == null ? 1 : param.pageNum }&searchType=${param.searchType}&keyword=${param.keyword}" class="btn btn-success">post list</a> <br/>
			</div>
			<div class="col-md-4">
				<form action="/freeBoard/freeBoardUpdateForm" method="post">
					<input type="hidden" name="freeBoardNum" value="${freeboard.freeBoardNum }" />
					<input type="hidden" name="pageNum" value="${param.pageNum }" />
					<input type="hidden" name="searchType" value="${param.searchType}" />
					<input type="hidden" name="keyword" value="${param.keyword}" />
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
					<input type="submit" value="modify" class="btn btn-warning">
				</form>
			</div>
			<div class="col-md-4">
				<form action = "/freeBoard/freeBoardDelete" method="post">
					<input type="hidden" value="${freeboard.freeBoardNum }" name="freeBoardNum"/>
					<input type="hidden" name="pageNum" value="${param.pageNum }" />
					<input type="hidden" name="searchType" value="${param.searchType}" />
					<input type="hidden" name="keyword" value="${param.keyword}" />
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
					<input type="submit" value="delete" class="btn btn-danger">
				</form>
			</div>
		</div>
	</div>
</body>
</html>