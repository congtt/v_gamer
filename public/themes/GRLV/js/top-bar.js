

var topbarHTML = "";
var allFlashLink = {};
/* var specialLink ={		
		
	} */



function initTopbarZingGame(topbarID,producCode, objLink, arrayBanner,arrayBigBanner) {
	
	/*
	for(var i=0; i< arrayLink.length;i++){
		alert(arrayLink[i]);
	}
	*/
	topbarHTML +='<div id="boxTop">		<div id="box">	<div class="BoxLeft" id="Logo"> <a href="#" target="_blank" title="PlatForm" onclick="_gaq.push([\'secondTracker._trackEvent\',\'Top Bar\' , \''+ producCode +'\' , \'Logo PlatForm\']);" >Logo PlatForm </a>	</div>			<div class="TBoxBanner">	'
	for(var i=0; i< arrayBanner.length;i++){
		topbarHTML +='<div class="SBanner" id="addzone_'+arrayBanner[i]+'">  </div>';
	}
	topbarHTML +='</div><div class="StyleLink" id="arrayLink">';
 	var i=0
	for (var iLink in objLink) {
        if(i!=0) {
			topbarHTML +='  | ';
		}
		//result += arrayLink[iLink].name + "\n";
		topbarHTML +='   <a title="'+ objLink[iLink].name +'"  onclick="_gaq.push([\'secondTracker._trackEvent\',\'Top Bar\' , \''+ producCode +'\' , \''+ objLink[iLink].nameTrack +'\']);" target="_blank" href="'+objLink[iLink].link+'" >'+ objLink[iLink].name +'</a>';
		i++;
		
    }
	
	
	topbarHTML +='</div>	</div>	</div>';    
	topbarHTML +='<div class="BigBanner" id="gameBanner">';
	for(var i=0; i< arrayBigBanner.length;i++){	
		topbarHTML +='<div class="BBanner" id="addzone_'+arrayBigBanner[i]+'">  </div>';
	}	
	topbarHTML +='</div>';
	
	
	jQuery("#"+topbarID).append(topbarHTML);	
	
	
	setTimeout(function () {
		
		/* Doan traking banner */		
		
		jQuery(".SBanner").each(function (index) {
			var item = jQuery(this);
			var flag= 0;	
		
			item.bind("click", function () {
				var eventName=jQuery(this).find("img").attr("alt");
				var idZone=jQuery(this).attr("id");
				if( eventName==""){
					eventName=idZone;
				}
				_gaq.push(['secondTracker._trackEvent','Top Bar' , producCode, eventName]);
			})
			item.mouseover(function(){
					jQuery(".BBanner").eq(index).show();
					jQuery(".BBanner").eq(index).animate({ height: '150' },500);				
				
			}).mouseout(function(){				
				jQuery(".BBanner").eq(index).animate({ height: '40' },0);
				jQuery(".BBanner").eq(index).hide();
			});
			
			
		})
		
		jQuery(".BBanner").each(function (index) {
			var item = jQuery(this);	
		
			item.bind("click", function () {
				var eventName=jQuery(this).find("img").attr("alt");
				var idZone=jQuery(this).attr("id");
				if( eventName==""){
					eventName=idZone;
				}
				
				_gaq.push(['secondTracker._trackEvent','Top Bar' , producCode, eventName]);
			})
			item.bind("mouseover", function () {
				jQuery(".BBanner").eq(index).show();
				
			})
			item.bind("mouseout", function () {
				jQuery(".BBanner").eq(index).hide();
				
			})
		})

		
	
	}, 1);
   
}



function callPopupDetect(productCode){	
		
		var width=848;		
		var height=540;
		var url="http://img.zing.vn/eventgame/intro/general/detect-older-version/index.html?ProductCode="+productCode;
		var detect=0;
		if ($.browser.msie  && parseInt($.browser.version, 10) < 8) {
			detect=1;
		}		
		if ($.browser.mozilla  && parseInt($.browser.version, 10) < 10) {
			detect=1;
		}
		if (detect==1) {
			createOverlayPopup("idpopupDectect");	
			jQuery("body").append('<div id="idpopupDectect" class="Detect"><a class="SurveyClose" title="Ðóng" href="#">Ðóng</a><div class="SurveyContent"><iframe height="'+height+'" frameborder="0" width="'+width+'" allowtransparency="1" src='+url+'></iframe> </div></div>');
				
					
				jQuery('.SurveyClose').bind('click', function() {
					closePopup('idpopupDectect');
					jQuery("#idpopupDectect").remove();
						return false;
				});
				jQuery('#overlays').bind('click', function() {
					closePopup('idpopupDectect');
					jQuery("#idpopupDectect").remove();
						return false;
				});
			return false;
		}
		
		
	}

var IE6 = jQuery.browser.msie && jQuery.browser.version == 6.0;
function createOverlayPopup (id) {
    if ( jQuery("#overlays").length > 0 ) { return; }
    var overlays = jQuery("<div id=\"overlays\">");
    var _width = jQuery(window).width()/2;
    var _height = jQuery(window).height()/2;
    var _scrolltop = jQuery(window).scrollTop();
    jQuery("body").append(overlays);
	if (IE6){
		overlays.css({
			width: jQuery(document).width() -18,
			height: jQuery(document).height(),
			position: "absolute",
			top: 0,
			left: 0,
			zIndex: 900,
			background: "#000000",
			opacity: 0
		});
	}
	else {
		overlays.css({
			width: jQuery(document).width(),
			height: jQuery(document).height(),
			position: "absolute",
			top: 0,
			left: 0,
			zIndex: 900,
			background: "#000000",
			opacity: 0
		});
	}
    overlays.fadeTo("fast", 0.7, function(){
        jQuery("#" + id).css({
            display: "block",
            top: _height + _scrolltop - jQuery("#" + id).height()/2,
            left: _width - jQuery("#" + id).width()/2
        })
    });
    jQuery(window).resize(function(){
        var newh = jQuery(window).height()/2;
        var neww = jQuery(window).width()/2;
        var newscroll = jQuery(window).scrollTop();
        if (IE6){
			overlays.css({
				width: jQuery(document).width() - 18
			});
        }
		else {
			overlays.css({
				width: jQuery(document).width()
			});
		}
        jQuery("#" + id).css({
            top: newh + newscroll - jQuery("#" + id).height()/2,
            left: neww - jQuery("#" + id).width()/2
        })
    });
	
    if( jQuery("#fbPopupMenu_" + id).find("li.Hilite").hasClass("ha")){
        autoPlay(jQuery("#img_" + id), id);
    }
    jQuery(overlays).bind("click", function () {
        closePopup(id);
        return false;
    });
	
    jQuery("#fbclose_" + id).bind("click", function () {
        closePopup(id);
        return false;
    });
	
	jQuery('#'+id+' .PopupCloseBtn').bind("click", function () {
        closePopup(id);
        return false;
    });
}

function closePopup (id) {
   
    jQuery("#" + id).css({
        display: "none"
    });
	// jQuery("#" + id).remove();
    jQuery("#overlays").fadeOut("fast", function () {
        jQuery("#overlays").remove();
        jQuery("#" + id).css({
            display: "none"
        });
    })
	if (id == "MusicOverlays"){
		jQuery("#" + id).remove();
	}
}
function topBarTracking(){
	
	_gaq.push(['secondTracker._trackEvent','Top Bar' , productCode, "Vui Game 20112012"]);
	window.open("http://appclick.zing.vn/UserClick/Analytics.php?eventid=1116&type=1166&pid=127&bannerid=565","_blank");
}
// Tracking 3.0

function replaceTracking(){
		
		var linkDoc= jQuery('a');
		
		jQuery.each(linkDoc, function(i, val) { 			
			
			/* 
			if( jQuery(this).attr("href")==objLinkTracking['oldReg']){
				jQuery(this).attr("href",objLinkTracking['replaceReg']);			
				
			}
			if( jQuery(this).attr("href")==objLinkTracking['oldQuickReg']){
				jQuery(this).attr("href",objLinkTracking['replaceQuickReg']);			
				
			}	
			*/
			var cMAS_AID=getCookieMAS("MAS_AID");
			for ( var k in specialLink ) {					
						allFlashLink[k] = specialLink[k].linkFlash;		
				}
			if(cMAS_AID!=undefined){
				
				if(objLinkTracking['replacePlayNow']!=""){
					if( jQuery(this).attr("href")==objLinkTracking['oldPlayNow']){
						jQuery(this).attr("href",objLinkTracking['replacePlayNow']);
					}
				}
				
				//replace link trong flash
				try{
					for ( var k in specialLink ) {					
						allFlashLink[k] = specialLink[k].linkReplace;		
					}
					
				}catch(exp){}
				
			}
			
			
			
			
		})
	}
	
function clickTracking () {
		
	jQuery(document).find("a").bind("click",function(){		
				
		if( jQuery(this).attr("onclick")==undefined) {			
			
			if(jQuery(this).attr("href")==objLinkTracking['replaceReg']){
				_gaq.push(['_trackEvent','Dang ky' , 'Link',productCode]);
				
			}
			
			if(jQuery(this).attr("href")==objLinkTracking['replacePlayNow']){
				_gaq.push(['_trackEvent','PlayNow' , 'Link',productCode]);
				
			}
			
			for (i=0;i< taiKhoan.length; i++){				
				if(jQuery(this).attr("href")==taiKhoan[i]){					
					_gaq.push(['_trackEvent','Tai khoan' , 'Link',productCode]);					

				}
				
			}
		}
			
	})
}
function getCookieMAS(c_name){
	var i,x,y,ARRcookies=document.cookie.split(";");
	for (i=0;i<ARRcookies.length;i++){
		x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
		y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
		x=x.replace(/^\s+|\s+$/g,"");
		if (x==c_name){
			return unescape(y);
		}
	}
}
function trackLink (a,b){

}
// end tracking 3.0	

jQuery(document).ready(function(){
		callPopupDetect(productCode);
	})
	