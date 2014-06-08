	function message(msg,_timeout){
	
		if (msg==''){
			msg='Ðang x? lý thông tin.';
		}
		var updateSuccess = {
			timeout: 3,
			className: 'achtungSuccess',
			icon: 'ui-icon-check'
		};	
		var updateFail = {
			timeout: 3,
			className: 'achtungFail',
			icon: 'ui-icon-check'
		};
		
	
		var preload = $.achtung(updateSuccess, {message: msg,timeout:_timeout});
		return preload;
	}	