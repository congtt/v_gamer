var currentTab = "";
jQuery(document).ready(function () {
	currentTab = "tat-ca";
	if(jQuery("#imgControl").children().size() > 1) {
		if (jQuery("#img").length > 0) {
			new FadeGallery(jQuery("#img"), {
				control_event : "mouseover",
				auto_play : true,
				control : jQuery("ul#imgControl"),
				delay : 2
			});
		}
		var imgControl = false;
		if (jQuery("#imgControl").size()) {
			imgControl = jQuery("#imgControl");
		}
		if (jQuery(".NavLeft").size()) {
			jQuery(".NavLeft").click(function () {
				var fBtn = imgControl.find(".ActiveBanner").prev();
				if (!fBtn.size()) {
					fBtn = imgControl.children(":last");
				}
				fBtn.trigger("mouseover");
			});
		}
		if (jQuery(".NavRight").size()) {
			jQuery(".NavRight").click(function () {
				var fBtn = imgControl.find(".ActiveBanner").next();
				if (!fBtn.size()) {
					fBtn = imgControl.children(":first");
				}
				fBtn.trigger("mouseover");
			});
		}
	} else {
		jQuery("#imgControl").hide();
		jQuery(".NavRight").hide();
		jQuery(".NavLeft").hide();
	}
	
	
	if (jQuery(".LeftContent").find("#imgControl").size()) {
		var imgControlSub = jQuery(".LeftContent").find("#imgControl");
		/* imgControlSub.css({
			"left" : (((jQuery(".BannerEvent").width() - imgControlSub.outerWidth()) / 2) + "px")
		}); */
	}
	if (jQuery(".TopBtn").length > 0) {
		var heightTop = 350;
		jQuery(".TopBtn").topslide({
			initTop : heightTop,
			offsetToScroll : 350,
			offsetTop : 350,
			offsetLeft : 680,
			boxMaxHeight : "#static",
			RelativeID : "static",
			animation : true,
			type : 'top'
		});
	}
	if(jQuery("#imgControl").size()) {
		jQuery("#imgControl").find("a").each(function(index) {
			jQuery(this).unbind().click(function() {
				/* jQuery(jQuery("#img").find("a").get(jQuery(this).attr("href").replace("#", ""))).notify("click"); */
				// var targetObj = ery("#img").find("a").eq(jQuery(this).attr("href").replace("#", "")*1 - 1);
				// if(targetObj.attr("target") && targetObj.attr("target") == "_blank") {
					// window.open(targetObj.attr("href"), "_blank");
				// } else {
					// window.location = targetObj.attr("href");
				// }
			});
		});
	}
	if(jQuery(".BannerEvent").size()) {
		jQuery(".BannerEvent").each(function(index) {
			if(jQuery(this).width() < 400) {
				jQuery(this).find(".BigSlider").size() && jQuery(this).find(".BigSlider").hide();
				jQuery(this).find("img").removeAttr("width");
				jQuery(this).find("img").removeAttr("height");
			}
		});
	}
	if(jQuery('#activeSideNav').size() && jQuery('#activeSideNav').val()=="menu0_0_0") {
		jQuery(".ExtLinks .TinTuc a").addClass("Active");
	}
	if(jQuery('a[href=\"#huong-dan\"]').size() && jQuery('a[href=\"#huong-dan\"]').parent().hasClass("Active")) {
		jQuery("#sidenav a[title=\"Hướng dẫn\"]").parent().addClass("Hilite").addClass("Active");
	}
});
