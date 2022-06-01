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
	
	function showLoadingDetail() {
		loading.classList.add('show');
		// load more data
		setTimeout(loadAJAXDetail, 500)
		
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
					alert:("error");
					}
			 	})
		}
		
		function auctionListAjax(data){
			console.log(data);
			
			$.each(data, (index, items)=>{
			var timestamp = items.launch_date;
			var date = new Date(timestamp);	
				
			const postElement = document.createElement('div');
			postElement.classList.add('auctionList');
			postElement.innerHTML = `
			<div id='contents' class='row' style="margin-left:5px; margin-right:5px;">
			<h3 class='col-md-11' style='cursor:pointer' onclick="loadAJAXDetail(${items.auction_num}),">${items.auction_title}</h3>
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
						<td style="text-align:right;">₩ ${items.current_amount}</td>
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
	
	

		function showLoadingTop() {
			loading.classList.add('show');
			// load more data
			setTimeout(loadAJAXDetail, 1000)
		}
		function showLoadingBottom() {
			loading.classList.add('show');
			// load more data
			setTimeout(loadAJAXDetail, 1000);
			setTimeout(mousewheel, 1000)
		}
		
		
		function loadAJAXDetail(auction_num){
			
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
					},
				 error: 
					function(){
					alert:("error");
					}
			 })
		}	 
		
		function mousewheel(auction_num){
			
			var auctionNum = JSON.parse(auction_num);
			var wheel = windows.height();
			
			windows.addEventListener('mousewheel', function(delta){
				
				if(delta > 0) {
					showLoadingDetail();
					$('#auctionDetailAjax').fadeOut(150, function(){ $(this).remove();});	
					loadAJAXDetail(auctionNum-1);
					$("#auctionDetail").stop().animate({scrollTop:divPosition - wheel});
					return false;
				}else if(delta < 0) {
					showLoadingDetail();
					$('#auctionDetailAjax').fadeOut(150, function(){ $(this).remove();});	
					loadAJAXDetail(auctionNum+1);
					$("#auctionDetail").stop().animate({scrollTop:divPosition - wheel});
				}
				});
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
				
			const postElement = document.createElement('div');
			postElement.classList.add('auctionDetailAjax');
			
			postElement.innerHTML = `
			<div id='contents' class='row'>
			<h3 class='col-md-11'> ${data.auction_title}</h3>
				<p id='writer' class='col-10' style="font-size:80%; float:left;">Launched at 
					${date.getFullYear()}.${(date.getMonth()+1)}.${date.getDate()}
					</p>
					<hr/></div>
				<div id='contents' class='row'>
					<img id='conimg' src="https://robbreport.com/wp-content/uploads/2021/09/mags01.jpg?w=1000"/>
					<p class='text-left'>${data.auction_description}</P>
				</div>
				<div id='productamount' class='row'>
					<table class='table table-hover' style="max-width: 50%;">
						<tr>
					<th>Current Amount</th>
						<td style="text-align:right;">₩ ${data.current_amount}</td>
						</tr>
						<tr>
						<th>Bidding</th>
						<td style="text-align:right;"> ${data.bid_count} hits</td>
						</tr></table></div>
			`;
			console.log(postElement.innerHTML);
			containerD.appendChild(postElement);
			
			loading.classList.remove('show');
		}
		
		
		function recentlyBid(data){
			
			console.log(data);

			let front = "";	
			
			// 입찰자가 아직 없을때	
			if(data.length == 0){
				const postElement = document.createElement('div');
				postElement.classList.add('noBid');
				
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
				const postElement = document.createElement('tr');
				postElement.classList.add('bidcol');
				
				postElement.innerHTML = `
					<td class='col-2'>${obj.auction_log_num}</td>
					<td class='col-3'>${obj.user_num}</td>
					<td>${obj.auction_bid_log}</td>
					<td>${obj.auction_log_date}</td>`;	
				console.log(postElement.innerHTML);
				bidLogBoard.appendChild(postElement);
				})
			}
		}
		
