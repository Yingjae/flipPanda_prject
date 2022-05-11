<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title> 자바스트립트, CSS파일 불러오기</title>
<script src="${path}/resources/js/test.js"></script>
<link href="${path}/resources/css/test.css" rel="stylesheet"/> 	
	<title>Home</title>
</head>
<body> 
	${path}
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
