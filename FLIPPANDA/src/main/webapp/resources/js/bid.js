		
	//AJAX POSTFORM
	$("#postBtn").on("click", function(){
	
	$('#auctionListAjax').fadeOut(100, function(){ $(this).remove();});
	$('.user_profile').hide(0);
	$('.posting').fadeIn(300, function(){ $(this).show();});
	
			$.ajax({
				 url:"/main/postAuctionForm",
				 type:"post",
				 dataType:"json",
				 contentType: "application/json",
				 success: 
					function(){$("#auctionPostAjax").style.display = 'block';},
				 error: 
					function(){
					alert:("error");
					$("#auctionListAjax").show(); 
					}
			 })
		})
		
		//AJAX CHECK RTB
		$("#RTBbtn").on("click", function(){
			 
			$("#RTB").show(); 
		})
		
		//AJAX POSTING
		$("#postAuctionBtn").on("click", function(){
			 
			var PostParam = {
				
				auction_title: $("#auction_title").val(),
				product_name: $("#product_name").val(),
				product_category: $("#product_category").val(),
				auction_description: $("#auction_description").val(),
				user_num: $("#user_num").val(),
				start_amount:$("#start_amount").val(),
				RTB_price: $("#RTB_price").val()
			}
			
			$.ajax({
				 url:"/main/postAuction",
				 type:"post",
				 dataType:"json",
				 data: PostParam,
				 contentType: "application/json",
				 success: 
					function(){	
					$("#auctionPostAjax").hide();
					$('#auctionListAjax').fadeIn(100, function(){ $(this).show();});
					},
				 error: 
					function(){
					alert:("error");
					}
			 })
		})
		
	//-------------------------------------------------------------------------------------------------------------------------------------//	
		
		//AJAX BIDDING
		$("#bidBtn").on("click", function(){
			
			var BidParam = {
				
			user_num: $("#user_num").val(),
			bid_amount = $("#bid_amount").val()
			}
			
			console.log(BidParam);
			
			$.ajax({
				url : '/main/bidNowAjax',
				type : 'post',
				headers : {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"},
				dataType : "JSON",
				data : BidParam,
				success : 
				function(bidResult){
				  
				 if(bidResult == 'Bid Done'){
					
					 alert("Your Bid is Placed.");
					 
					 /*main	(자동화 테스트 전...)
					 $("#auctionListAjax").getElementsByName("current_amount").value 
					                          = (getAuction.current_amount + bid_amount);
					 //side에 입찰막기 시전해야함 */
					 }
				},
				error: function(){
					alert:("error");
					}
				})
		});		