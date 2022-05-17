<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="auctionList" items="${auctionList}">
	<article id="auctionDetail">
	<div class="row" style="margin:3%">
		${auctionList.auction_description }
	</div>
	</article>
	</c:forEach>
</body>
</html>