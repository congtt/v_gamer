/* 	
	Bien dung chung cho toan site, duoc lay gia tri
	tu cac input hidden tao trong template management
*/
var moduleOuputId; 
var token;
var shortUri; //url for paging
var cateCode;
var currentSearchTab;
var currentTab;
var currentSection; //current secsion: tin-tuc,su-kien,thu-vien
var activemenu_nav; //active top menu 
var activesidenav; //active left menu 
var IE6 = jQuery.browser.msie && jQuery.browser.version == 6.0;
var IE7 = jQuery.browser.msie && jQuery.browser.version == 7.0;

(function(window,undefined){
	// Establish Variables
	if(!IE6 && !IE7){
		var	History = window.History;
	}
})(window);

jQuery(document).ready(function() {

	// Khoi tao gia tri cho bien
	moduleOuputId  = jQuery("#moduleOuputId").val();
	token = jQuery("#token").val();
	shortUri = jQuery("#shortUri").val();
	cateCode = jQuery("#cateCode").val();
	currentSearchTab = jQuery("#currentSearchTab").val();	
	//alert(Query("#currentTab").length);
	currentTab = (jQuery("#currentTab").length > 0) ? jQuery("#currentTab").val() : '';
	currentSection = $('#currentSection').val();

	// active navigation 
	/*if($('#activeMenuNav').length >0)*/{
		activemenu_nav = $('#activeMenuNav').val();
		activesidenav  = $('#activeSideNav').val();
	}
});
