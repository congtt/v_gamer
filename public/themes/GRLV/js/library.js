	var currentOffset = Math.floor($('#currentOffset').val());
	var currentPage = Math.floor($('#currentPage').val());
	var currentItemNum = Math.floor($('#currentItemNum').val());
	var itemPerPage  = Math.floor($('#itemPerPage').val());
	var isPaging = Math.floor($('#isPaging').val());
	var sectionDetail =  $('#sectionDetail').val();
	var actionDetail =  $('#actionDetail').val();
	var currentContentType =  $('#currentContentType').val();
	var imagePath;
	var imageId;
	var imageSize;
	var imageName;
	
    $(document).ready(function() {		
				
				$('.Wallpaper > li > a.PopUp').click(function() {
					var imageNameSeo = $(this).find(">input.imageNameSeo").val();
					var imageNo =  $(this).find(">input.imageNo").val();
					libraryLoadDetail(imageNameSeo,imageNo,0);
					return false;
				});
				
				$('.Wallpaper > li > a').click(function() {
					var imageNameSeo = $(this).find(">input.imageNameSeo").val();
					var imageNo =  $(this).find(">input.imageNo").val();
					libraryLoadDetail(imageNameSeo,imageNo,0);
					return false;
				});			
				if (jQuery("#wallpaperDetail").length==0){
					jQuery("body").append('<div id="wallpaperDetail" class="WallpaperPopup" style="display:none"></div>');
				}	
		  				
		
		
		$('.Wallpaper > li > p.ListThum').each(function (i) {
				var imageId = "listImgSize"+$(this).find(">input.imageId").val();
				var imageSize = $(this).find(">input.imageSize").val();
				var imageName = $(this).find(">input.imageName").val();
				imagePath = $(this).find(">input.imagePath").val();
				libraryLoadImageSize(imageId,imageSize,imageName);
			})
			
		$('.Wallpaper > li > p.DownloadImg').each(function (i) {
				imageId = "listImgSize"+$(this).find(">input.imageId").val();
				imageSize = $(this).find(">input.imageSize").val();
				imageName = $(this).find(">input.imageName").val();
				imagePath = $(this).find(">input.imagePath").val();
				libraryLoadImageSize_2(imageId,imageSize,imageName);
			})
			
			jQuery('.ListVideo').each(function() {
				  jQuery(this).jcarousel();
				  
			});
			
			var id_0 = 'http://video.zing.vn/getGameXML.php?id='+jQuery("ul#listVideo > li").eq(0).attr("rel");	
			
			var zingWidth = $("input.zingWidth").val();	
			var zingHeight = $("input.zingHeight").val();
			jQuery("ul#listVideo > li").eq(0).addClass("Active");
			libraryPlayClip(id_0,zingWidth,zingHeight);	
			
			
			$('#listVideo > li > a').live("click",function() {
				var zingUrl = $(this).find(">input.zingUrl").val();	
				jQuery(".ListVideo > li.Active").removeClass("Active");
				jQuery(this).parent().addClass("Active");
				libraryPlayClip(zingUrl,zingWidth,zingHeight);
				return false;
			})
			
			/*phan trang */
			if( jQuery(".PagingWrapper .PagingControl .CenterWrapper").length > 0 ) {
				jQuery(".PagingWrapper .PagingControl .CenterWrapper a.PagingLinkLibrary").live("click",function(){			
					var params = $(this).attr("rel").replace(/\r\n\s/g,"").toString(); // Thay the xuong hang			
					loadPageLibrary(params)
					return false;
				});
			}	
	});
	
	function loadPageLibrary(page) {
			var splitParams = page.split("&");
			var postData = "block={\"" + splitParams[0] + "\":{}}\&"+ splitParams[1];			
			var urlInput = splitParams[2] == "''" ? '' : splitParams[2];
			var urlInput2 = urlInput.split("/");
			//console.log("urlInput"+urlInput2);	
			var splitPage = urlInput2[4].split(".");	
			//console.log("urlInput"+splitPage[2]);				
			var pageCurent = splitPage[2];
				$.ajax({
					type: "POST",
					url: urlInput,
					dataType: "json",
					data: "module="+moduleOuputId+"&moduleParams={}&token="+token,
					success: function(msg) {						
						if($("#listContent")) {
							$("#listContent").html(msg[moduleOuputId]['content']);
						  	$("#currentPage").val(pageCurent);
							$("#currentOffset").val((pageCurent -1) * itemPerPage);			
							$('.Wallpaper > li > a.PopUp').click(function() {
								var imageNameSeo = $(this).find(">input.imageNameSeo").val();
								var imageNo =  $(this).find(">input.imageNo").val();
								libraryLoadDetail(imageNameSeo,imageNo,0);
								return false;
							});
						
							$('.Wallpaper > li > a').click(function() {
								var imageNameSeo = $(this).find(">input.imageNameSeo").val();
								var imageNo =  $(this).find(">input.imageNo").val();
								libraryLoadDetail(imageNameSeo,imageNo,0);
								return false;
							});			
							
							$('.Wallpaper > li > p.ListThuVien').each(function (i) {
							var imageId = "listImgSize"+$(this).find(">input.imageId").val();
							var imageSize = $(this).find(">input.imageSize").val();
							var imageName = $(this).find(">input.imageName").val();
							imagePath = $(this).find(">input.imagePath").val();
							if(currentContentType=="hinh-nen"){
								libraryLoadImageSize(imageId,imageSize,imageName);
							}else{
								libraryLoadImageSize_2(imageId,imageSize,imageName);
							}
							
							})
						}
						if($("#pagingContent")) {
							$("#pagingContent").html(msg[moduleOuputId]['paging']);
							
						}
						/*if(History.enabled) {		
							History.pushState(null,"",urlInput );
						}*/				
					}
				});

		}
		
	 function libraryLoadDetail(objectNameSeo, offset, detailFlg){
        if( currentOffset && offset && detailFlg == 0 ) {
            //offset = parseInt(currentOffset) + parseInt(offset);
        }else{
			
			
		}
		currentOffset = Math.floor($('#currentOffset').val());				
		 if(detailFlg == 0 ){
			 offset=parseInt(currentOffset) + parseInt(offset);	
		 }
		
		
		var url_=SITE_URL+'/'+sectionDetail+'/'+actionDetail+'.'+currentContentType+'.'+objectNameSeo+'.'+offset+'.html';
		
        $.ajax({
            type: "POST",
            url: SITE_URL+'/'+sectionDetail+'/'+actionDetail+'.'+currentContentType+'.'+objectNameSeo+'.'+offset+'.html',
            dataType: "json",
            data: "module="+moduleOuputId+"&moduleParams={}&token="+token,
            success: function(msg){             
					
			   jQuery("#wallpaperDetail").html(msg[moduleOuputId]);
			   createOverlays("wallpaperDetail");
			   
			   var imageId= jQuery(".ListDownloadOption").find(">input.imageId").val();
			   var imageSize= jQuery(".ListDownloadOption").find(">input.imageSize").val();
			   var imageName=jQuery(".ListDownloadOption").find(">input.imageName").val();
			   var flagType= jQuery(".ListDownloadOption").find(">input.libraryCode").val();  
			   
			  
			   
			 if(flagType=="hinh-trong-game"){
				   libraryLoadImageSizePopup_2(imageId, imageSize, imageName);
			   }else{				  
				  libraryLoadImageSizePopup(imageId, imageSize, imageName);		  
			   }
			   
			 
			   			   	
				jQuery('a.PopupCloseBtn').bind('click', function() {
					closeVideo ('wallpaperDetail')					 
				});
							  
            }
        });
    }
	
	function libraryExplode (delimiter, string, limit) {
        // Splits a string on string separator and return array of components. If limit is positive only limit number of components is returned. If limit is negative all components except the last abs(limit) are returned.
        //
        // version: 1009.2513
        // discuss at: http://phpjs.org/functions/explode    // +     original by: Kevin van Zonneveld (http://kevin.vanzonneveld.net)
        // +     improved by: kenneth
        // +     improved by: Kevin van Zonneveld (http://kevin.vanzonneveld.net)
        // +     improved by: d3x
        // +     bugfixed by: Kevin van Zonneveld (http://kevin.vanzonneveld.net)    // *     example 1: explode(' ', 'Kevin van Zonneveld');
        // *     returns 1: {0: 'Kevin', 1: 'van', 2: 'Zonneveld'}
        // *     example 2: explode('=', 'a=bc=d', 2);
        // *     returns 2: ['a', 'bc=d']
         var emptyArray = { 0: '' };

        // third argument is not required
        if ( arguments.length < 2 ||
            typeof arguments[0] == 'undefined' ||        typeof arguments[1] == 'undefined' ) {
            return null;
        }

        if ( delimiter === '' ||        delimiter === false ||
            delimiter === null ) {
            return false;
        }
         if ( typeof delimiter == 'function' ||
            typeof delimiter == 'object' ||
            typeof string == 'function' ||
            typeof string == 'object' ) {
            return emptyArray;    }

        if ( delimiter === true ) {
            delimiter = '1';
        }
        if (!limit) {
            return string.toString().split(delimiter.toString());
        } else {
            // support for limit argument        var splitted = string.toString().split(delimiter.toString());
            var partA = splitted.splice(0, limit - 1);
            var partB = splitted.join(delimiter.toString());
            partA.push(partB);
            return partA;
        }
    }
	
	function libraryLoadImageSize(objectId, imgSizeList, imgName){
        var object = document.getElementById(objectId);
        if( !imgSizeList || !object || !imgName )
        {
            return false;
        }
        //var imgPath = '{$config['detail']['content'][$config['currentContentType']]['imagePath']}';
        var imgPathList = libraryExplode('/', imagePath);
        var imgSize = libraryExplode(';', imgSizeList);
        var total = imgSize.length;
        var innerImgSize = '';
        if(total > 0){
            for(var idx = 0; idx < total; ++idx){
				if (idx==1){ imgPathList[1]="wall1280";}
				if (idx==2){ imgPathList[1]="wall1600";}
                innerImgSize += '<a href="javascript: libraryDownload(\''+IMG_URL+'/images/modules/' + imgPathList[1] + '/' + imgSize[idx] + '/' + imgName + '\')" title="Download hình kích thước ' + imgPathList[1] + '" class="Size_'+imgSize[idx]+' NotTrack ">' + imgSize[idx] + '</a>';
            }
        }
		
        object.innerHTML = innerImgSize;
		
    }
	
	function libraryLoadImageSizePopup(objectId, imgSizeList, imgName){
        var object = document.getElementById(objectId);
        if( !imgSizeList || !object || !imgName )
        {
            return false;
        }
        //var imgPath = '{$config['detail']['content'][$config['currentContentType']]['imagePath']}';
        var imgPathList = libraryExplode('/', imagePath);
        var imgSize = libraryExplode(';', imgSizeList);
        var total = imgSize.length;
        var innerImgSize = '';
        if(total > 0){
            for(var idx = 0; idx < total; ++idx){
				if (idx==1){ imgPathList[1]="wall1280";}
				if (idx==2){ imgPathList[1]="wall1600";}
                innerImgSize += '<li><a href="javascript: libraryDownload(\''+IMG_URL+'/images/modules/' + imgPathList[1] + '/' + imgSize[idx] + '/' + imgName + '\')" title="Download hình kích thước ' + imgPathList[1] + '" class="Size_'+imgSize[idx]+' NotTrack">' + imgSize[idx] + '</a></li>';
            }
        }
		
        object.innerHTML = innerImgSize;
		
    }
	
	
	function libraryLoadImageSize_2(objectId, imgSizeList, imgName){
        var object = document.getElementById(objectId);
        if( !imgSizeList || !object || !imgName )
        {
            return false;
        }
      //  var imgPath = '{$config['detail']['content'][$config['currentContentType']]['imagePath']}';
        var imgPathList = libraryExplode('/', imagePath);
        var imgSize = libraryExplode(';', imgSizeList);
        var total = imgSize.length;
        var innerImgSize = '';
        if(total > 0){
            for(var idx = 0; idx < total; ++idx){
			    
				if (idx==1){ imgPathList[1]="wall1280";}
				if (idx==2){ imgPathList[1]="wall1600";}
                innerImgSize += '<a href="javascript: libraryDownload(\''+IMG_URL+'/images/modules/' + imgPathList[1] + '/' + imgSize[idx] + '/' + imgName + '\')" title="Download hình kích thước ' + imgPathList[1] + '" class="notTrack">Download</a>';
            }
        }
		//alert("ham 2");
        object.innerHTML = innerImgSize;
		
    }

	function libraryLoadImageSizePopup_2(objectId, imgSizeList, imgName){
        var object = document.getElementById(objectId);
        if( !imgSizeList || !object || !imgName )
        {
            return false;
        }
      //  var imgPath = '{$config['detail']['content'][$config['currentContentType']]['imagePath']}';
        var imgPathList = libraryExplode('/', imagePath);
        var imgSize = libraryExplode(';', imgSizeList);
        var total = imgSize.length;
        var innerImgSize = '';
        if(total > 0){
            for(var idx = 0; idx < total; ++idx){
			    
				if (idx==1){ imgPathList[1]="wall1280";}
				if (idx==2){ imgPathList[1]="wall1600";}
                innerImgSize += '<li><a href="javascript: libraryDownload(\''+IMG_URL+'/images/modules/' + imgPathList[1] + '/' + imgSize[idx] + '/' + imgName + '\')" title="Download hình kích thước ' + imgPathList[1] + '" class="Download notTrack">Download</a></li>';
            }
        }
		//alert("ham 2");
        object.innerHTML = innerImgSize;
		
    }
	
	
	function libraryDownload( libraryPath ){
        if( libraryPath ){
            var ifrm = $('#ifrmDownload');
            var SRC = SITE_URL +'/' + sectionDetail+'/download.'+currentContentType+'.html?token='+token+'&downloadUrl=' + libraryPath;
			if( ifrm.length > 0 ){
                ifrm.attr('src', SRC);
            } else {
                jQuery('<iframe style="display:none; width:0px; height:0px" id="ifrmDownload" src="'+SRC+'"></iframe>').appendTo('body');
            }
        };
    };
	
	
	function libraryPlayClip(url,widthD,heightC){
		var attributes = {};
		var flashvars = {};
			flashvars.width = widthD;
			flashvars.height = heightC;
			flashvars.showicons = "true";
			//flashvars.autostart = "true";
			flashvars.link = url;
		
		var params = {
                        menu: "false",
                        allowFullscreen: "true",
                        allowScriptAccess: "always",
						//play:"true",
						bgcolor: "#ffffff"
                    };
		params.wmode = "transparent";
		params.allowfullscreen ="true";
		params.scale = "noscale";
		params.quality = "high";
		params.allowScriptAccess = "always";
		flashvars.link =url;
					swfobject.embedSWF("http://img.zing.vn/eventgame/media/video-xml-controller.swf", "playerVideo1", widthD, heightC, "8.0.0", "http://img.zing.vn/eventgame/media/expressInstall.swf", flashvars, params, attributes);
					
					
		
	}	
		

	
	