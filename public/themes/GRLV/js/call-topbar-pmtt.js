var productCode="PMTT";
var arrayBanner = ['149'];
var arrayBigBanner = ['258'];	
var CodeProduct="PMTT";
var CookieProduct="PMTT_Cookie";
var CookieBottomProduct="PMTT_CookieBottom";

var objLinkTracking ={
		
		oldPlayNow: "http://idgunny.zing.vn",
		replacePlayNow: "" //link MAS
			
	}
	
var taiKhoan = ['https://id.zing.vn','https://id.zing.vn/','https://id.zing.vn/index.html','id.zing.vn','http://id.zing.vn','http://id.zing.vn/','http://id.zing.vn/index.html'];
		

	var objLink={
		
	}
var specialLink ={		
		// khai bien ngoai cho flash,  call allFlashLink['fPlayNow']
		/*
		fPlayNow: {
			linkFlash: 'http://id.thankhuc.com.vn/index.php',
			linkReplace: 'http://mas.thankhu.com.vn/m.php?m=80.71.89&jurl=http://id.thankhuc.com.vn/index.php?sid=none'
		}
		*/
	}
jQuery(document).ready(function(){		
	initTopbarZingGame("topbar","PMTT",objLink,arrayBanner,arrayBigBanner); //apply top-bar
	
	add_idzone(149, "addzone_149");	
	add_idzone(258, "addzone_258");
	replaceTracking();
	clickTracking();
	
});


