function getXhr(){
		var xhr=null;
		if(window.XMLHttpRequest){
			//非低版本的IE
			xhr=new XMLHttpRequest();
		}else{
			xhr=new ActiveXObject("Microsoft.XMLHttp");
		}
		return xhr;
	}