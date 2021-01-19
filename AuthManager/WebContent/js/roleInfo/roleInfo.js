var addUrl="../../roleInfo/addRoleInfo.action";
var updateUrl="../../roleInfo/updateRoleInfo.action";
var currentUrl="";

//点击角色触发事件
function searchRoleInfo(){
	var s_roleName=$("#s_roleName").val();			//搜索框查询及模糊查询数据网格加载
	$("#dgRoleInfo").datagrid("load",{
		s_roleName:s_roleName
	});
}

//点击添加按钮触发事件
function openRoleInfoAddDialog(){
	$("#role_name").removeAttr("disabled",true); 	//取消锁定
	$("#fmRoleInfo").form("enableValidation");		//启用验证
	$("#dlgRoleInfo").dialog("open").dialog("setTitle","新增角色");
	currentUrl=addUrl;
}

//光标移开用户名文本框触发事件
$("#role_name").blur(function(){
	var roleName=$("#role_name").val();
	$.ajax({
		url:"../../roleInfo/findroleNameIsExist.action",
		data:{roleName:roleName},
        type:"post",
        dataType:"json",
        success:function(result){
            if(result.msg){
            	$.messager.alert("系统提示","角色名<span style='color:red;font-size:20px'>"+roleName+"</span>已存在，请重新输入该数据");
            	$("#role_name").val();
            }
        }
	});
});
//点击保存按钮触发事件
function saveRoleInfo(){
	$("#fmRoleInfo").form("submit",{	 
		  url:currentUrl,
		  onSubmit:function(){
			  var isValid=$(this).form('validate');
			  return isValid;
		  },
		success:function(result){
			var result=eval("("+result+")");
			if(result.msg){
				closeRoleInfoDialog();
				$("#fmRoleInfo").form("enableValidation");		//启用验证
				$("#role_name").removeAttr("disabled",true);	//取消锁定
				$("#dgRoleInfo").datagrid("reload");			//加载完成之后自动刷新
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
function closeRoleInfoDialog(){
	$("#fmRoleInfo").form("clear");
	$("#dlgRoleInfo").dialog("close");
}

//点击修改按钮触发事件
function openRoleInfoModifyDialog(){
	var rows=$("#dgRoleInfo").datagrid("getSelections");
	if(rows.length!=1){
		  $.messager.alert("系统提示","请选择一行需要修改的数据","error");
		  return false;
	  }
	currentUrl=updateUrl;
	$("#fmRoleInfo").form("disableValidation");	//禁用验证
	$("#role_name").attr("disabled",true);      //锁定用户名	  
	$("#fmRoleInfo").form("load",rows[0]);
	$("#dlgRoleInfo").dialog("open").dialog("setTitle","修改角色信息");
}

//点击删除按钮触发事件
function deleteRoleInfo(){
	var rows=$("#dgRoleInfo").datagrid("getSelections");
	if(rows.length<1){
		$.messager.alert("系统提示","请至少选择一条需要删除的数据","error");
		return false;
	}
	$.messager.confirm("系统提示","您确定要删除选中的<span style='color:red;font-size:15px'>"+rows.length+"条</span>数据码？",function(r){
		if(r){
			var arrayIds=new Array();
			$.each(rows,function(index,row){
				arrayIds.push(row.role_id);
			});
			var roleIds=arrayIds.toString();
			
			$.ajax({
				url:"../../roleInfo/deleteRoleInfo.action",
				type:"post",
    		    data:{roleIds:roleIds},
    		    dataType:"json",
				success:function(result){
					if(result.msg){
						$("#dgRoleInfo").datagrid("reload");			//加载完成之后自动刷新
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

//分配权限
function roleInfoMenu(){
	var roleRows=$("#dgRoleInfo").datagrid("getSelections");
	if(roleRows.length!=1){
		$.messager.alert("系统提示","请选择一个角色进行授权！","warning");
		return false;
	}
	
	var roleId=roleRows[0].role_id;
	$.ajax({
		url:"../../menuInfo/findAllMenuInfoByRoleId.action",
		type:"post",
		data:{roleId:roleId},
		dataType:"json",
		success:function(result){
			$("#tree").tree({		//加载到tree中
				data:result,
				lines:true,
				checkbox:true,		//添加复选框
				cascadeCheck:false,	//取消级联关系
				onLoadSuccess:function(node,param){	//onBeforeLoad加载数据请求发出之前触发或onLoadSuccess数据加载成功时触发
					$("#tree").tree("expandAll")	//展开所有节点
				},
				onCheck:function(node,checked){		//获取当前节点的父节点或子节点
					if(checked){
						var nodeParent=$("#tree").tree("getParent",node.target);
						if(nodeParent==null){}
						else{
							$("#tree").tree("check",nodeParent.target);		//当当前节点拥有父节点的时候选中
						}
						
					}else{
						var nodeChildrens=$("#tree").tree("getChildren",node.target);
						for(var i=0;i<nodeChildrens.length;i++){
							$("#tree").tree("uncheck",nodeChildrens[i].target);
						}
					}
				}
			});
			
		}
	});
	
	$("#dlgMenuInfo").dialog("open").dialog("setTitle","给角色授权");
	
}

//点击关闭按钮触发事件
function closeRoleAndMenu(){
	$("#dlgMenuInfo").dialog("close");
}

//点击保存按钮触发事件
function saveRoleAndMenu(){
	var nodes=$("#tree").tree("getChecked");
	if(nodes.length==0){
		$.messager.alert("系统提示","请至少选择一个权限！","warning");
		return false;
	}
	
	var arrayNodes=new Array();
	$.each(nodes,function(index,node){
		arrayNodes.push(node.id);
	});
	var menuIds=arrayNodes.toString();
	
	var roleRows=$("#dgRoleInfo").datagrid("getSelections");
	var role_id=roleRows[0].role_id;
	
	$.ajax({
		url:"../../menuInfo/saveRoleAndMenu.action",
		type:"post",
		data:{role_id:role_id,menuIds:menuIds},
		dataType:"json",
		success:function(result){
			if(result.msg){
				closeRoleAndMenu();
				$("#dgRoleInfo").datagrid("reload");
				$.messager.alert("系统提示","授权成功！","info");
			}else{
				$.messager.alert("系统提示","授权失败！","error");
			}
		}
	})
}