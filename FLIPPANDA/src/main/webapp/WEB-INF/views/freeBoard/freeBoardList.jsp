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
		<a href="/freeBoard/freeBoardList"><h1>Free Board</h1></a>
		<table border="1" class="table table">
			<thead>
				<tr>
					<th>Nick name</th>
					<th>Title</th> 	<!-- 제목 -->
					<th>Created date</th> <!-- 쓴 날짜 -->
					<th>Modified date</th> <!-- 수정날짜 -->
					<th>Views</th> <!-- 조회수 -->
				</tr>
			</thead>
			<tbody>
				<c:forEach var="freeBoard" items="${freeBoardList }">
					<tr>
					  	<td>${freeBoard.freeBoardNick }</td>  	
						<td><a href="/freeBoard/freeBoardDetail/${freeBoard.freeBoardNum }?pageNum=${freePageMaker.freecri.pageNum}&searchType=${freePageMaker.freecri.searchType }&keyword=${freePageMaker.freecri.keyword}">${freeBoard.freeBoardTitle }</a></td>
						<td>${freeBoard.regDate }</td>
						<td>${freeBoard.updateDate }</td>
						<td>${freeBoard.freeBoardViews }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/freeBoard/freeBoardInsert" class="btn btn-success">writing</a> <br/>
		
		<!-- 페이지처리 버튼 
		<ul class="pagination justify-content-center">
		    <c:if test="${freePageMaker.prev }">
		    	<li class="page-item">
		    		<a class="page-link" href="/freeBoard/freeBoardList?pageNum=${freePageMaker.startPage -1  }&searchType=${freePageMaker.freecri.searchType }&keyword=${freePageMaker.freecri.keyword}" aria-label="Previous">
		    			&laquo;
		    		</a>
		    	</li>
		    </c:if>
		    
		    <c:forEach begin="${freePageMaker.startPage }" end="${freePageMaker.endPage }" var="idx">
		    	<li class="page-item ${freePageMaker.freecri.pageNum eq idx ? 'active' : '' }">
		    		<a class="page-link" href="/freeBoard/freeBoardList?pageNum=${idx}&searchType=${freePageMaker.freecri.searchType }&keyword=${freePageMaker.freecri.keyword}">
		    			${idx}
		    		</a>
		    	</li>
		    </c:forEach>
		    
		    <c:if test="${freePageMaker.next && freePageMaker.endPage > 0 }">
		    	<li class="page-item">
		    		<a class="page-link" href="/freeBoard/freeBoardList?pageNum=${freePageMaker.endPage +1 }&searchType=${freePageMaker.freecri.searchType }&keyword=${freePageMaker.freecri.keyword}" aria-label="Next">
		    			&raquo;
		    		</a>
		    	</li>
		    </c:if>
 		 </ul>
 		 -->
 		 
 		 <!-- 검색창 부분 -->
 		 <div class="row">
			<form action="/freeBoard/freeBoardList" method="get">
				<!-- select태그를 이용해 클릭해 검색조건을 선택할수있도록 처리합니다. -->
				<select name="searchType">
				<!-- 검색조건을 option태그를 이용해 만듭니다. --> <!-- 닉네임 옵션태그??? -->
					<option value="n">-</option>
					<option value="t" ${freePageMaker.freecri.searchType eq 't' ? 'selected' : '' }>제목</option>
					<option value="c" ${freePageMaker.freecri.searchType eq 'c' ? 'selected' : '' }>본문</option>
					<option value="w" ${freePageMaker.freecri.searchType eq 'w' ? 'selected' : '' }>닉네임</option>
					<option value="tc" ${freePageMaker.freecri.searchType eq 'tc' ? 'selected' : '' }>제목+본문</option>
					<option value="cw" ${freePageMaker.freecri.searchType eq 'cw' ? 'selected' : '' }>본문+닉네임</option>
					<option value="tcw" ${freePageMaker.freecri.searchType eq 'tcw' ? 'selected' : '' }>제목+본문+닉네임</option>
				</select>
				<input type="text" name="keyword" placeholder="search word" value="${freePageMaker.freecri.keyword }">
				<input type="submit" value="Search">
			</form>
		</div>
		
	</div>
</body>
</html>