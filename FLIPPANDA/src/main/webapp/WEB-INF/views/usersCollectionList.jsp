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
 	<!-- my collection, 유저 닉네임 클릭시 해당 유저의 my Collection으로 이동하도록 수정 -->
	<h1><!-- 유저 닉네임을 어떻게 표현하지 -->${userNick }User's Collection</h1>
	
	<div>
	<table border="1" class="table table">
		<thead>
			<tr>
				<th>유저닉네임</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성일</th>
				<th>좋아요</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="collection" items="${usersCollection }">
				<tr>
					<td>${collection.collectionNick }</td>
					<td>${collection.collectionTitle }</td>
					<td>${collection.collectionContent }</td>
					<td>${collection.collectionUpdateDate }</td>
					<td>${collection.collectionLike }</td>
					<td>
					<form action="/updateMyCollectionForm" method="post">
						<input type="hidden" value="${collection.collectionNum}" name="collectionNum" />
						<input type="submit" value="수정" class="btn btn-warning">
					</form>
					<form action="/deleteMyCollection" method="post">
						<input type="hidden" value="${collection.collectionNum}" name="collectionNum" />
						<input type="submit" value="삭제" class="btn btn-danger">
					</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<a href="/allCollectionList" class="btn btn-success">All Collection List</a>
	</div>
	
</body>
</html>