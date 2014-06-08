// JavaScript Document

		google.load("feeds", "1");
	 	
		function initialize() {
		 var feed ="http://phongmay.zing.vn/rss/";
		 var options = {
		linkTarget : google.feeds.LINK_TARGET_BLANK,
		pauseOnHover : false,
		horizontal : true
		}
		 // set URL de doc RSS
		 a = 0;
		 var feed = new google.feeds.Feed("http://phongmay.zing.vn/rss/");
		 feed.setNumEntries(5); // dinh bao nhieu mau tin duoc lay len
		 feed.load(function(result) {
			if (!result.error) {
			  var container = document.getElementById("rss_tin_tuc");
			  var ketqua="";
			  for (var i = 0; i < result.feed.entries.length; i++) {
				var entry = result.feed.entries[i];
				var title = entry.title;	
				
				a=26;// set so ky tu can cat title
					
						
				//alert(title.length);
				var title_cat;
				if (a < title.length-1){
						/*while(a <= title.length-1){			
						//alert(a);
						
							if ((title[a]== " ") || (a == title.length-1)){
							*/
							title_cat = title.substring(0,a);
							//alert(title + "ky tu"+ title[a]);
							title_cat = title_cat +"...";
							/*break;				
							}else{
							a++;
							}			
						}*/
				}else{
					title_cat = title;
				}
				//alert(title_cat);
				//alert(tung);
				title1 = title_cat;			
				ketqua = ketqua + '<li><a href='+ entry.link +' target="_blank" title="'+title1+'">' +title1+ '</a></li>';
			  }
			  container.innerHTML = ketqua;
			}
		  });
		}
		google.setOnLoadCallback(initialize);
	
		

