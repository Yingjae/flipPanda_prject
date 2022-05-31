<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	#modDiv {
		width : 300px;
		height : 100px;
		background-color : green;
		position : absolute;  
		top : 50%;
		left : 50%;
		margin-top : -50px;
		margin-left : -150px;
		padding : 10px;
		z-index: 1000;
	}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- javaScript를 사용하기 위한 번들 주소 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Ajax 댓글 등록 테스트</h2>
	
	<ul id = "replies"> <!-- test기능 가져옴 -->
	
	</ul>
	<!-- 댓글 작성 공간 -->
	<div>
		<div>
			댓글 글쓴이 <input type="text" name ="freeBoardReplyer" id="newReplyWriter">
		</div>
		<div>
			댓글 내용 <input type="text" name="freeBoardReplyContent" id="newReplyText">
		</div>
		<button id="replyAddBtn">댓글 추가</button>
	</div>
	
	
	<div id="modDiv" style="display:none;"> 
		<div class="modal-title">
		</div>
		<div>
			<input type="text" id="freeBoardReplyContent">
		</div>
		<div>
			<button type="button" id="replyModBtn">Modify</button> <!-- 수정 -->
			<button type="button" id="replyDelBtn">Delete</button> <!-- 삭제 -->
			<button type="button" id="closeBtn">Close</button> <!-- 닫기 -->
		</div>
	</div>
	
	<!-- jquery cdn 가져오기 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<!-- 스크립트 태그로 자바스크립트 요청 확인 -->
	<script type="text/javascript">
		let freeBoardNum = 3309;
		
		function getAllList(){
		 	$.getJSON("/replies/all/" + freeBoardNum, function(data){
		 		let str = "";
		 		console.log("받아오는지 보자 : "+ data);
		 		
		 		$(data).each(function() { 
					str += "<li data-freeBoardReplyNum='" + this.freeBoardReplyNum + "' class='replyLi'>"
						+ this.freeBoardReplyNum + ":" + this.freeBoardReplyContent
						+ "<button>수정/삭제</button></li>";
				});
		 		console.log(str);
				$("#replies").html(str);
		 	});
	 	}	
		getAllList(); // 댓글 전체 들고와서 #replies에 심어주는 로직 실행
		
		// insert 구문
		$("#replyAddBtn").on("click", function(){
			var csrfHeaderName = "${_csrf.headerName}";
			var csrfTokenValue="${_csrf.token}";
			
			// 폼이 없기때문에, input태그 내에 입력된 요소를 가져와야 합니다. 
			// 버튼을 누르는 시점에, 글쓴이와 내용 내부에 적힌 문자열을 변수에 저장합니다. 
			var freeBoardReplyer = $("#newReplyWriter").val();
			var freeBoardReplyContent = $("#newReplyText").val();
			
			// $.ajax({내용물}); 이 기본형태 
			$.ajax({
				type : 'post',
				url : '/replies',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				beforeSend : function(xhr) {
					 xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
					 },

				data : JSON.stringify({
					freeBoardNum : freeBoardNum,
					freeBoardReplyer : freeBoardReplyer,
					freeBoardReplyContent : freeBoardReplyContent
				}),
				success : function(result) {
					if(result == 'SUCCESS'){
						alert("등록 되었습니다.");
						
						getAllList();// 댓글 등록 성공시, 다시 목록 갱신 (새로고침 하지 않아도 바로 적용)
						// 댓글 작성 완료 후 폼 태그 비우기. 힌트: .val(넣을값);=갱신
						$("#newReplyWriter").val("");
						$("#newReplyText").val("");					
					}
				}
			});
		});
		
		// .test를 클릭하면 "테스트 클릭 감지"라는 alert를 띄우도록 이벤트를 걸어보세요.
		//$(".test").on("click",function(){
		//	console.log(this); // this는 클릭 된 요소이다. 
			// 클릭요소와 텍스트까지 같이 띄워주세요.(ex : 테스트1 클릭 감지..)
		//	alert(this.html() + "클릭 감지");
		//});
		
		// 이벤트 위임 (버튼 하나하나를 개별적으로 적용)
		$("#replies").on("click", ".replyLi button", function(){ //.reploes > replyLi :button형식으로 작동. (.replyLi를 생략해서 적어도 되는데 가독성을 위해 적음.)
			// 클릭한 요소가 this이고, 현재 button에 걸렸기 때문에
			// this는 button입니다. button의 부모가 바로 .replyLi입니다.
			// 즉, 클릭한 버튼과 연계된 li 태그를 replytag 변수에 저장합니다. 0
			var replytag = $(this).parent();
			console.log(replytag);
			
			// 클릭한 버튼과 연계된 li태그의 data-rno에 든 값 가져와 변수 rno에 저장하기
			var freeBoardReplyNum = replytag.attr("data-freeBoardReplyNum");
			console.log(freeBoardReplyNum);
			
			// rno뿐만 아니라 본문도 가져와야함
			var freeBoardReplyContent = replytag.text(); // 내부 text를 가져옴
			
			//alert(rno + " : " + reply); // 내부 text와 댓글번호를 alert으로 띄움
			
			$(".modal-title").html(freeBoardReplyNum); //modal-title 부분에 글번호 입력
			$("#freeBoardReplyContent").val(freeBoardReplyContent); //reply 영역에 리플 내용을 기입(수정/삭제)
			$("#modDiv").show("slow"); //버튼 누르면 모달 열림
		});
		
		// 모달 창 닫기 이벤트
		$("#closeBtn").on("click", function(){ // #closeBtn 클릭시
			$("#modDiv").hide("slow"); // #modDiv를 닫습니다. //slow는 애니메이션 효과.
		});
		
		// 삭제버튼 작동 (삭제로직)
		$("#replyDelBtn").on("click",function(){
			var csrfHeaderName = "${_csrf.headerName}";
			var csrfTokenValue="${_csrf.token}";
			let freeBoardReplyNum = $(".modal-title").html(); //modal-title내부에 있는 rno를 먼저 받아온다.
			
			$.ajax({ //제이슨 형식으로 요청을 넣기 때문에 ,(콤마)로 나열
				type : 'delete',
				url : '/replies/' + freeBoardReplyNum,
				header : {
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : 'text',
				beforeSend : function(xhr) {
					 xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
					 },
				success : function(result) {
					console.log("result: " + result);
					if(result == 'SUCCESS') {
						alert("삭제 되었습니다.");
						$("#modDiv").hide("slow");
						getAllList(); // 삭제된 댓글 반영한 새 댓글목록갱신
					}
				}
			});
		});
		
		// 수정버튼 작동 (수정로직)
		$("#replyModBtn").on("click",function(){ //수정로직은 제이슨에 대해 받아와야 하기 때문에 어플리케이션 제이슨을 기입
			var csrfHeaderName = "${_csrf.headerName}";
			var csrfTokenValue="${_csrf.token}";
			var freeBoardReplyNum = $(".modal-title").html();
			var freeBoardReplyContent = $("#freeBoardReplyContent").val(); // data정보를 받아오기 위해 필요 (댓글내용을 가져와서 넣어줘야 수정 가능)
			
			$.ajax({
				type : 'patch', // type은 put을 사용해도 정상 작동함. 
				url : '/replies/' + freeBoardReplyNum,
				header : {
					"Content-Type" : "application/json", //rno만으로 돌아가는 delet와 달리 json자료를 추가로 입력받음
					"X-HTTP-Method-Override" : "PATCH"
				},
				contentType : "application/json",
				data : JSON.stringify({freeBoardReplyContent:freeBoardReplyContent}),
				dataType : 'text',
				beforeSend : function(xhr) {
					 xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
					 },
				success : function(result) {
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("수정 되었습니다.");
						$("#modDiv").hide("slow");
						getAllList(); // 수정 완료 후 반영한 새 댓글목록갱신
					}
				}
			});
		});
		
	</script>

</body>
</html>