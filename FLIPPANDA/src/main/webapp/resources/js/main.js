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
	
	//------------------------------------------------------------------------------------------------------//
	
	//AJAX LISTING
	function loadAJAXList(){
		 
		$.ajax({
			 url:"main.ajax",
			 type:"get",
			 dataType:"json",
			 success: auctionListAjax,
			 error:
				function(){
				alert:("error");
				}
		 })
	}
	
	
	function auctionListAjax2() {
		
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
	auctionListAjax2();
	
	
	function auctionListAjax(data){
		
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
	
	function loadAJAXDetail(){
		 
		$.ajax({
			 url:"${cpath}/main/${auction_num}",
			 type:"get",
			 dataType:"json",
			 success: auctionListAjax,
			 error: 
				function(){
				alert:("error");
				}
		 })
	}
	
	
		
	function auctionDetailAjax(data){
		
		console.log(data);
		
		$.each(data, (index, auctionDetail)=>{
		
		let front = "";	
			
			front = "<div id='contents' class='row'>";
			front += "<h3 class='col-md-11'>" + auctionDetail.auction_title + "</h3>";
			front += "<p id='writer' class='col-10'>Launched at " + auctionDetail.launch_date + "</p>";
			front += "<hr/></div>";
			front += "<div id='contents' class='row'>";
			front += "<img id='conimg' src='resources/img/dummy1.jpeg'/>";
			front += "<p class='text-left'>" + auctionDetail.auction_description + "</P>";
			front += "</div>";
			front += "<div id='productamount' class='row'>";
			front += "<table class='table table-hover'>";
			front += "<tr>";
			front += " <th>Current Amount</th>";
			front += "<td>₩ " + auctionDetail.current_amount + "</td>";
			front += "</tr>";
			front += "<tr>";
			front += "<th>Bidding</th>";
			front += "<td>" + auctionDetail.bid_count + " hits</td>";
			front += "</tr></table></div>";
			
		})
		console.log(front);
		console.log("---------------");
		$("#auctionListAjax").html(front);
	}	 

});
$(document).ready();
