<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">사용자</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="collection" items="${userList }">				
		<tr>
			<td>${userList.userNick }</a></td>
			<form action="addAuth" method="post">
				<input type="hidden" name="user_num" value="${userList.userNum }">
				<select name="auth">
				<!-- 검색조건을 option태그를 이용해 만듭니다. --> <!-- 닉네임 옵션태그??? -->
					<option value="ROLE_USER">-</option>
					<option value="ROLE_MANAGER"></option>
					<option value="ROLE_MANAGER"></option>
				</select>
				
			</form>
		</tr>
	</c:forEach>
  </tbody>
</table>
</body>
</html>