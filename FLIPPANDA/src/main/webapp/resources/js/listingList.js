const container = document.getElementById('auctionListAjax');
const loading = document.querySelector('.loading');

	loadAJAXList();
	loadAJAXList();
	loadAJAXList();
	loadAJAXList();
	loadAJAXList();

	window.addEventListener('scroll', () => {
		const { scrollTop, scrollHeight, clientHeight } = $('#auctionDetail').documentElement;
		
		console.log( { scrollTop, scrollHeight, clientHeight });
		
		if(clientHeight + scrollTop >= scrollHeight - 5) {
			showLoading();
		}
	});

	function showLoading() {
		loading.classList.add('show');
		// load more data
		setTimeout(getPost, 1000)
	}

		//AJAX LISTING
		function loadAJAXList(){
			 
			$.ajax({
				 url:"${cpath}/main.ajax",
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
			const postElement = document.createElement('div');
			postElement.classList.add('auctionListAjax');
			postElement.innerHTML = `
			<div id='contents' class='row'>
			<h3 class='col-md-11' style='cursor:pointer'> ${data.auction_title}</h3>
				<p id='writer' class='col-10'>Launched at ${data.launch_date}</p>
					<hr/></div>
				<div id='contents' class='row'>
					<img id='conimg' src=‘img/dummy1.jpeg'/>
					<p class='text-left'>${data.auction_description}</P>
				</div>
				<div id='productamount' class='row'>
					<table class='table table-hover'>
						<tr>
					<th>Current Amount</th>
						<td>₩ ${data.current_amount}</td>
						</tr>
						<tr>
						<th>Bidding</th>
						<td> ${data.bid_count} hits</td>
						</tr></table></div>
			`;
			console.log(postElement.innerHTML);
			container.appendChild(postElement);
			
			loading.classList.remove('show');
		}
			
		
	//-------------------------------------------------------------------------------------------------------------------------------------//
		
		//AJAX POST DETAIL
		function loadAJAXDetail(){
			 
			var data = JSON.parse(mainData);

			$.ajax({
				 url:"",
				 type:"get",
				 dataType:"json",
				 async : false,
				 success: 
					function(){
					auctionDetailAjax(data);
					recentlyBid(data);
					},
				 error: 
					function(){
					alert:("error");
					}
			 })
		}
			
		function auctionDetailAjax(data){
			console.log(data);
			const postElement = document.createElement('div');
			postElement.classList.add('auctionDetailAjax');
			postElement.innerHTML = `
			<div id='contents' class='row'>
			<h3 class='col-md-11' style='cursor:pointer'> ${data.auction_title}</h3>
				<p id='writer' class='col-10'>Launched at ${data.launch_date}</p>
					<hr/></div>
				<div id='contents' class='row'>
					<img id='conimg' src=‘img/dummy1.jpeg'/>
					<p class='text-left'>${data.auction_description}</P>
				</div>
				<div id='productamount' class='row'>
					<table class='table table-hover'>
						<tr>
					<th>Current Amount</th>
						<td>₩ ${data.current_amount}</td>
						</tr>
						<tr>
						<th>Bidding</th>
						<td> ${data.bid_count} hits</td>
						</tr></table></div>
			`;
			console.log(postElement.innerHTML);
			container.appendChild(postElement);
			
			loading.classList.remove('show');
		}
			
		
		function recentlyBid(data){
			
			console.log(data);

			let front = "";	
			
			// 입찰자가 아직 없을때	
			if(data == null){
				front += "<div class='mb-4'></div>";
				front += "<br/>";
				front += "<Strong class='tbd'>No Bids yet :(</Strong>"
				front += "<br/>";
				front += "<div class='mb-4'></div>";
			
			// 입찰 내역 들어올때		
			}else{
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
			}	
			console.log(front);
			console.log("---------------");
			$("#recentBidHistory").html(front);
		}
			 	 
		


	