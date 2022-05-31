<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Ajax 테스트</h2>
	
	<ul id="replies">
	
	
	</ul>
	
	<!-- jquery cdn 로드 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<script type="text/javascript">
	 	let freeBoardNum = 530;
		
	 	function getAllList(){
		 	$.getJSON("/replies/all/" + freeBoardNum, function(data){
		 		let str = "";
		 		console.log(data);
		 		
		 		$(data).each(function() { 
					// 하나하나 반복되는 각 데이터는 this라는 키워드로 표현됩니다. 
					// data-변수명=변수 를 사용해 나중에 수정이나 하나하나 관리할 때 사용
					str += "<li data-freeBoardReplyNum='" + this.freeBoardReplyNum + "' class='replyLi'>"
						+ this.freeBoardReplyNum + ":" + this.freeBoardReplyContent
						+ "</li>";
				});
		 		console.log(str);
				$("#replies").html(str);
		 	});
	 	}	
	 	getAllList();
	</script>
</body>
</html>