
$(document).ready(function() {	
		
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
		
	});
		
		
		
	$(document).ready();
