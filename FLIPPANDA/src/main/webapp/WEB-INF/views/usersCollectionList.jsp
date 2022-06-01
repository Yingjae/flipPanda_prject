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
</head>
<body>
 	<!-- my collection, 유저 닉네임 클릭시 해당 유저의 my Collection으로 이동하도록 수정 -->
	<h1><!-- 유저 닉네임을 어떻게 표현하지 -->User's Collection</h1>
	
	<div>
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
 			<c:forEach var="collection" items="${usersCollection }">
				<tr>
					<td>${collection.collectionNick }</td>
					<td>${collection.collectionTitle }</td>
					<td>
						<div class="row">
							<h3 class="text-primary"></h3>
							<div id="uploadResult">
								<ul>
									<!-- 첨부파일 들어갈 위치 -->
								</ul>
							</div><!-- #uploadResult -->
						</div><!-- row -->
						${collection.collectionContent }
					</td>
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
					<c:if test="${sUserNum eq userNum}">
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
		<a href="/allCollectionList" class="btn btn-success">All Collection List</a>
	</div>
	<script>
	
	var uploadResult = $(".uploadResult ul");
			
			function showUploadedFile(uploadResultArr){
				var str = "";
				
				$(uploadResultArr).each(function(i, obj){
					// BoardAttachVO내부에서 이미지여부를 fileType변수에 저장하므로 obj.image -> obj.fileType
					if(!obj.fileType){
						var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
						
						str += "<li "
							+ "data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid
							+ "' data-filename='" + obj.fileName + "' data-type='" + obj.fileType
							+ "'><a href='/download?fileName=" + fileCallPath
							+ "'>" + "<img src='/resources/attach.png'>"
							+ obj.fileName + "</a>"
							+ "<span data-file=\'" + fileCallPath + "\' data-type='file'> X </span>"
							+ "</li>";
						
						
					} else {
						//str += "<li>" + obj.fileName + "</li>";
						var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
						var fileCallPathOriginal = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
						
						str += "<li "
							+ "data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid
							+ "' data-filename='" + obj.fileName + "' data-type='" + obj.fileType
							+ "'><a href='/download?fileName=" + fileCallPathOriginal
							+ "'>" + "<img src='/display?fileName="+ fileCallPath + "'>"
							+ obj.fileName + "</a>"
							+ "<span data-file=\'" + fileCallPath + "\' data-type='image'> X </span>"
							+ "</li>";
					}
				});
				uploadResult.append(str);
			}// showUploadedfile
	</script>
</body>
</html>