<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri ="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/10.0.0/css/bootstrap-slider.min.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&amp;display=swap" rel="stylesheet">
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Chakra+Petch:wght@500&family=Hahmlet:wght@200&family=Kanit:wght@300&family=Play:wght@400;700&family=Prompt:wght@300;400&display=swap" rel="stylesheet">
<link href="${cpath}/resources/css/style_combine.css" rel="stylesheet"/> 	

<title>FLIPPANDA_main</title>

<!-- JS -->
<script src="${cpath}/resources/js/main.js"></script>
<script src="${cpath}/resources/jsjquery-3.4.1.min.js"></script>
<script src="${cpath}/resources/jquery.mousewheel.min.js"></script>

<!-- AM CHARTS(TBD) -->
<script src="https://cdn.amcharts.com/lib/5/index.js"></script>
<script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
<script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
</head>
<body>
<div id="wrapper">
	<!-- NOT LOGIN -->
	<header class="py-4 mb-2" style="border-bottom: 1px;">
	    <div class="container d-flex flex-wrap">
	      <a href="/main" class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none">
	        <!-- FLIPPANDA LOGO -->
         	<img src="resources/img/flippanda_main.png" width="150px"/>
	      </a>
	      <form class="col-12 col-lg-auto mb-3 mb-lg-0" data-form-type="" style="width:430px;">
	        <input type="search" class="form-control" placeholder="Find Auction" aria-label="Search" data-form-type="">
	      </form>
	    </div>
	  </header>
	  
 <!-- ------------------------------------------------------------------------------------------------------------------ -->
<section class="front-start">
<div class="container-fluid pb-5">
<div class="d-grid gap-5" style="grid-template-columns: 3fr 2fr; width: 95%; margin-left: 50px">
<!-- ------------------------------------------------------------------------------------------------------------------ -->
	<!-- AUCTION LISTVIEW -->
	<div id="main" class="bg-light border rounded-3">
	<article id="auctionDetail">
		<!-- frontView AJAX -->
		<div id="auctionListAjax"></div>
		
		<div id="auctionDetailAjax" style="display: none;">
		<div class="row" style="margin:3%">
			<h3 class="col-md-11">${auctionList.auction_title}</h3>
			<p id="writer" class="col-10">Launched at '${auctionList.launch_date}'</p>
			<hr/>
			</div>
			<div id="contents" class="row" style="margin:3%">
			<img src="resources/img/dummy1.jpeg" style="align-content: center; width:99%"/>
			<p class="text-left">${auctionList.auction_description}</p>
			</div>
			<div id="productamount" class="row" style="margin-left:3%; margin-right:3%;">
			
			<!-- AJAX (below)-->
			<table class="table table-hover" style="font-size: 2vmin;">
			<tr>
			    <th>Current_Amount</th>
			    <td style="text-align:right;">₩ ${auctionList.current_amount}</td>
			    <!--<td style="text-align:right;">₩ <fmt:formatNumber value="${boarddetail.board_amount}" pattern="#,###"/></td>-->
			</tr>
			<tr>
			    <th>Bidding</th>
			    <td style="text-align:right; ">${auctionList.bid_count} hits</td>
			    <!--<td style="text-align:right;">${boarddetail.board_cartegory}</td>-->
			</tr>
			</table>
		</div>
		</div>
		<div id="auctionPostAjax" style="display: none;"></div>
		<!-- chartVeiw AJAX -->
		<div id="chartdiv"></div>
	</article>
	</div>
<!-- ------------------------------------------------------------------------------------------------------------------ -->
<!-- USER INFO & SIDE FUNTION -->
<div id="sidePanel" class="bg-light border rounded-3" style="margin-right:20%; width:80%; padding:10%; height:850px;">
	<!-- CHECK FRONTEND (DELETE AFTER PJT DONE)-->
	 <ul class="nav nav-tabs" style="font-size: 70%;">
	  <li class="nav-item"><a class="nav-link active" href="#login" data-toggle="tab" data-load="true">login</a></li>
	  <li class="nav-item"><a class="nav-link" href="#user" data-toggle="tab" data-load="true">user</a></li>
	  <li class="nav-item"><a class="nav-link" href="#post1" data-toggle="tab" data-load="true">post</a></li>
	  <li class="nav-item"><a class="nav-link" href="#bid" data-toggle="tab" data-load="true">bid</a></li>
	  <li class="nav-item"><a class="nav-link" href="#fav" data-toggle="tab" data-load="true">fav</a></li>
	  <li class="nav-item"><a class="nav-link" href="#admin" data-toggle="tab" data-load="true">admin</a></li>
	 </ul>
 <div class="tab-content">
   <!-- ------------------------------------------------------------------------------------------------------------------ -->
 	<sec:authorize access="isAnonymous()">
 	<div class="tab-pane fade show active" id="login" style="padding-top:20%;">
 	<div class="login_signup">
	<form action="/login" method="post">
	    <img class="mb-4" src="resources/img/sq_minimal.png" width="50">
	
	      <input type="text" class="form-control" id="loginFormId" placeholder="Your ID" data-form-type="userId" name="username">
	      <input type="password" class="form-control" id="loginFormPw" placeholder="Your Password" data-form-type="userPw" name="password">
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
	      <div class="mb-4"></div>
	    <button id="login_submit" class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" type="submit" 
	    data-dashlane-label="true">Sign in</button>
	  </form>
	  </div>
	</div>
	</sec:authorize>
   <!-- ------------------------------------------------------------------------------------------------------------------ -->
	<sec:authorize access="isAuthenticated()">
	<div class="tab-pane fade" id="user" style="padding-top:15%;">
    <div class="user_profile">
    	<img class="mb-4 rounded-circle" src="resources/img/profile.png" width="100" style="border:5px solid #34B475">
    	<Strong class="tbd"> TBD: User_infomation / Post Btn </Strong>
    	<hr/>
    	<form action="/customLogout" method="post">
			<input type="submit" value="로그아웃">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
		</form>
    </div>  
    	<button id="postBtn" class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" type="button" 
	    data-dashlane-label="true">New Auction</button>
    	<hr/>
    </div>  
  	</sec:authorize>
   <!-- ------------------------------------------------------------------------------------------------------------------ -->
  	  <div class="tab-pane fade" id="post1" style="padding-top:20%;">
  	<div class="posting">
  		<form data-form-type="post">
		  <!-- CATEGRY ? -->
	      <select name="auction_category" class="form-select" style="display: none; border:none; color: #959595" required>			  	
				<option value="" class="dropdown-item">Select Category</option>
				<option value="Electronics" class="dropdown-item">Electronics</option>
				<option value="Collectable" class="dropdown-item">Treasure</option>
				<option value="Fashion" class="dropdown-item">Fashion</option>
				<option value="Hobby" class="dropdown-item">Hobby</option>
				<option value="Shoes" class="dropdown-item">Shoes</option>
		  </select>
		  <hr/>
		  <!-- PRICE -->
	      <input id="priceinsert" type="text" onkeyup="inputNumberFormat(this)" class="py-2 mb-2" name="start_amount" placeholder="  Start Price"
      		oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" 
      		style="width: 100%; border:none; color: #959595" required/>
      	  <input id="priceinsert" type="text" onkeyup="inputNumberFormat(this)" class="py-2 mb-2" name="close_amount" placeholder="  Match Price"
      		oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" 
      		style="width: 100%; border:none; color: #959595" required/>
      	  <input id="priceinsert" type="text" onkeyup="inputNumberFormat(this)" class="py-2 mb-2" name="start_amount" placeholder="  Minimum Bid Amount"
      		oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" 
      		style="width: 100%; border:none; color: #959595" required/>
		  <!-- RTB OPTION -->
		  <Strong class="tbd"> TBD: Ready to Buy Option</Strong>
	      <div class="mb-4"></div>
         <button id="post_btn" class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" type="submit">Post</button>
	</form>
    </div>  
  	</div>
   <!-- ------------------------------------------------------------------------------------------------------------------ -->
  	<div class="tab-pane fade" id="bid" style="padding-top:15%;">
  	<div class="bidding">
  	<Strong>Bidding This</Strong>
  	<div class="mb-4"></div>
  	 <form data-form-type="bid">
    	 <input id="priceinsert" type="text" onkeyup="inputNumberFormat(this)" class="py-2 mb-2" name="start_amount" placeholder="  Place Your Bid"
      		oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" 
      		style="width: 90%; border:none; color: #959595; float:left;" required/>
      		<img src="resources/img/fliped.png" width="20px" style="margin-top: 8px"/>
      		<input type="hidden"/>
      		<button id="bid_btn" class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" type="submit">Bid Now</button>
     </form>	
     		<button id="buy_btn" class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" type="submit">Buy Now</button>
     	<div id="recentBidHistory" class="py-2 mb-4"></div>
     		<table class="table table-hover" style="font-size: xx-small; text-align: left;">
			<tr>
			<th class="col-2">Flip</th>
			<th class="col-3">Flipper</th>
			<th>Amount</th>
			<th>Date</th>
			</tr>
			</table>
			<div style="width: 100%; height: 300px; overflow: auto;">
      		<button id="my Balance" class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" type="submit">Find Similar Deal</button>
    	</div>  
  	</div>
   <!-- ------------------------------------------------------------------------------------------------------------------ -->
  	<div class="tab-pane fade" id="fav" style="padding-top:20%;">
  	<div class="favorite">
  	<Strong>My Save Auction</Strong>
  	<div class="mb-4"></div>
  	<hr/>
    <button id="post_btn" class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" type="submit">Active List</button>
    <div class="mb-2"></div>
    <button id="post_btn" class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" type="submit">Delete All</button>
    <div class="mb-4"></div>
    </div>  
  	</div>
   <!-- ------------------------------------------------------------------------------------------------------------------ -->
  	<div class="tab-pane fade" id="admin" style="padding-top:20%;">
  	<div class="admin_menu">
  	<jsp:include page="home.jsp"/>
    </div>  
  	</div>
   <!-- ------------------------------------------------------------------------------------------------------------------ -->
  </div> 
  </div>
<!-- ------------------------------------------------------------------------------------------------------------------ -->
</div>
</div>
</div>
</section>
</div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>