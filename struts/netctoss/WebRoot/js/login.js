var login={};//定义命名空间

var adminCodeFlag=false;
var adminPwdFlag=false;
var valicodeFlag=false;
//页面加载完之后，会立即触发回调函数
$(function(){
	login.checkAdminCode();
	login.checkpwd();
	login.checkValicode();
	login.clickBtn();
});

//校验账号
login.checkAdminCode=function(){
	//给账号输入框绑定焦点失去事件
	$("#adminCode").blur(function(){
		$("#adminCodeMsg").html("");
		var code=$("#adminCode").val();
		if(code.trim().length==0||code==null){
			$("#adminCodeMsg").html("不能为空");
			return;
		}
		var reg=/^[a-zA-Z0-9_]{5,10}$/;
		var flag=reg.test(code);
		if(flag){
			//校验成功
			adminCodeFlag=true;
			$("#adminCodeMsg").html("");
		}else{
			//校验失败
			adminCodeFlag=false;0
			$("#adminCodeMsg").html("5-10的数字、字母、下划线");
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
			adminPwdFlag=true;
			$("#pwdMsg").html("");
		}else{
			//校验失败
			adminPwdFlag=false;
			$("#pwdMsg").html("5-10的数字、字母、下划线");
		}
	});
}

//给验证码输入框绑定焦点失去事件
login.checkValicode=function(){
	$("#valicode").blur(function(){
		var valicode=this.value;
		if(valicode==null||valicode.trim().length==0){
			valicodeFlag=false;
			$("#valicodeMsg").html("不能为空");
			return;
		}
		$.ajax({
			"url":"checkValicode.action",
			"type":"post",
			"data":"valicode="+valicode,
			"dataType":"json",
			"success":function(data){
				//data--->js对象
				console.log(data);
				if(data){
					//校验成功
					valicodeFlag=true;
					$("#valicodeMsg").html("正确");
				}else{
					//校验失败
					valicodeFlag=false;
					$("#valicodeMsg").html("验证码错误");
				}
			},
			"error":function(){alert("错误")}
		});
	});
}
//给链接绑定点击事件
login.clickBtn=function(){
	$(".login_button a").click(function(){
		//调用表单的submit函数
		if(adminCodeFlag&&adminPwdFlag&&valicodeFlag){
			$("form").submit();
		}
	});
}

















