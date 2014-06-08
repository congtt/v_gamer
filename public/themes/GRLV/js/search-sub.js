jQuery(document).ready(function(){
	//apply paging
	if ( jQuery("#pagingSearch .PagingControl .CenterWrapper").length > 0 ) {
		jQuery("#pagingSearch .PagingControl .CenterWrapper a.PagingLink").live("click",function(){			
			var pagingInfo = jQuery(this).attr("rel");
			loadPageSearch(pagingInfo);
			return false;
		})
	}
	function loadPageSearch (pagingInfo) {
		var configmoduleOuputId = jQuery("#configmoduleOuputId").val();
		var configshortUri = jQuery("#configshortUri").val();
		var configtoken = jQuery("#configtoken").val();
		var datarawConditionKeyword = jQuery("#datarawConditionKeyword").val();
		var datarawConditionCateCode = jQuery("#datarawConditionCateCode").val();
		var datarawConditionSiteCode = jQuery("#datarawConditionSiteCode").val();
		var datapost = 'module=' + configmoduleOuputId + '&moduleParams={"Keyword":"' +  datarawConditionKeyword + '","CateCode":"' + datarawConditionCateCode + '","SiteCode":"' + datarawConditionSiteCode + '"}&token=' + configtoken;
		jQuery.ajax({
			type: "POST",
			url: SITE_URL + '/' + configshortUri + '.' + pagingInfo.split("&")[3] + '.html' ,
			dataType: "json",
			data: datapost ,
			success: function(msg){
				if ( jQuery("#search_result") ) {
					jQuery("#search_result").html(msg[configmoduleOuputId]['content']);
				}
				if ( jQuery(".PagingWrapper") ) {
					jQuery(".PagingWrapper").html(msg[configmoduleOuputId]['paging']);
				}
				trackLink("#searchResult");
			}
		});
	}
	
});