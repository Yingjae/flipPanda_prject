<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.join_form {margin: 100px auto; text-align : center; width:30%; padding : 20px; border: solid #eee 1px;}
	.input-group-text {width : 100px}
</style>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body>
	<div class="join_form">

	<h1>JOIN US</h1>
	<form action="/secu/join" method="post">
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">아이디</span>
			  <input type="text" name="userId"class="form-control" placeholder="아이디"  aria-describedby="basic-addon1" required>
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">비밀번호</span>
			  <input type="password" name="userPw" class="form-control" placeholder="비밀번호"  aria-describedby="basic-addon1" required> 
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">이름</span>
			  <input type="text" name="userName" class="form-control" placeholder="이름"  aria-describedby="basic-addon1" required>
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">닉네임</span>
			  <input type="text" name="userNick" class="form-control" placeholder="닉네임"  aria-describedby="basic-addon1" required>
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">주소</span>
			  <input type="text" name="userAddress" class="form-control" placeholder="주소" aria-describedby="basic-addon1" required>
			</div>
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
			<input class="btn btn-primary" type="submit" value="가입하기">
		</form>
	</div>
</body>
</html>