var addUrl="../../menuInfo/addMenuInfo.action";
var updateUrl="../../menuInfo/updateMenuInfo.action";
var currentUrl="";
//转换图标触发事件
function formatterIcon(value,row,index){
	return "<div class='"+value+"'>&nbsp;</div>";
}

//点击添加按钮触发事件
function openMenuInfoAddDialog(){
	$("#fmMenuInfo").form("enableValidation");	
	var node=$("#treeGridMenuInfo").treegrid("getSelected");
	if(node==null){
		$.messager.alert("系统提示","请选择需要添加的父节点！","warning");
		return false;
	}
	currentUrl=addUrl;
	$("#parentId").val(node.menu_id);
	$("#dlgMenuInfo").dialog("open").dialog("setTitle","添加菜单信息");
}

/*
$("#menu_name").blur(function(){
	var menuName=$("#menu_name").val();
	$.ajax({
		url:"../../menuInfo/findMenuNameIsExist.action",
		data:{menuName:menuName},
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.msg){
				$.messager.alert("系统提示","该用户名<span style='color:red;font-size:15px'>"+menuName+"</span>已存在,请重新输入");
				$("#menu_name").val();
			}
		}
	});
})*/



//点击保存按钮触发事件
function saveMenuInfo(){
	$("#fmMenuInfo").form("submit",{	 
		  url:currentUrl,
		  onSubmit:function(){
			  var isValid=$(this).form('validate');
			  return isValid;
		  },
		success:function(result){
			var result=eval("("+result+")");
			if(result.msg){
				closeMenuInfoDialog();
				$("#treeGridMenuInfo").treegrid("reload");			//加载完成之后自动刷新
				$.messager.alert("系统提示","保存成功","info");
			}else{
				$.messager.alert("系统提示","保存失败","error");
			}
		},
		error:function(){
			$.messager.alert("系统提示","系统繁忙，请稍后操作","error");
		}
	});
	
	currentUrl="";
}

//点击关闭按钮触发事件
function closeMenuInfoDialog(){
	$("#fmMenuInfo").form("clear");
	$("#dlgMenuInfo").dialog("close");
}

//点击修改触发事件
function openMenuInfoModifyDialog(){
	var rows=$("#treeGridMenuInfo").treegrid("getSelections");
	if(rows.length!=1){
		  $.messager.alert("系统提示","请选择需要修改的父节点！","warning");
		  return false;
	  }
	currentUrl=updateUrl;
	$("#fmMenuInfo").form("disableValidation");	//禁用验证
	$("#fmMenuInfo").form("load",rows[0]);
	$("#dlgMenuInfo").dialog("open").dialog("setTitle","修改菜单信息");
}

//点击删除按钮触发事件
function deleteMenuInfo(){
	var rows=$("#treeGridMenuInfo").treegrid("getSelections");
	if(rows.length<1){
		$.messager.alert("系统提示","请至少选择一条需要删除的父节点！","warning");
		return false;
	}
	$.messager.confirm("系统提示","您确定要删除选中的<span style='color:red;font-size:15px'>"+rows.length+"条</span>节点码？",function(r){
		if(r){
			var arrayIds=new Array();
			$.each(rows,function(index,row){
				arrayIds.push(row.menu_id);
			});
			var menuIds=arrayIds.toString();
			
			$.ajax({
				url:"../../menuInfo/deleteMenuInfo.action",
				type:"post",
				data:{menuIds:menuIds},
				dataType:"json",
				success:function(result){
					if(result.msg){
						$("#treeGridMenuInfo").treegrid("reload");		//加载完成之后自动刷新
						$.messager.alert("系统提示","删除成功","info");
					}else{
						$.messager.alert("系统提示","删除失败","error");
					}
				},
				error:function(){
					$.messager.alert("系统提示","系统繁忙，请稍后操作","error");
				}
			})
		}
	})
}
