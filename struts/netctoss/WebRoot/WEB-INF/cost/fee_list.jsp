<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <link type="text/css" rel="stylesheet" href="/netctoss/styles/jquery.page.css"/>
        <script type="text/javascript" src="/netctoss/js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="/netctoss/js/my.js"></script>
        <script type="text/javascript" src="/netctoss/js/jquery.page.js"></script>
        <script type="text/javascript" src="/netctoss/js/cost.js"></script>
        <script language="javascript" type="text/javascript">
            //排序按钮的点击事件

            //启用
            function startFee(id,page) {
                var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
                //document.getElementById("operate_result_info").style.display = "block";
                if(r){
                	window.location.href="start.action?id="+id+"&page="+page;
                }
            }
            //暂停
            function pauseFee(id,page){
            	 var r = window.confirm("确定要暂停此资费吗？");
                //document.getElementById("operate_result_info").style.display = "block";
                if(r){
                	window.location.href="stop.action?id="+id+"&page="+page;
                }
            }
            //删除
            function deleteFee(id) {
                var r = window.confirm("确定要删除此资费吗？");
                //document.getElementById("operate_result_info").style.display = "block";
                if(r){
                	this.location.href="del.action?id="+id;
                }
            }
        </script>        
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.png" alt="logo" class="left"/>
			<span>当前账号：<b>scott</b></span>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">                        
            <ul id="menu">
                <li><a href="../index.html" class="index_off"></a></li>
                <li><a href="../role/role_list.html" class="role_off"></a></li>
                <li><a href="../admin/admin_list.html" class="admin_off"></a></li>
                <li><a href="../fee/fee_list.html" class="fee_on"></a></li>
                <li><a href="../account/account_list.html" class="account_off"></a></li>
                <li><a href="../service/service_list.html" class="service_off"></a></li>
                <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
                <li><a href="../report/report_list.html" class="report_off"></a></li>
                <li><a href="../user/user_info.html" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
            </ul>            
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--排序-->
                <div class="search_add">
                    <div>
                        <input type="button" value="月租" data-colm="base_cost" class="sort_asc" onclick="cost.sort(this);" />
                        <input type="button" value="基费" class="sort_asc" onclick="cost.sort(this);" />
                        <input type="button" value="时长" data-colm="base_duration" class="sort_asc" onclick="cost.sort(this);" />
                    </div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='fee_add.action';" />
                </div> 
                <!--启用操作的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>    
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th>资费ID</th>
                            <th class="width100">资费名称</th>
                            <th>基本时长</th>
                            <th>基本费用</th>
                            <th>单位费用</th>
                            <th>创建时间</th>
                            <th>开通时间</th>
                            <th class="width50">状态</th>
                            <th class="width200"></th>
                        </tr>   
                    </table>
                    <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                    </p>
                </div>
                <!--分页-->
                <div class="tcdPageCode">
                
                </div>
                <script>
    			$(".tcdPageCode").createPage({
			        pageCount:${totalPages},
			        current:1,
			        backFn:function(p){
						$("#current").val(p);
			        	cost.toPage(p);
			           
			        }
			    });
				</script>
				<input type="hidden" id="current" value="1"/>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
        </div>
    </body>
</html>
