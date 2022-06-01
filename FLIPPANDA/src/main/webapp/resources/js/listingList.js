const windows = document.getElementById('main');
const container = document.getElementById('auctionListAjax');
const containerD = document.getElementById('auctionDetailAjax');
const bidLogBoard = document.getElementById('bidLogBoard');
const loading = document.querySelector('.loading');
	
	loadAJAXList();
	
	windows.addEventListener('scroll', () => {
		
		const { scrollHeight, clientHeight } = document.documentElement;
		var scroll = container.scrollTop;
		console.log(scroll);
		console.log( { scrollHeight, clientHeight });
		
		if(clientHeight >= scrollHeight - 5) {
			showLoading();
		}
		
	});
	
	function showLoading() {
		loading.classList.add('show');
		// load more data
		setTimeout(loadAJAXList, 500)						
	}
	 

		//AJAX LISTING
		function loadAJAXList(){
			
			$.ajax({
				 url:"/main.ajax",
				 type:"get",
				 dataType:"json",
				 async : false,
				 success: auctionListAjax,
				 error:
					function(){
					alert("error");
					}
			 	})
		}

		
		function auctionListAjax(data){
			
			console.log(data);

			$.each(data, (index, items)=>{
			var timestamp = items.launch_date;
			var date = new Date(timestamp);	
			
			const current_amount = items.current_amount.toString()
  			.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
  			const bid_count = items.current_amount.toString()
  			.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
			
			const postElement = document.createElement('div');
			postElement.classList.add('auctionList');
			
			postElement.innerHTML = `
			<div id='contents' class='row' style="margin-left:5px; margin-right:5px;">
			<h3 class='col-md-11' style='cursor:pointer; font-weight:bold;' onclick="loadAJAXDetail(${items.auction_num})">${items.auction_title}</h3>
				<p id='writer' class='col-10' style="font-size:80%; float:left;">Launched at 
				${date.getFullYear()}.${(date.getMonth()+1)}.${date.getDate()}
				</p><hr/></div>
				<div id='contents' class="d-grid gap-5" style='grid-template-columns: 3fr 2fr; padding:15px; height:280px'>
					<div class="row">
					<img id='conimg' src="https://robbreport.com/wp-content/uploads/2021/09/mags01.jpg?w=1000" style='cursor:pointer' 
					onclick="loadAJAXDetail(${items.auction_num})"/>
					</div>
					<div id='productamount' class='row' style="height:100px; margin-left:-10px">
					<table class='table table-hover'>
						<tr>
					<th>Current Amount</th>
						<td style="text-align:right;">₩ ${current_amount}</td>
						</tr>
						<tr>
						<th>Bidding</th>
						<td style="text-align:right;"> ${items.bid_count} hits</td>
						</tr>
						</table>
						<h5 style="margin-top:15px">Description</h5>
						<p class='text-left'>${items.auction_description}</P>
						</div>
				</div>
				<div class="mb-4"></div>	
			`;
			
			console.log(postElement.innerHTML);
			container.appendChild(postElement);
			loading.classList.remove('show');
			})
		}
			
		
	//-------------------------------------------------------------------------------------------------------------------------------------//
		
		
		function loadAJAXDetail(auction_num){
		
			console.log(auction_num);
		
			$.ajax({
				 url:"/main/"+auction_num+".ajax",
				 type:"get",
				 dataType:"json",
				 contentType: "application/json;",
				 async : false,
				 success: 
					function(data){
					$('#auctionPostAjax').hide();		
					$('#auctionListAjax').fadeOut(150, function(){ $(this).remove();});	
					$('.user_profile').fadeOut(0, function(){ $(this).remove();});
					$('.bidding').fadeIn(150, function(){ $(this).show();});
					console.log(data);
					auctionDetailAjax(data);
					loadAJAXBidLog(auction_num);
					
					$(containerD).on("mousewheel", function(e) {	
					 console.log(e);
					 let wheelTimer;
						  clearTimeout(wheelTimer);
						    wheelTimer = setTimeout(function() {
						    	if(e.deltaY > 0 ){
									loadAJAXDetailNext(auction_num);
								}
						      	else if(e.deltaY < 0){
									loadAJAXDetailPrev(auction_num);
						      	}else{
							}  	
						    }, 10);
					})
					},
				 error: 
					function(){
					alert("error");
					}
			 })
		}	 
			
		  function loadAJAXDetailNext(auction_num){
			
			var auctionNumNext = (auction_num + 1);
			console.log(auction_num);
			console.log(auctionNumNext);
			
			$(containerD).animate({opacity: 0,}, 50);
			$(bidLogBoard).animate({opacity: 0,}, 0);
			$('.auctionDetalPost').fadeOut(0, function(){ $(this).remove();});
			$('.bidcol').fadeOut(0, function(){ $(this).remove();});
			
			$.ajax({
				 url:"/main/"+auctionNumNext+".ajax",
				 type:"get",
				 dataType:"json",
				 contentType: "application/json;",
				 async : false,
				 success: 
				 function(data){
					console.log("data ------"+ data);
					if(data.length == 0){
						alert("error");
					}else{	
						auctionDetailAjax(data);
						loadAJAXBidLog(auctionNumNext);
						$(containerD).animate({opacity: 100,}, 150);
						$(bidLogBoard).animate({opacity: 100,}, 150);
					}
					},
				 error: 
					function(){
					alert:("error");
					}
			 })
		}	 
				
		function loadAJAXDetailPrev(auction_num){
			
			var auctionNumPrev = (auction_num - 1);
			console.log(auction_num);
			console.log(auctionNumPrev);
			
			$(containerD).animate({opacity: 0,}, 50);
			$(bidLogBoard).animate({opacity: 0,}, 0);
			$('.auctionDetalPost').fadeOut(0, function(){ $(this).remove();});
			$('.bidcol').fadeOut(0, function(){ $(this).remove();});
			
			$.ajax({
				 url:"/main/"+auctionNumPrev+".ajax",
				 type:"get",
				 dataType:"json",
				 contentType: "application/json;",
				 async : false,
				 success: 
					function(data){	
						$(containerD).animate({opacity: 100,}, 150);
						$(bidLogBoard).animate({opacity: 100,}, 150);
						auctionDetailAjax(data);
						loadAJAXBidLog(auctionNumPrev);
					},
				 error: 
					function(){
					alert:("error");
					}
			 })
		}	 
		
		
		
		
		function loadAJAXBidLog(auction_num){
			
			$.ajax({
				 url:"/main/log/"+auction_num+".ajax",
				 type:"get",
				 dataType:"json",
				 contentType: "application/json;",
				 async : false,
				 success: 
					function(data){
					console.log(data);
					recentlyBid(data);
					},
				 error: 
					function(){
					alert:("error");
					}
			 })
		}	 
		

		function auctionDetailAjax(data){
			
			var timestamp = data.launch_date;
			var date = new Date(timestamp);
			
			const start_amount = data.start_amount.toString()
  			.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
			const current_amount = data.current_amount.toString()
  			.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
			
			const postElement = document.createElement('div');
			postElement.classList.add('auctionDetalPost');
		
			postElement.innerHTML = `
			<div style="cursor:pointer; position:absolute; top:0; left:0; width:100%; height:30px; background-color:green; opacity:0.02" onclick="loadAJAXDetailNext(${data.auction_num})">up</div>
			<div id='contents' class='row' style="margin-left:5px; margin-right:5px; margin-top:20px">
			<h3 class='col-md-11' style="font-weight:bold;"> ${data.auction_title}</h3>
				<p id='writer' class='col-10' style="font-size:80%; float:left;">Launched at 
					${date.getFullYear()}.${(date.getMonth()+1)}.${date.getDate()}
					</p>
					<hr/></div>
				<div id='contents' class='row'>
					<img id='conimg' src="https://robbreport.com/wp-content/uploads/2021/09/mags01.jpg?w=950" style="width:950px"/>
					</div>
					<div id='contents' class="d-grid gap-5" style='grid-template-columns: 3fr 2fr; padding:15px; height:100px'>
					<div class="mb-4">
					<div style="margin-top:20px">
					<h5 style="margin-top:15px; font-size: small; font-weight:700; color: grey;">Product Info</h5>
					<p class='text-left'>${data.product_name}</P>
					</div>
					<h5 style="margin-top:20px; font-size: small; font-weight:700; color: grey;">Description</h5>
					<p class='text-left'>${data.auction_description}</P>
					
					
					</div>
				<div id='productamount' class='row'>
					<table class='table table-hover' style="max-width: 120%; height:150px; vertical-align:bottom;">
						<tr>
					<th>Strat Amount</th>
						<td style="text-align:right;" >₩ ${start_amount}</td>
						</tr>
						<tr>
					<th>Current Amount</th>
						<td style="text-align:right;">₩ ${current_amount}</td>
						</tr>
						<tr>
						<th>Bidding</th>
						<td style="text-align:right;"> ${data.bid_count} hits</td>
						</tr></table>
						</div>
						<div style="cursor:pointer; position:absolute; bottom:0; left:0; width:100%; height:30px; background-color:green; opacity:0.02" onclick="loadAJAXDetailPrev(${data.auction_num})">⬇</div>
						</div>
							
			`;
			console.log(postElement.innerHTML);
			containerD.appendChild(postElement);
		}
		
		
		function recentlyBid(data){
			
			console.log(data);

			let front = "";	
			
			// 입찰자가 아직 없을때	
			if(data.length == 0){
				 
				const postElement = document.createElement('div');
				postElement.classList.add('bidcol');
				postElement.innerHTML = `
					<div class='mb-4'></div>
					<Strong class='tbd'>No Bids yet :(</Strong>
					<br/>
					<div class='mb-4'></div>`;
					
				console.log(postElement.innerHTML);
				bidLogBoard.appendChild(postElement);
			// 입찰 내역 들어올때		
			}else{
				$.each(data, (index, obj)=>{
					var timestamp = obj.auction_log_date;
					var date = new Date(timestamp);
					
					const auction_bid_log = obj.auction_bid_log.toString()
  					.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
					
				const postElement = document.createElement('tr');
				postElement.style.position = "relative";
				postElement.classList.add('bidcol');
				postElement.innerHTML = `
					<td class='col-1' style="font-size:xx-small; margin-top:-10px">${obj.auction_log_num}</td>
					<td class='col-2' style="font-size:xx-small; margin-top:-10px">Test_User</td>
					<td class="col-3" style="font-size:xx-small; margin-top:-10px">${auction_bid_log}</td>
					<td class="col-2" style="font-size:xx-small; margin-top:-10px">${date.getDate()}th ${(date.getMonth()+1)}.${date.getFullYear()}</td>`;	
				console.log(postElement.innerHTML);
				bidLogBoard.appendChild(postElement);
				})
			}
		}
		
