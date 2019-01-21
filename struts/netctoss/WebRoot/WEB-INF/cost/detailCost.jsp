<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>学码思－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />       
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.png" alt="logo" class="left"/>
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
            <s:form  cssClass="main_form" theme="simple">
                <div class="text_info clearfix"><span>资费ID：</span></div>
                <div class="input_info">
                <s:textfield cssClass="readonly" readonly="true" name="cost.id"></s:textfield>
                </div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info">
                <s:textfield cssClass="readonly" readonly="true" name="cost.name"></s:textfield>
                </div>
                <div class="text_info clearfix"><span>资费状态：</span></div>
                <div class="input_info">
                    <s:select list="#{'0':'开通','1':'暂停','2':'删除'}" cssClass="readonly" disabled="true" name="cost.status" ></s:select>                       
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info fee_type">
                    <s:radio list="#{'1':'包月','2':'套餐','3':'计时'}" disabled="true" name="cost.costtype"></s:radio>
                </div>
                <div class="text_info clearfix"><span>基本时长：</span></div>
                <div class="input_info">
                    <s:textfield cssClass="readonly" readonly="true" name="cost.base_duration"></s:textfield>
                    <span>小时</span>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info">
                    <s:textfield cssClass="readonly" readonly="true" name="cost.base_cost"></s:textfield>
                    <span>元</span>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                    <s:textfield cssClass="readonly" readonly="true" name="cost.unit_cost"></s:textfield>
                    <span>元/小时</span>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info">
                <s:textfield cssClass="readonly" readonly="true" name="cost.ctime"></s:textfield>
                </div>      
                <div class="text_info clearfix"><span>启动时间：</span></div>
                <div class="input_info">
                <s:textfield cssClass="readonly" readonly="true" name="cost.stime"></s:textfield>
                </div>      
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <s:textarea cssClass="width300 height70 readonly" readonly="true" name="cost.description"></s:textarea>
                </div>                    
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='feelist.action?page=${page}';" />
                </div>
            </s:form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
        </div>
    </body>
</html>
