var login={};//定义命名空间

var usernameFlag=false;
var userPwdFlag=false;
var valicodeFlag=true;
//页面加载完之后，会立即触发回调函数
$(function(){
	login.checkusername();
	login.checkpwd();
	login.checkValicode();
	login.clickBtn();
});

//校验账号
login.checkusername=function(){
	//给账号输入框绑定焦点失去事件
	$("#username").blur(function(){
		$("#usernameMsg").html("");
		var code=$("#username").val();
		if(code.trim().length==0||code==null){
			$("#usernameMsg").html("不能为空");
			return;
		}
		var reg=/^[a-zA-Z0-9_]{5,10}$/;
		var flag=reg.test(code);
		if(flag){
			//校验成功
			usernameFlag=true;
			$("#usernameMsg").html("");
		}else{
			//校验失败
			usernameFlag=false;
			$("#usernameMsg").html("5-10的数字、字母、下划线");
		}
	});
}

//校验密码
login.checkpwd=function(){
	//给账号输入框绑定焦点失去事件
	$("#pwd").blur(function(){
		$("#pwdMsg").html("");
		var code=$("#pwd").val();
		if(code.trim().length==0||code==null){
			$("#pwdMsg").html("不能为空");
			return;
		}
		var reg=/^[a-zA-Z0-9_]{5,10}$/;
		var flag=reg.test(code);
		if(flag){
			//校验成功
			userPwdFlag=true;
			$("#pwdMsg").html("");
		}else{
			//校验失败
			userPwdFlag=false;
			$("#pwdMsg").html("5-10的数字、字母、下划线");
		}
	});
}

//给验证码输入框绑定焦点失去事件
login.checkValicode=function(){
	
	$("#valicode").blur(function(){
		var valicode=this.value;
		if(valicode==null||valicode.trim().length==0){
			//valicodeFlag=false;
			$("#valicodeMsg").html("不能为空");
			return;
		}
//		var rightCode=$("#rightCode").val();
//		console.log(rightCode);
		if(rightCode.equals(valicode)){
			valicodeFlag=true;
		}else{
			//valicodeFlag=false;
		}
	});
}
//给链接绑定点击事件
login.clickBtn=function(){
	$(".login_button a").click(function(){
		//调用表单的submit函数
		if(usernameFlag&&userPwdFlag&&valicodeFlag){
			$("form").submit();
		}
	});
}

















