<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul id="replies">
	
	</ul>
	<button id = "requestBtn">댓글 로딩해오기</button>
	
	<!-- jquery cdn -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<script type="text/javascript">
	let freeBoardNum = 530;
		
	// onClick이 걸려있으므로, 실행 조건은 클릭시 실행
	$("#requestBtn").on("click",function(){
		// #replies 사이에 들어갈 태그를 저장하는 변수
		let str="";
		// #requestBtn클릭시
		$.getJSON("/replies/all/" + freeBoardNum, function(data){
			// 댓글 집어넣어주는 로직 실행
			console.log(data);
			$(data).each(function(){
				// str에 적절하게 댓글형식으로 문자열을 추가해주신다음
				str += "<li>" + this.freeBoardReplyNum + ":" +this.freeBoardReplyContent + "</li>";
				console.log(str);
				console.log("---------");
			});
			// #replies에 댓글을 끼워넣어주세요.
			$("#replies").html(str);
		});
		
	});
	</script>
</body>
</html>