(function( jQuery, undefined ) {
	var isIE6 = (/MSIE 6\.0/).test(navigator.userAgent);
	jQuery.widget( "ui.topslide", {
		options:{
			initTop: 5,
			offsetToScroll: 0,
			offsetTop: 5,
			offsetLeft: 0,
			RelativeID: "body",
			animation: false,
			boxMaxHeight: "",
			type: 'top' // top or height 
		},
		_create: function() {
			var self = this,
				options = self.options,
				el = self.element;
			self.applyPosition = "absolute";
			self.left = options.offsetLeft;
            if ( options.boxMaxHeight != "" && jQuery(options.boxMaxHeight).length > 0 ) {
				self.maxHeight = jQuery(options.boxMaxHeight).height() + jQuery(options.boxMaxHeight).offset().top;
			}
			//init
			el.css({
				position: self.applyPosition,
				top: options.initTop,
				left: self.left
			});
			//binding events
			if ( isIE6 || options.animation || options.type == 'height') {
						
				self._smoothscroll();
					
			} else {
				
				jQuery(window).scroll(function () {
					if ( jQuery(document).scrollTop() > options.offsetToScroll ) {
						if ( self.maxHeight > options.offsetToScroll && jQuery(document).scrollTop() + options.offsetTop + jQuery(self.element).outerHeight(true) > self.maxHeight ) {
							var scrollTop = self.maxHeight - jQuery('#' + options.RelativeID).offset().top - jQuery(self.element).outerHeight(true); 
							el.css({
								position: "absolute",
								left: options.offsetLeft,
								top: scrollTop
							});		
						}
						else {
							el.css({
								position: "fixed",
								left: options.offsetLeft +jQuery("#" + options.RelativeID).offset().left ,
								top: parseInt(options.offsetTop)
							});		
						}		
					}
					else {
						el.css({
							position: "absolute",
							left: options.offsetLeft,
							top: parseInt(options.initTop)
						});
					}
				});
				jQuery(window).resize(function(){
					var _scrollTop = jQuery(document).scrollTop();
					var wWidth = jQuery(document).width(); 
					if(_scrollTop > options.offsetToScroll){
						if(!isIE6 && !options.animation){
							el.css({
								left: options.offsetLeft +jQuery("#" + options.RelativeID).offset().left 
							});
						}
					}
				});
			}
		},
		_smoothscroll: function(){
			var self = this,
				options = self.options,
				el = self.element;
				minHeight = parseFloat(el.height());
			if ( options.boxMaxHeight != "" && jQuery(options.boxMaxHeight).length > 0 ) {
				self.maxHeight = jQuery(options.boxMaxHeight).height() + jQuery(options.boxMaxHeight).offset().top;
			}
			jQuery(window).scroll(function (evt) {				
				var scrollTop = jQuery(document).scrollTop();
				if(scrollTop > options.offsetToScroll){
					if ( self.maxHeight > options.offsetToScroll && scrollTop + options.offsetTop > self.maxHeight ) {
						if(options.type == 'height'){
							el.stop().animate({
								height: self.maxHeight + minHeight 
							},{duration:1000,easing:'easeInOutCubic'});
						} else if(options.type == 'top'){
							scrollTop = self.maxHeight - minHeight - jQuery('#' + options.RelativeID).offset().top; 
							el.animate({top:scrollTop},{duration:1600,queue:false},function(){
								var _scrollTop = jQuery(document).scrollTop();
								if(_scrollTop <= options.offsetToScroll){
									el.animate({
										top: options.initTop
									},{duration:1600,queue:false});
								}
							});
						}
					
					}
					else {
						if(options.type == 'height'){
							el.stop().animate({
								height: scrollTop 
							},{duration:1000,easing:'easeInOutCubic'});
						} else if(options.type == 'top'){
							scrollTop = scrollTop + options.offsetTop - jQuery('#' + options.RelativeID).offset().top;
							el.animate({top:scrollTop},{duration:1600,queue:false},function(){
								var _scrollTop = jQuery(document).scrollTop();
								if(_scrollTop <= options.offsetToScroll){
									el.animate({
										top: options.initTop
									},{duration:1600,queue:false});
								}
							});
						}
					}
				} else{
					if(options.type == 'height'){
						el.stop().animate({
							height: minHeight 
						},{duration:1000,easing:'easeInOutCubic'});
					} else if(options.type == 'top'){
						el.stop().animate({top:options.initTop},{duration:800,queue:false});
					}
				}
			});
		}
	});
})(jQuery);