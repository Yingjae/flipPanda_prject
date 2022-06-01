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
