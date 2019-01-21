<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>注册</title>
   <script type="text/javascript" src="/SpringMyBatisDay10_01/js/jquery-1.11.1.js"></script>
   <script type="text/javascript" src="/SpringMyBatisDay10_01/js/prototype-1.6.0.3.js"></script>
   <script type="text/javascript">
   		function check_email1(){
   			//客户端
   				//非空检测
   				
   				//格式检测
   			
   			//服务器端
   			$.ajax({
   			"url":"/SpringMyBatisDay10_01/test/testFive.do",
   				"data":"email="+$("#email").val(),
   				"type":"post",
   				"dataType":"json",
   				"success":function(data){
   					console.log(data);
   					alert(data);
   					alert(data[2].username);
   				},
   				"error":function(){
   					
   				}
   			});
   		}
   		
   		function check_email2(){
   			var xhr=null;
   			if(window.XMLHttpRequest){
   				xhr=new XMLHttpRequest();
   			}else{
   				xhr=new ActiveXObject("Microsoft.XMLHttp");
   			}
   			xhr.open("get","/SpringMyBatisDay10_01/test/testTwo.do",true);
   			xhr.onreadystatechange=function(){
   				if(xhr.readyState==4){
   					var data=xhr.responseText;
   					var da_json=data.evalJSON();
   					alert(da_json.name);
   					console.log(data);
   				}
   			};
   			xhr.send(null);
   		}
   		
   		function check_emai3(){
   			var xhr=null;
   			if(window.XMLHttpRequest){
   				xhr=new XMLHttpRequest();
   			}else{
   				xhr=new ActiveXObject("Microsoft.XMLHttp");
   			}
   			xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
   			xhr.open("post","/SpringMyBatisDay10_01/test/testThree.do?ds=12",true);
   			xhr.onreadystatechange=function(){
   				if(xhr.readyState==4){
   					var str=xhr.responseText;
   					var data=str.evalJSON();
   					console.log(data);
   				}
   			}
   			xhr.send();
   		}
   		function check_email(){
   			$.post("/SpringMyBatisDay10_01/test/testThree.do",function(data){
   				alert(data);
   				console.log(data);
   			},"json");
   		}
   </script>
  </head>
  
  <body>
    邮箱：<input type="text" id="email" onblur="check_email();"/>
  </body>
</html>
