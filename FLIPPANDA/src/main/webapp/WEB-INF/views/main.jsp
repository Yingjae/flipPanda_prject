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
<link href="./resources/css/style_combine.css" rel="stylesheet"/> 	
<script src="${cpath}/resources/js/main.js"></script>
<title>FLIPPANDA_main</title>
<!-- AM CHARTS(TBD) -->
<script src="https://cdn.amcharts.com/lib/5/index.js"></script>
<script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
<script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
</head>
<body>
<div id="wrapper">
	<header class="py-4 mb-2" style="border-bottom: 1px;">
	    <div class="container d-flex flex-wrap">
	      <a href="/main" class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none">
	        <!-- FLIPPANDA LOGO -->
         	<img src="resources/img/flippanda_main.png" width="150px"/>
	      </a>
	      <form class="col-12 col-lg-auto mb-3 mb-lg-0" data-form-type="" style="width:430px;">
	        <input type="search" class="form-control" placeholder="Find Auction" aria-label="Search">
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
	
		<!-- infinity scroll loading effect -->
	  
	    <!-- ------------------------------------------------------------------------------------------------------------------ -->
		<!-- frontView AJAX -->
		<div id="auctionListAjax" style="padding:15px;">
		</div>
		
		
		<div id="auctionDetailAjax" style="padding:15px;"></div>
		<!-- ------------------------------------------------------------------------------------------------------------------ -->
		<div id="pendingList" style="display: none;"></div>
		<div id="auctionUpdateForm" style="display: none;"></div>
		<!-- ONCLICK => ON/OFF -->
		<div id="auctionPostAjax" style="padding:20px;">
			<!-- LEGACY FORM -->
			<h3 class="col-md-11"> Post New Auction</h3>
			<form action="${cpath}/postAuctionForm" method="post" enctype="multipart/form-data">
			<input type="text" name="auction_title" class="form-control mt-4 mb-2" style="border:none; color: #959595"
				placeholder="Title" required
			>
			<div class="form-group">
				<textarea class="form-control" style="resize: none; border:none; color: #959595" rows="15" name="auction_content"
					placeholder="Add Description This." required
				></textarea>
				<select name="auction_category" class="form-select" style="border:none; color: #959595" required>			  	
				<option value="" class="dropdown-item">Upload Product Image</option>
				<option value="Electronics" class="dropdown-item">Electronics</option>
				<option value="Collectable" class="dropdown-item">Treasure</option>
				<option value="Fashion" class="dropdown-item">Fashion</option>
				<option value="Hobby" class="dropdown-item">Hobby</option>
				<option value="Shoes" class="dropdown-item">Shoes</option>
		  </select>
			</div>

		</form>
		</div>
		<!-- infinity scroll loading effect -->
	    <div class="loading">
	        <div class="ball"></div>
	        <div class="ball"></div>
	        <div class="ball"></div>
	    </div>
	    
	</article>
	</div>
<!-- ------------------------------------------------------------------------------------------------------------------ -->
<!-- USER INFO & SIDE FUNTION -->
<div id="sidePanel" class="bg-light border rounded-3" style="margin-right:20%; width:80%; padding:10%; height:800px;">

 <div class="tab-content">
   <!-- ------------------------------------------------------------------------------------------------------------------ -->
<sec:authorize access="isAnonymous()">
 	<div class="tab-pane fade show active" id="login" style="padding-top:20%;">
 	<div class="login_signup">
	<form action="/login" method="post">
	    <img class="mb-4" src="resources/img/sq_minimal.png" width="50">

	      <input type="text" class="form-control" id="loginFormId" placeholder="Your ID" data-form-type="userId" name="username">
	      <input type="password" class="form-control" id="loginFormPw" placeholder="Your Password" data-form-type="userPw" name="password">

   <!-- ------------------------------------------------------------------------------------------------------------------ -->
		<input class="form-check-input" type="checkbox" name="remember-me" id="flexCheckDefault">
		  <label class="form-check-label" for="flexCheckDefault">
		  	remember me
		  </label>    
	    <div class="mb-4"></div>
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
	    <button class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" type="submit" 
	    data-dashlane-label="true" data-form-type="login">Sign in</button>
	    <button class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" data-bs-toggle="modal" data-bs-target="#staticBackdrop"><a href ="/secu/join" style="color:#fff; text-decoration:none">Join us</a></button>
	    <p class="mt-5 mb-3 text-muted"></p>
	  </form>
	  </div>
	</div>
	</sec:authorize>
<!-- ---------------------------------------------------------------------------------------------------------->
<sec:authorize access="isAuthenticated()">
    <div class="tab-pane fade show active" id="user" style="padding-top:15%;">
    <div class="user_profile">
        <img class="mb-4 rounded-circle" src="resources/img/profile.png" width="100" style="border:5px solid #34B475"><br/>
        <Strong class="tbd"><a href="secu/userUpdate"> User Information</a></Strong>
        <hr/>
        <form action="/customLogout" method="post">
            <button class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" type="submit" 
                data-dashlane-label="true" data-form-type="login">LogOut</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
        </form>
        <hr/>
        <button id="postBtn" class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" type="button" 
        data-dashlane-label="true">New Auction</button>
    </div>
    </div>
    <a href="/freeBoard/freeBoardList">Free Board</a><br/>
    <a href="/allCollectionList">Collection</a><br/>
    <a href="/qna/qnaboardList">QnA</a>
    </sec:authorize>

    
    <div class="posting" style="display:none; margin-top:-28px">
  		<form data-form-type="post">
  		<input type="text" name="auction_title" class="form-control mt-4 mb-2" style="border:none; color: #959595"
				placeholder="Product Name" required>
		  <!-- CATEGRY ? -->
	      <select name="auction_category" class="form-select" style="border:none; color: #959595" required>			  	
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
      	  <input id="cloeseinsert" type="text" onkeyup="inputNumberFormat(this)" class="py-2 mb-2" name="close_amount" placeholder="  Match Price"
      		oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" 
      		style="width: 100%; border:none; color: #959595" required/>
      	  <input id="bidMininsert" type="text" onkeyup="inputNumberFormat(this)" class="py-2 mb-2" name="bid_amount" placeholder="  Minimum Bid Amount"
      		oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" 
      		style="width: 100%; border:none; color: #959595" required/>
      		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
		  <!-- RTB OPTION -->
	      <div class="mb-4"></div>
         <button id="post_btn" class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" type="submit">Post</button>
	</form>
    </div>  
    <div class="bidding" style="display:none;">
  	<Strong>Bidding This</Strong>
  	<div class="mb-4"></div>
  	<sec:authorize access="isAnonymous()">
  	 <form data-form-type="bid">
    	 <input id="priceinsert" type="text" onkeyup="inputNumberFormat(this)" class="py-2 mb-2" name="start_amount" placeholder="  Sign In First."
      		oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" style="width: 90%; border:none; color: #959595; float:left;" disabled/>
      		<img src="resources/img/fliped.png" width="20px" style="margin-top: 8px"/>
      		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
      		<button id="bid_btn" class="w-50 btn btn-lg btn-primary fw-bold border-white bg-black" style="float:left;" type="submit" disabled="disabled">Bid Now</button>
     		</form>	

     		<button id="buy_btn" class="w-50 btn btn-lg btn-primary fw-bold border-white" style="float:left; align-content:center; background-color: #3CB377;" disabled="disabled">Buy Now</button>
     		</sec:authorize>
     		<sec:authorize access="isAuthenticated()">
     		<form data-form-type="bid">
    	 <input id="priceinsert" type="text" onkeyup="inputNumberFormat(this)" class="py-2 mb-2" name="start_amount" placeholder="  Place Your Bid"
      		oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" style="width: 90%; border:none; color: #959595; float:left;" required/>
      		<img src="resources/img/fliped.png" width="20px" style="margin-top: 8px"/>
      		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
      		<button id="bid_btn" class="w-50 btn btn-lg btn-primary fw-bold border-white bg-black" style="float:left;" type="submit">Bid Now</button>
     		</form>	

     		<button id="buy_btn" class="w-50 btn btn-lg btn-primary fw-bold border-white" style="float:left; align-content:center; background-color: #3CB377;">Buy Now</button>
     		</sec:authorize>

     		<div class="mb-4"><br/><br/></div>

     	<div id="recentBidHistory" class="py-2 mb-4"></div>
     		<table class="table table-hover" style="font-size: xx-small; text-align: center;">
			<tr>
			<th class="col-1">Flip</th>
			<th class="col-2">Flipper</th>
			<th class="col-3">Amount</th>
			<th class="col-2">Date</th>
			</tr>
			</table>
			<div id="recentBidHistory">
			<table id="bidLogBoard" class='table table-hover'></table>
			</div>
			<div style="width: 100%; height: 300px; overflow: auto;">
      		<button id="my Balance" class="w-100 btn btn-lg btn-primary fw-bold border-white bg-black" type="button" onclick="location.href='/main'">Find Similar Deal</button>
    	</div>  

   <!-- ------------------------------------------------------------------------------------------------------------------ -->
  	  <div class="tab-pane fade" id="post1" style="padding-top:20%;">

  	</div>
   <!-- ------------------------------------------------------------------------------------------------------------------ -->
  	<div class="tab-pane fade" id="bid" style="padding-top:15%;">

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
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="${cpath}/resources/js/jquery.mousewheel.min.js"></script>
    <script src="${cpath}/resources/js/listingList.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="${cpath}/resources/js/bid.js"></script>
</body>
</html>