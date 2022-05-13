<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${userNick }</h1>
	
	<div>
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
				<c:forEach var="freeBoard" items="${usersFreeBoardList }">
					<tr>
					  	<td>${freeBoard.freeBoardNick }</td>  	
						<td>${freeBoard.freeBoardTitle }</a></td>
						<td>${freeBoard.regDate }</td>
						<td>${freeBoard.updateDate }</td>
						<td>${freeBoard.freeBoardViews }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>