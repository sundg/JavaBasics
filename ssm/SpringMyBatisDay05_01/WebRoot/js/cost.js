var cost={};//设置命名空间

$(function(){
	cost.loadCost(1,null,null);
});
/*
 *给排序按钮绑定点击事件 
 */
var colm;
var sort;
cost.sort=function(btnObj){
	//获取排序字段
	colm=$(btnObj).data("colm");
	console.log(colm);
	//获取当前页
	var page=$("#current").val();
	//获取排序方式
	sort=$(btnObj).attr("class").substring(btnObj.className.lastIndexOf("_")+1);
	console.log(sort);
	 if (btnObj.className == "sort_desc")
		 btnObj.className = "sort_asc";
     else
    	 btnObj.className = "sort_desc";
	 //调用loadCost
	 cost.loadCost(page,colm,sort);
}


//使用ajax对象，向服务器发送请求
cost.loadCost=function(page,colm,sort){
	 $.ajax({
		 "url":"loadData.action",
		 "type":"post",
		 "data":{"page":page,"colm":colm,"sort":sort},
		 "dataType":"json",
		 "success":function(data){
			 console.log(data);
			 cost.showCost(data,page);
		 },
		 "error":function(){alert("系统繁忙!");}
	 });
}



 cost.showCost=function(data,page){
	 $(".mytr").remove();
	$.each(data,function(index,obj){
		console.log(obj);
		var trStr='';
		trStr+='<tr class="mytr">';
		trStr+='<td>'+obj.id+'</td>';
		trStr+='<td><a href="detail.action?id='+obj.id+'&page='+page+'">'+obj.name+'</a></td>';
		trStr+='<td>'+obj.base_duration+'小时</td>';
		trStr+='<td>'+obj.base_cost+'元</td>';
		trStr+='<td>'+obj.unit_cost+'元/小时</td>';
		trStr+='<td>'+obj.ctime+'</td>';
		trStr+='<td>'+obj.stime+'</td>';
		if(obj.status==0){
			trStr+='<td>开通</td>';
		}else{
			trStr+='<td>暂停</td>';
		}
		trStr+='<td>';
			if(obj.status==0){
				//暂停操作
				trStr+='<input type="button" value="暂停" class="btn_pause" onclick="pauseFee('+obj.id+','+page+');" />';
			}else if(obj.status==1){
				//开通操作
				trStr+='<input type="button" value="启用" class="btn_start" onclick="startFee('+obj.id+','+page+');" />';
			}
		//修改操作
		trStr+=' <input type="button" value="修改" class="btn_modify" onclick="location.href=\'modify.action?id='+obj.id+'&page='+page+'\'" />';
		//删除操作
		trStr+='<input type="button" value="删除" class="btn_delete" onclick="deleteFee('+obj.id+');" />';
		trStr+='</td>';
		trStr+='</tr>';
		$("#datalist").append(trStr);
	});
 }


 cost.toPage=function(page){
	 cost.loadCost(page,colm,sort);
 }








