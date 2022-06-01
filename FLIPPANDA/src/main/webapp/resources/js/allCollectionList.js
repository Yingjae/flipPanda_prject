// var는 값이 계속 바뀔 수 있는 변수이고, const는 한번 선언하면 절대 값이 바뀌지 않기 때문에
// const를 선언하는 것이 좋다.
const container = document.getElementById('');
	
	function collection(){
		
		$.ajax({
			url:"",
			type:"GET",
			dataType:"json",
			success: allCollectionListAjax,
			error:
				function(){
					alert:("error");
				}
		})	
	}
	
	function allCollectionListAjax(data){
		
		console.log(data)
		
		$.each(data, (index, collection)=>{
			
			const postElement = document.createElement('tr');
			
			postElement.innerHTML = `
					<td><a href="/usersCollectionList/${collection.userNum}">${collection.collectionNick }</a></td>
					<td>${collection.collectionTitle }</td>
					<td>
						<div class="row">
							<h3 class="text-primary"></h3>

							<div id="uploadResult">
								<ul>
									
								</ul>
							</div>
						</div>
						<img src='/display?fileName=${collection.collectionFname }'>
						${collection.collectionContent }
					</td>
					<td>
						</td>
					<td>${collection.collectionLike }</td>
					<td>
					<sec:authorize access="isAuthenticated()">
						<sec:authentication property="principal.member.userNum" var="sUserNum"/>
					</sec:authorize>
					
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
					
					</td>
			`;
			console.log(postElement);
			container.appendChild();
		})
	}
