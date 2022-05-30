 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	#modDiv {
		width:500px;
		height:100px;
		background-color : aqua;
		border : black solid 2px;
		position : absolute;
		top:50%;
		left:50%;
		margin-top:-50px;
		margin-left:-250px;
		padding:10px;
		z-index:1000; 
	}
	#reply {
		width:450px;
	}
	
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <div class="container">
              <h1 class="text text-primary">${qnaboardList.qnaNum}번 문의</h1>
              <div class="row">
                    <div class="col-md-9">
                          <input type="text" class="form-control" value=" 문의제목: ${qnaboardList.qnaTitle }" />
                    </div>
                    <div class="col-md-3">
                          <input type="text" class="form-control" value="작성자 : ${qnaboardList.qnaWriter }" />
                    </div>
              </div>
       </div>
       <textarea rows="10" class="form-control">${qnaboardList.qnaContent }</textarea>
       <div class="row">
              <div class="col-md-3">작성일 : </div>
              <div class="col-md-3">${qnaboardList.qnaDate }</div>
              <div class="col-md-3">수정일 : </div>
              <div class="col-md-3">${qnaboardList.qnaUpdateDate }</div>
       </div>
       <div class="row">
              <div class="col-md-1">
                    <button><a href="/qna/qnaboardList?qnapageNum=${param.qnapageNum == null ? 1 : param.qnapageNum}&qnasearchType=${param.qnasearchType }&keyword=${param.qnakeyword}">글목록</a></button>
              </div>
       </div>
       <div class="col-md-1">
              <form action="/qna/qnaboardDelete" method="post">
                    <input type="hidden" value="${qnaboardList.qnaNum }" name="qnaNum" />
                    <input type="hidden" name="qnapageNum" value="${param.qnapageNum}" />
					<input type="hidden" name="qnasearchType" value="${param.qnasearchType}" />
					<input type="hidden" name="qnakeyword" value="${param.qnakeyword}" />
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
                    <input type="submit" value="삭제">
              </form>
       </div>
       <div class="col-md-1">
               <form action="/qna/qnaboardUpdateForm" method="post">
                    <input type="hidden" name="qnaNum" value="${qnaboardList.qnaNum }" />
                    <input type="hidden" name="pageNum" value="${param.qnapageNum}" />
					<input type="hidden" name="searchType" value="${param.qnasearchType}" />
					<input type="hidden" name="keyword" value="${param.qnakeyword}" />
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
                    <input type="submit" value="수정">
               </form>
       </div>
       
       <!-- 댓글영역 -->
	<h2>댓글</h2>
	<!-- 댓글이 추가될 공간 -->
	<div class="row">
		<ul id="replies">
		
		</ul>
	</div>
	<!-- 댓글 작성 공간 -->
	<div class="row box-box-success">
		<div class="box-header">
			<h2 class="text-primary">댓글 작성</h2>
		</div><!-- header -->
		<div class="box-body">
			<strong>글쓴이</strong>
			<input type="text" id="newReplyWriter" placeholder="글쓴이" class="form-control">
			<strong>댓글내용</strong>
			<input type="text" id="newReplyText" placeholder="댓글내용" class="form-control">
		</div><!-- body -->
		<div class="box-footer">
			<button type="button" class="btn btn-success" id="replyAddBtn">글쓰기</button>
		</div>
	</div>
	
	<!-- modal은 일종의 팝업입니다.
	단, 새 창을 띄우지는 않고 css를 이용해 특정 태그가 조건부로 보이거나 안 보이도록 처리해서 
	마치 창이 새로 띄워지는것처럼 만듭니다
	따라서 눈에 보이지는 않아도 modal을 구성하는 태그 자체는 화면에 미리 적혀있어야 합니다.-->
	<div id="modDiv" style="display:none;">
		<div class="modal-title">
		</div>
		<div>
			<input type="text" id="reply">
		</div>
		<div>
			<button type="button" id="replyModBtn">수정</button>
			<button type="button" id="replyDelBtn">삭제</button>
			<button type="button" id="closeBtn">닫기</button>
		</div>
	</div>
	
	
	<!-- jquery cdn 가져오기 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	
	<!-- 여기부터 댓글 비동기 처리 자바스크립트 처리 영역 -->
	<script>
		let qnaNum = ${qnaboardList.qnaNum};
		var csrfHeaderName = "${_csrf.headerName}"
        var csrfTokenValue="${_csrf.token}"
		
		// 전체 댓글 가져오기
		function getAllList(){
			$.getJSON("/qnareplies/all/" + qnaNum, function(data){
				let str = "";
				
				$(data).each(function(){
					
					let timestamp = this.updateDate;
					let date = new Date(timestamp);
					
					let formattedTime = "게시일 : " + date.getFullYear()
										 + "/" + (date.getMonth()+1)
                                                     + "/" + date.getDate()     
                                                     + " " + date.getHours()+"시 "
                                                     + " " + date.getMinutes()+"분 "
                                                     + " " + date.getSeconds()+"시 ";
                                    
				
					str += "<div class='replyLi' data-qnareplyNum='" + this.qnareplyNum + "'><strong>@"
						+ this.qnareplyer + "</strong> - " + formattedTime + "<br>"
						+ "<div class='reply'>" + this.qnareplyContent + "</div>"
						+ "<button type='button' class='btn btn-info'>수정/삭제</button>"
						+ "</div>";
								
				});
			
				console.log(str);
				$("#replies").html(str);			
			});
		}		
		getAllList();
	
		
		// 댓글 작성 
		$("#replyAddBtn").on("click", function(){
			
			// 폼이 없기때문에, input태그 내에 입력된 요소를 가져와야 합니다.
			// 버튼을 누르는 시점에, 글쓴이와 내용 내부에 적힌 문자열을 변수에 저장합니다. 
			var qnareplyer = $("#newReplyWriter").val();
			var qnareplyContent = $("#newReplyText").val();
			
			$.ajax({
				type : 'post',
				 beforeSend : function(xhr) {
                     xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
                 },
				url : '/qnareplies',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					qnaNum : qnaNum,
					qnareplyer : qnareplyer,
					qnareplyContent : qnareplyContent
				}),
				success : function(result){
					if(result == 'SUCCESS'){
						alert("등록 되었습니다.");
						getAllList();// 댓글 등록 성공시, 다시 목록 갱신
						$("#newReplyWriter").val("");
						$("#newReplyText").val("");
					}
				}
			});		
			
		});
		
		// 이벤트 위임
		$("#replies").on("click", ".replyLi button", function(){
			// 클릭한 요소가 this이고, 현재 button에 걸렸기 때문에
			// this는 button 입니다. button의 부모가 바로 .replyLi 입니다.
			// 즉, 클릭한 버튼과 연계된 li 태그를 replytag 변수에 저장합니다. 
			var replytag = $(this).parent();
			var replyContent = $(this).siblings(".reply").text();
						
			var qnareplyNum = replytag.attr("data-qnareplyNum");
					
			$(".modal-title").html(qnareplyNum); //modal-title 부분에 글번호 입력
			$("#reply").val(replyContent);// reply 영역에 리플 내용을 기입(수정/삭제)
			$("#modDiv").show("slow");// 버튼누르면 모달 열림
		});
		
		// 모달 창 닫기 이벤트
		$("#closeBtn").on("click", function(){// #closeBtn 클릭시
			$("#modDiv").hide("slow");// #modDiv를 닫습니다
		});
		
		// 삭제로직
		$("#replyDelBtn").on("click", function(){
			let qnareplyNum = $(".modal-title").html();		
			
			$.ajax({
				type : 'delete',
				 beforeSend : function(xhr) {
                     xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
                 },
				url : '/qnareplies/' + qnareplyNum,
				header : {
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : 'text',
				success : function(result) {
					console.log("result : " + result);
					if(result == 'SUCCESS'){
						alert("삭제 되었습니다.");
						$("#modDiv").hide("slow");
						getAllList();// 삭제된 댓글 반영한 새 댓글목록갱신
					}
				}
			});
		});
		
		// 수정로직
		$("#replyModBtn").on("click", function(){
			let qnareplyNum = $(".modal-title").html();		
			let qnareplyContent = $("#reply").val();// 댓글내용을 가져와서 넣어줘야 수정 가능
			
			$.ajax({
				type : 'put',
				 beforeSend : function(xhr) {
                     xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
                 },
				url : '/qnareplies/' + qnareplyNum,
				header : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "PUT"
				},
				contentType : "application/json",// json 자료를 추가로 입력받기 때문에
				dataType : 'text',
				data: JSON.stringify({qnareplyContent:qnareplyContent}),
				success : function(result) {
					console.log("result : " + result);
					if(result == 'SUCCESS'){
						alert("수정 되었습니다.");
						$("#modDiv").hide("slow");
						getAllList();// 삭제된 댓글 반영한 새 댓글목록갱신
					}
				}
			});
		});
		
		
		
	</script> 

</body>
</html>