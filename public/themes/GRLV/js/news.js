jQuery(document).ready(function () {
	
	//apply paging
	if (jQuery(".PagingWrapper .PagingControl .CenterWrapper").length > 0) {
		jQuery(".PagingWrapper .PagingControl .CenterWrapper a.PagingLinkNews").live("click", function () {
			var pagingInfo = jQuery(this).attr("rel");
			loadPageNews(pagingInfo);
			return false;
		});
	}
	if (jQuery(".PagingWrapper .PagingControl .CenterWrapper").length > 0) {
		jQuery(".PagingWrapper .PagingControl .CenterWrapper a.PagingLinkRelatedNews").live("click", function () {
			var pagingInfo = jQuery(this).attr("rel");
			loadPageRelatedNews(pagingInfo);
			return false;
		});
	}
	
	// cate tabs for News
	if (jQuery("#tabHeaderHome > li > a.TabCateNews").length > 0) {
		jQuery("#tabHeaderHome > li > a.TabCateNews").bind("click", function () {
			if (jQuery(this).parent().hasClass("Active")) {
				return false;
			} else {
				var tabInfo = jQuery(this).attr("rel").split("_");
				jQuery("#homeCatDetail").size() && jQuery("#homeCatDetail").attr({
					"href" : ("/tin-tuc/danh-sach." + tabInfo[0] + ".html")
				});
				loadTabNews(tabInfo[0], tabInfo[1], this);
			}
			return false;
		})
	}
	
	/* load ajax list tab news */
	var currTabName = currentTab;
	var tabContent = {};
	function loadTabNews(tabName, urlInput, target) {
		currTabName = tabName;
		jQuery(".MainMenu > ul > li.Active").removeClass("Active");
		jQuery(target).parent().addClass("Active");
		if (!tabContent[tabName]) {
			jQuery.ajax({
				type : "POST",
				url : urlInput,
				dataType : "json",
				data : "module=" + moduleOuputId + "&moduleParams={}&token=" + token,
				success : function (msg) {
					tabContent[tabName] = msg[moduleOuputId];
					jQuery("#searchResult").html(tabContent[tabName]);
					trackLink("#searchResult");
				}
			});
		} else {
			jQuery("#searchResult").html(tabContent[tabName]);
			trackLink("#searchResult");
		}
	}
	/* load ajax list news*/
	function loadPageNews(pagingInfo) {
		var outputId = pagingInfo.split("&")[0];
		var pagingType = pagingInfo.split("&")[3];
		if (pagingType == "module") {
			dataPost = "module=" + outputId + "&moduleParams={}&" + pagingInfo.split("&")[1];
		} else if (pagingType == "block") {
			dataPost = "block={\"" + outputId + "\":{}}\&" + pagingInfo.split("&")[1];
		}
		jQuery.ajax({
			type : "POST",
			//url: SITE_URL+'/{jQueryconfig["shortUri"]}.'+page+'.html',
			url : pagingInfo.split("&")[2],
			dataType : "json",
			data : dataPost,
			success : function (msg) {
				jQuery("." + outputId).html(msg[outputId]);
				//trackLink("." + outputId , false);
				if (!IE6 && !IE7) {
					if (History.enabled) {
						var tmp = "";
						if (window.location.href.indexOf('?') > -1) {
							tmp = window.location.href.split("?");
							tmp = tmp[1];
						}
						var url;
						if (tmp != "")
							url = pagingInfo.split("&")[2] + "?" + tmp;
						else
							url = pagingInfo.split("&")[2];
						
						History.pushState(null, "", url);
					}
				}
			}
		});
	}
	
	function loadPageRelatedNews(pagingInfo) {
		var outputId = pagingInfo.split("&")[0];
		var pagingType = pagingInfo.split("&")[3];
		if (pagingType == "module") {
			dataPost = "module=" + outputId + "&moduleParams={}&" + pagingInfo.split("&")[1];
		} else if (pagingType == "block") {
			dataPost = "block={\"" + outputId + "\":{}}\&" + pagingInfo.split("&")[1];
		}
		jQuery.ajax({
			type : "POST",
			//url: SITE_URL+'/{jQueryconfig["shortUri"]}.'+page+'.html',
			url : pagingInfo.split("&")[2],
			dataType : "json",
			data : dataPost,
			success : function (msg) {
				jQuery("." + outputId).html(msg[outputId]);
				//trackLink("." + outputId , false);
			}
		});
	}
	
	function loadPageNews2(page) {
		jQuery.ajax({
			type : "POST",
			url : page,
			dataType : "json",
			data : "module=" + moduleOuputId + "&moduleParams={}&token=" + token,
			success : function (msg) {
				jQuery("." + moduleOuputId).html(msg[moduleOuputId]);
				if (!IE6 && !IE7) {
					if (History.enabled) {
						History.pushState(null, "", page);
					}
				}
			}
		});
	}
	
	(function (window, undefined) {
		// Bind to StateChange news
		if (!IE6 && !IE7) {
			History.Adapter.bind(window, 'statechange', function () {
				
				var State = History.getState();
				if (currentSection == 'tin-tuc') {
					loadPageNews2(State.url);
				}
			});
		}
		
	})(window);
	
});
