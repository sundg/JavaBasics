<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
    	
    	<script type="text/javascript" src="/SpringMyBatisDay05_01/js/prototype-1.6.0.3.js"></script>
    	<script type="text/javascript" src="/SpringMyBatisDay05_01/js/jquery-1.11.1.js"></script>
    	<script type="text/javascript" src="/SpringMyBatisDay05_01/js/login.js"></script>
    	</head>
    <body class="login">
        <div class="login_box">
        <form method="post" action="login.do">
            <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input id="username" name="username" type="text" class="width150" /></td>
                    <td class="login_error_info"><span id="usernameMsg" class="required"></span></td>
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input id="pwd" name="password" type="password" class="width150" /></td>
                    <td><span id="pwdMsg" class="required"></span></td>
                </tr>
                <tr>
                    <td class="login_info">验证码：</td>
                    <td class="width70"><input id="valicode" name="valicode" type="text" class="width70" /></td>
                    <td><img src="/SpringMyBatisDay05_01/login/valicode.do" onclick="this.src='/SpringMyBatisDay05_01/login/valicode.do?f='+new Date().getTime()" alt="验证码" title="点击更换" /></td>  
                    <td><span id="valicodeMsg" class="required"></span></td>              
                </tr>            
                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                        <a href="javascript:;"><img src="../images/login_btn.png" /></a>
                    </td>    
                    <td>
                    	<span class="required">${message }</span>
                    	<input id="rightCode" value="${rightCode}"/>
                    </td> 
                             
                </tr>
            </table>
            </form>
        </div>
    </body>
</html>
