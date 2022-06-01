<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <div class="container">
		<h1>1:1 문의</h1>
		<table border="1" class="table table">
			<thead>
				<tr style="text-align:center;">
					<th>문의번호</th>	
					<th>제목</th>
					<th>등록일</th>				
					<th>작성자</th>
				</tr>
			</thead>	
			<tbody>
				<c:forEach var="qnaboardList" items="${qnaboardList }">
				   <tr style="text-align:center;"/>
						<td>${qnaboardList.qnaNum}</td>						
						<c:if test="${qnaboardList.qnaSecret == true}">
						    <c:choose>
						        <c:when test="${qnaboardList.qnaWriter eq UserVO.userid || UserVO.authList eq '[ROLE_ADMIN, ROLE_USER]'}"> <!-- 작성자이거나 관리자일 때 -->
						            <td><a href="/qna/qnaboardDetail/${qnaboardList.qnaNum }?pageNum=${qnapageMaker.qnacri.pageNum}"><c:out value="${qnaboardList.qnaTitle}"/><span class="text-muted small"> [${qnaboardList.qnaTitle}]</span></a></td>
						        </c:when>
						        <c:otherwise>
						            <td class="text-secondary"><span class="text-muted small"> 비밀글 </span></td>
						        </c:otherwise>
						    </c:choose>                                            
						</c:if>							
						<td>${qnaboardList.qnaDate}</td>				
						<td>${qnaboardList.qnaWriter}</td>
			</c:forEach>
			</tbody>
		</table>
		<sec:authorize access="isAuthenticated()">
		<a href="/qna/qnaboardInsert"><input type="button" value="문의등록"></a><br/>
		</sec:authorize>
		
		    <!-- 이전페이지 버튼 -->
           	<ul class="pagination justify-content-center">
		  	<c:if test="${qnapageMaker.prev }">
		    	<li class="page-item">
		    		<a class="page-link" href="/qna/qnaboardList?pageNum=${qnapageMaker.startPage -1}">
		    		&laquo;
		    		</a>
		    	</li>
		    </c:if>
		
		    <c:forEach begin="${qnapageMaker.startPage }" end="${qnapageMaker.endPage }" var="idx">
		    	<li class="page-item${qnapageMaker.qnacri.pageNum eq idx ? ' active' : '' }">
		    		<a class="page-link" href="/qna/qnaboardList?pageNum=${idx}">
		    			${idx}
		    		</a>
		    	</li>
		    </c:forEach>
		    
		     <!-- 다음페이지 버튼 -->
              <c:if test="${qnapageMaker.next && qnapageMaker.endPage > 0 }">
		    	<li class="page-item">
		    		<a class="page-link" href="/qna/qnaboardList?pageNum=${qnapageMaker.endPage + 1}">
		    			&raquo;
		    		</a>
		    	</li>
		    </c:if>
		  </ul>
		  
	 
	    </div>
</body>
</html>



