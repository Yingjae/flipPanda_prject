<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.userDataTable {margin: 100px auto; text-align : center; width:70%; padding : 20px; border: solid #eee 1px;}
	.clear:after{clear: both; display:block; content:"";}
	#authListItem {list-style:none; float:left; width: 30%}
</style>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body>
<div class = "userDataTable">
	<h1> 사용자 권한 수정</h1>
	<hr>
	<table class="table">
  <thead>
    <tr>
      <th scope="col-3">사용자</th>
      <th scope="col-3">권한</th>
      <th scope="col-3">현재 권한</th>
      <th scope="col-3">현재 권한</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="userData" items="${userDataList }">
    	<c:if test="${userData.authList[0].auth ne 'ROLE_MASTER' }">	
			<tr>
				<form action="addAuth" method="post">
				<td>${userData.userNick }</td>
				<td>
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
					<input type="hidden" name="userNum" value="${userData.userNum }">
					<select name="auth">
						<option value="ROLE_USER" id="auth">ROLE_USER</option>
						<option value="ROLE_ADMIN" id="auth">ROLE_ADMIN</option>
						<option value="ROLE_BANNED" id="auth">ROLE_BANNED</option>
					</select>
				</td>
				<td>${userData.authList[0].auth }</td>
				<td><input class="btn btn-primary" type="submit" value="권한수정"></td>
				</form>
			</tr>
		</c:if>		
	</c:forEach>
  </tbody>
</table>
</div>
</body>
</html>