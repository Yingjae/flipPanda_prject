<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
	#modDiv {
		width : 500px;
		height : 100px;
		background-color : skyblue;
		border : blue solid 2px;
		position : absolute;  
		top : 50%;
		left : 50%;
		margin-top : -50px;
		margin-left : -150px;
		padding : 10px;
		z-index: 1000;
	}
	#reply{
		width : 450px;
	}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1 class="text text-primary">${freeboard.freeBoardNum }</h1>
		<div class="row">
			<div class="col-md-9">
				<input type="text" class="form-control" value="title : ${freeboard.freeBoardTitle }">
			</div>
	 		<div class="col-md-3">
					<input type="text" class="form-control" value="Nickname : ${freeBoard.freeBoardNick }" />
			</div>  
		</div>
		<textarea rows="10" class="form-control">${freeboard.freeBoardContent }</textarea>
		<div class="row">
			<div class="col-md-3">created date :</div>
			<div class="col-md-3">${freeboard.regDate }</div>
			<div class="col-md-3">modified date :</div>
			<div class="col-md-3">${freeboard.updateDate } </div>
		</div> 
		<div class="row">
			<div class="col-md-4">
				<a href="/freeBoard/freeBoardList?pageNum=${param.pageNum == null ? 1 : param.pageNum }&searchType=${param.searchType}&keyword=${param.keyword}" class="btn btn-success">post list</a> <br/>
			</div>
			<div class="col-md-4">
				<form action="/freeBoard/freeBoardUpdateForm" method="post">
					<input type="hidden" name="freeBoardNum" value="${freeboard.freeBoardNum }" />
					<input type="hidden" name="pageNum" value="${param.pageNum }" />
					<input type="hidden" name="searchType" value="${param.searchType}" />
					<input type="hidden" name="keyword" value="${param.keyword}" />
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
					<input type="submit" value="modify" class="btn btn-warning">
				</form>
			</div>
			<div class="col-md-4">
				<form action = "/freeBoard/freeBoardDelete" method="post">
					<input type="hidden" value="${freeboard.freeBoardNum }" name="freeBoardNum"/>
					<input type="hidden" name="pageNum" value="${param.pageNum }" />
					<input type="hidden" name="searchType" value="${param.searchType}" />
					<input type="hidden" name="keyword" value="${param.keyword}" />
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
					<input type="submit" value="delete" class="btn btn-danger">
				</form>
			</div>
		</div>
	
	<!-- 댓글 영역 -->
	<div class="row">
	<h2 class="text-primary">Reply</h2>
	<!-- -댓글이 추가될 공간 -->
		<div id = "replies">
		
		</div>
	</div>
	
	<!-- 댓글 작성 공간 -->
	<div class="row box-box-success">
		<div class="box-header">
			<h2 class="text-primary">Reply</h2>
		</div><!-- header -->
		<div class="box-body">
			<strong>Writer</strong>
			<input type="text" id="newReplyWriter" placeholder="Replyer" class="form-control">
			<strong>ReplyText</strong>
			<input type="text" id="newReplyText" placeholder="ReplyText" class="form-control">
		</div> <!-- body -->
		<div class="box=footer">
			<button type="button" class="btn btn-success" id="replyAddBtn">Add Reply</button>
		</div> <!-- footer -->
	</div>
	
	</div>	<!--container -->
	
	<!-- 모달 -->
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
	
	<!-- 댓글 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
		let freeBoardNum = ${freeboard.freeBoardNum};
		
		function getAllList(){
		 	$.getJSON("/replies/all/" + freeBoardNum, function(data){
		 		let str = "";
		 		console.log("받아오는지 보자 : "+ data);
		 		
		 		$(data).each(function() { 
		 			let timestamp = this.freeBoardReplyUpdateDate;
					let date = new Date(timestamp);
		 			
					let formattedTime = "게시일 : " + date.getFullYear()
													+ "/"+ (date.getMonth()+1)
													+ "/"+ date.getDate();
					
					str += "<div class='replyLi' data-freeBoardReplyNum ='" + this.freeBoardReplyNum + "'><strong>@"
						+ this.freeBoardReplyer + "</strong> - " + formattedTime + "<br>"
						+ "<div class='freeBoardReplyContent'>" + this.freeBoardReplyContent + "</div>"
						+ "<button type='button' class='btn btn-info'>수정/삭제</button>"
						+ "</div>"; 
					
					//str += "<li data-freeBoardReplyNum='" + this.freeBoardReplyNum + "' class='replyLi'>"
					//	+ this.freeBoardReplyNum + ":" + this.freeBoardReplyContent
					//	+ "<button>수정/삭제</button></li>";
				});
		 		console.log(str);
				$("#replies").html(str);
		 	});
	 	}	
		getAllList();
		
		// 댓글 작성
		$("#replyAddBtn").on("click", function(){
			var csrfHeaderName = "${_csrf.headerName}";
			var csrfTokenValue="${_csrf.token}";
			
			var freeBoardReplyer = $("#newReplyWriter").val();
			var freeBoardReplyContent = $("#newReplyText").val();
			
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
		
		// 이벤트 위임 (버튼 하나하나를 개별적으로 적용)
		$("#replies").on("click", ".replyLi button", function(){ //.reploes > replyLi :button형식으로 작동.

			var replytag = $(this).parent();
			console.log(replytag);
			
			var replyContent = $(this).siblings(".freeBoardReplyContent").text(); 
			
			var freeBoardReplyNum = replytag.attr("data-freeBoardReplyNum");
			console.log(freeBoardReplyNum);
			
			var freeBoardReplyContent = replytag.text(); // 내부 text를 가져옴
			
			
			$(".modal-title").html(freeBoardReplyNum); 
			$("#freeBoardReplyContent").val(replyContent); 
			$("#modDiv").show("slow"); 
		});
		
		// 모달 창 닫기 
		$("#closeBtn").on("click", function(){ 
			$("#modDiv").hide("slow"); 
		});
		
		// 삭제버튼 작동 (삭제로직)
		$("#replyDelBtn").on("click",function(){
			var csrfHeaderName = "${_csrf.headerName}";
			var csrfTokenValue="${_csrf.token}";
			let freeBoardReplyNum = $(".modal-title").html(); 
			
			$.ajax({ 
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
						getAllList(); 
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