<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#modDiv{
		width: 300px;
		height: 100px;
		background-color: green;
		position: absolute;
		top: 50%;
		left: 50%;
		margin-top: -50px;
		margin-left: -150px;
		padding: 10px;
		z-index: 1000;
	}
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
				<th>U,D</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="collection" items="${allCollectionList }">				
				<tr>
					<td><a href="/usersCollectionList/${collection.userNum}">${collection.collectionNick }</a></td>
					<td>${collection.collectionTitle }</td>
					<td>${collection.collectionContent }</td>
					<td>
						<c:choose>
							<c:when test="${collection.collectionDate ne collection.collectionUpdateDate}">${collection.collectionUpdateDate } </c:when>
							<c:otherwise>${collection.collectionDate }</c:otherwise>
						</c:choose>
					</td>
					<td>${collection.collectionLike }</td>
					<td>
					<!-- 사용자userNum과 작성자userNum이 같으면 수정 삭제 가시화 -->
					<!-- 로그인 한 user의 userNum을 받아서 sUserNum에 저장 -->
					<sec:authorize access="isAuthenticated()">
						<sec:authentication property="principal.member.userNum" var="sUserNum"/>
					</sec:authorize>
					<!-- sUserNum(사용자)와 userNum(작성자)가 일치하면 수정 삭제 버튼 구현 -->
					<c:if test="${sUserNum eq collection.userNum}">
					<form action="/updateMyCollectionForm" method="post">
						<input type="hidden" name="userNum" value="<sec:authentication property="principal.member.userNum"/>">
						<input type="hidden" value="${collection.collectionNum}" name="collectionNum" />
						<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
						<input type="submit" value="수정" class="btn btn-warning">
					</form>
					<form action="/deleteMyCollection" method="post">
						<input type="hidden" name="userNum" value="<sec:authentication property="principal.member.userNum"/>">
						<input type="hidden" value="${collection.collectionNum}" name="collectionNum" />
						<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
						<input type="submit" value="삭제" class="btn btn-danger">
					</form>
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<sec:authorize access="isAuthenticated()">
		<a href="/insertMyCollection" class="btn btn-success">글쓰기</a>
	</sec:authorize>
	<div id="modDiv" style="display:none;">
		<div class="modal-title"></div>
		<div>
			<input type="text" id="replytext">
		</div>
		<div>
			<button type="button" id="modBtn">Modify</button>
			<button type="button" id="closeBtn">Close</button>
		</div>
	</div>
	
	<h2>ajax test</h2>
	<ul id="allCollectionList">
	
	</ul>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>