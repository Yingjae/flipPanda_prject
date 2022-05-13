<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<!-- 최종 작업
		글번호(hide), <유저번호(hide)<=>유저번호 대신 유저닉네임(서브쿼리로 가져오고 현재 유저번호 링크 유저닉네임에 걸기)>
		제목, 내용, 최종수정날짜, 좋아요 수만 확인
		-구현할것 
		유저 닉네임 서브쿼리로 가져오기
		유저 닉네임 클릭시 그 유저의 컬렉션만 모아보기
		좋아요 누를경우 좋아요 수 올라가기 (로그인 안했을경우 로그인 하시겠습니까? 팝업)
		경매 낙찰된 물건 있는 경우 글쓰기 가능 버튼
		댓글 구현x -->		
	<h1>MyCollection</h1>
	<div id="contents">
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
			<c:forEach var="collection" items="${allCollectionList }">				
				<tr>
					<td><a href="/usersCollectionList/${collection.userNum}">${collection.collectionNick }</a></td>
					<td>${collection.collectionTitle }</td>
					<td>${collection.collectionContent }</td>
					<td>${collection.collectionDate }</td>
					<td>${collection.collectionLike }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/insertMyCollection" class="btn btn-success">글쓰기</a>
	</div>
	<div id="footer">
		<%@ include file="collectionListBottom.jsp" %>
	</div>
</body>
</html>