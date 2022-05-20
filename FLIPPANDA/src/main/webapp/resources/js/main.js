$(document).ready(function(){	
	/* SIDE PANEL ON/OFF
	function openSidePanel(){
		$('#main').style.width="94%";
		$('#sidePanel').style.width="80%";
	}
	function closeSidePanel(){
		$('#sidePanel').style.width="0%";
		$('#main').style.width="150%";
	}*/
	
	//POP-UP FUNCTION
	$(function(){
		  var $header = $('header');
		  var $fs = $('.front-start'); //MAIN CONTENT ST
		  var $window = $(window);
		  var fsOffsetTop = $fs.offset().top;
		  
		  $window.resize(function(){ 
			  fsOffsetTop = $fs.offset().top;
		  });
		  
		  $window.on('scroll', function(){
		    var scroll = $window.scrollTop() >= fsOffsetTop;
		    $header.toggleClass('down', scroll);
		  });
	});
	
	
	//PRESS ENTER TO SEARCH	
	function press(f){ 
		
		if(f.keyCode == 13){ 
		
		const search = $("#keyword").val();
		const searchType = $("#keywordType").val();

		$("#searchInput").val(search);
		$("#searchType").val(searchType);
		getPage();
		
		search.submit(); 
		} 
	} 
	
	//PRICE INPUT SETUP
	function inputNumberFormat(obj) {
	    obj.value = comma(uncomma(obj.value));
	}
	function comma(str) {
	    str = String(str);
	    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	}
	function uncomma(str) {
	    str = String(str);
	    return str.replace(/[^\d]+/g, '');
	}
	
	
	
//-------------------------------------------------------------------------------------------------------------------------------------//
	
	//AJAX LISTING
	function loadAJAXListInfty(){
		 
		$.ajax({
			 url:"${cpath}/main.ajax",
			 type:"get",
			 dataType:"json",
			 success: auctionListAjax,
			 error:
				function(){
				alert:("error");
				}
		 })
	}
	
	//기존인피닛스크롤을 적용하려면 auction_num이 1씩 증가하며 컨텐츠가 하나씩 뿌려져야함
	//리스트를 front함수에 담는 방식은 적용이
	//
	
	
	function auctionListAjax(data){
		
		var bno = ${board.bno};
		
		console.log(data);

		$.each(data, (index, obj)=>{
		
		let front = "";	
			
			front = "<div id='contents' class='row'>";
			front += "<h3 class='col-md-11'>" + obj.auction_title + "</h3>";
			front += "<p id='writer' class='col-10'>Launched at " + obj.launch_date + "</p>";
			front += "<hr/></div>";
			front += "<div id='contents' class='row'>";
			front += "<img id='conimg' src='resources/img/dummy1.jpeg'/>";
			front += "<p class='text-left'>" + obj.auction_description + "</P>";
			front += "</div>";
			front += "<div id='productamount' class='row'>";
			front += "<table class='table table-hover'>";
			front += "<tr>";
			front += " <th>Current Amount</th>";
			front += "<td>₩ " + obj.current_amount + "</td>";
			front += "</tr>";
			front += "<tr>";
			front += "<th>Bidding</th>";
			front += "<td>" + obj.bid_count + " hits</td>";
			front += "</tr></table></div>";
			
		})
		console.log(front);
		console.log("---------------");
		$("#auctionListAjax").html(front);
	}	 
	
//-------------------------------------------------------------------------------------------------------------------------------------//
	
	//AJAX POST DETAIL
	
	//마우스휠 감지하며 delta값을 auction_num으로 반환해 왓다리갓다리를 적용해야 한다
	//해봐야지 ㅋㅋ
	
	
	
	function loadAJAXDetail(){
		 
		$.ajax({
			 url:"${cpath}/main.${auction_num}",
			 type:"post",
			 dataType:"json",
			 success: auctionDetailAjax, recentlyBid,
			 error: 
				function(){
				alert:("error");
				}
		 })
	}
		
	function auctionDetailAjax(data){
		
		console.log(data);
		
		$.each(data, (index, obj)=>{
		
		let front = "";	
			
			front = "<div id='contents' class='row'>";
			front += "<h3 class='col-md-11'>" + obj.auction_title + "</h3>";
			front += "<p id='writer' class='col-10'>Launched at " + obj.launch_date + "</p>";
			front += "<hr/></div>";
			front += "<div id='contents' class='row'>";
			front += "<img id='conimg' src='resources/img/dummy1.jpeg'/>";
			front += "<p class='text-left'>" + obj.auction_description + "</P>";
			front += "</div>";
			front += "<div id='productamount' class='row'>";
			front += "<table class='table table-hover'>";
			front += "<tr>";
			front += " <th>Current Amount</th>";
			front += "<td>₩ " + obj.current_amount + "</td>";
			front += "</tr>";
			front += "<tr>";
			front += "<th>Bidding</th>";
			front += "<td>" + obj.bid_count + " hits</td>";
			front += "</tr></table></div>";
			
		})
		console.log(front);
		console.log("---------------");
		$("#auctionListAjax").html(front);
	}
	
	function recentlyBid(data){
		
		console.log(data);
		
		let front = "";	
			
			front = "<table class='table table-hover'>";
			front += "<tr>";
			front += "<th class='col-2'>Flip</th>";
			front += "<th class='col-3'>Flipper</th>";
			front += "<th>Amount</th>";
			front += "<th>Date</th>";
			front += "</tr>";
			front += "</table>";
			
			$.each(data, (index, obj)=>{
			
			front = "<table class='table table-hover'>";
			front += "<tr>";
			front += "<td class='col-2'>" + obj.auction_log_num + "</td>";
			front += "<td class='col-3'>" + obj.user_num + "</td>";
			front += "<td>" + obj.auction_bid_log + "</td>";
			front += "<td>" + obj.auction_log_date + "</td>";
			front += "</td>";
			front += "</table>";
			
		})
		console.log(front);
		console.log("---------------");
		$("#recentBidHistory").html(front);
	}	 	 
	
//-------------------------------------------------------------------------------------------------------------------------------------//
	
	//AJAX POSTING
	$("#postBtn").on("click", function(){
		 
		$("#auctionListAjax").hide(); 
	  //$("#auctionListAjax").html("")
		
		$.ajax({
			 url:"${cpath}/main/post",
			 type:"get",
			 dataType:"json",
			 success: auctionPostAjax,
			 error: 
				function(){
				alert:("error");
				$("#auctionListAjax").show(); 
				}
		 })
	})
	
	function auctionPostAjax(){
		
		//POSTFORM
		
		
			
		$("#auctionPostAjax").innerHtml();
	}
	
//-------------------------------------------------------------------------------------------------------------------------------------//	
	
	//AJAX BIDDING
	$("#bidBtn").on("click", function(){
		
		var bid_amount =  Number(document.getElementById("bid_amount").value);
		console.log(bid_amount);
		
		$.ajax({
			url : '/mainBid.ajax',
			type : 'post',
			headers : {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"},
			dataType : 'number',
			data : JSON.parse({bid_amount : biad_amount}),
			success : 
			function(bidResult){
			  
			 if(bidResult == 'Bid Done'){
				
				 alert("Your Bid is Placed.");
				
				 //main	(자동화 테스트 전...)
				 $("#auctionListAjax").getElementsByName("current_amount").value 
				                          = (getAuction.current_amount + bid_amount);
				 //side (역시 마찬가지...)
				 } 
			
			}
	});		
		
		
		
		
		
	})
	
//-------------------------------------------------------------------------------------------------------------------------------------//	
	/*function auctionListAjax2() {
		
		let front = "";
		
		$.getJSON("/main" , function(data){

		console.log(data);
				
		$(data).each(function(){
					
			front = "<div id='contents' class='row'>";
			front += "<h3 class='col-md-11'>" + this.auction_title + "</h3>";
			front += "<p id='writer' class='col-10'>Launched at " + this.launch_date + "</p>";
			front += "<hr/></div>";
			front += "<div id='contents' class='row'>";
			front += "<img id='conimg' src='resources/img/dummy1.jpeg'/>";
			front += "<p class='text-left'>" + this.auction_description + "</P>";
			front += "</div>";
			front += "<div id='productamount' class='row'>";
			front += "<table class='table table-hover'>";
			front += "<tr>";
			front += " <th>Current Amount</th>";
			front += "<td>₩ " + this.current_amount + "</td>";
			front += "</tr>";
			front += "<tr>";
			front += "<th>Bidding</th>";
			front += "<td>" + this.bid_count + " hits</td>";
			front += "</tr></table></div>";
			
					
			console.log(front);
			console.log("---------------");
			})
			$("#auctionListAjax2").html(front);		
		})
	};
	auctionListAjax2();*/
	
	
});
$(document).ready();
