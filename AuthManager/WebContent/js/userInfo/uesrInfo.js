var addUrl="../../userInfo/addUserInfo.action";
var updateUrl="../../userInfo/updateUserInfo.action";
var currentUrl="";

//点击菜单触发事件
function searchUserInfo(){
	var s_userName=$("#s_userName").val();			//搜索框查询及模糊查询数据网格加载
	$("#dgUserInfo").datagrid("load",{
		s_userName:s_userName
	});
}

//对话框打开设置标题
function openUserInfoAddDialog(){
	$("#user_name").removeAttr("disabled",true);	//取消锁定
	$("#fmUserInfo").form("enableValidation");		//启用验证
	$("#dlgUserInfo").dialog("open").dialog("setTitle","新增用户");
	currentUrl=addUrl;
}

//光标移开用户名文本框触发事件
$("#user_name").blur(function(){
	var userName=$("#user_name").val();
	$.ajax({
		url:"../../userInfo/findUserNameIsExist.action",
		data:{userName:userName},
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.msg){
				$.messager.alert("系统提示","该用户名<span style='color:red;font-size:15px'>"+userName+"</span>已存在,请重新输入");
				$("#user_name").val();
			}
		}
	});
})

//点击添加按钮触发事件
function saveUserInfo(){
	$("#fmUserInfo").form("submit",{
		url:currentUrl,
		onSubmit:function(){
			var isValid=$(this).form('validate');
			return isValid;
		},
		success:function(result){
			var result=eval("("+result+")");
			if(result.msg){
				closeUserInfoDialog();
				$("#user_name").removeAttr("disabled",true);	//取消锁定
				$("#fmUserInfo").form("enableValidation");		//启用验证
				$("#dgUserInfo").datagrid("reload");			//加载完成之后自动刷新
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
function closeUserInfoDialog(){
	$("#fmUserInfo").form("clear");
	$("#dlgUserInfo").dialog("close");
}

//点击修改按钮触发事件
function openUserInfoModifyDialog(){
	var rows=$("#dgUserInfo").datagrid("getSelections");
	if(rows.length!=1){
		$.messager.alert("系统提示","请选择一条需要修改的数据","error");
		return false;
	}
	currentUrl=updateUrl;
	$("#fmUserInfo").form("disableValidation");	//禁用验证
	$("#user_name").attr("disabled",true);		//锁定用户名
	$("#fmUserInfo").form("load",rows[0]);	
	$("#dlgUserInfo").dialog("open").dialog("setTitle","修改用户信息");
}

//点击删除按钮触发事件
function deleteUserInfo(){
	var rows=$("#dgUserInfo").datagrid("getSelections");
	if(rows.length<1){
		$.messager.alert("系统提示","请至少选择一条需要删除的数据","error");
		return false;
	}
	$.messager.confirm("系统提示","您确定要删除选中的<span style='color:red;font-size:15px'>"+rows.length+"条</span>数据码？",function(r){
		if(r){
			var arrayIds=new Array();
			$.each(rows,function(index,row){
				arrayIds.push(row.user_id);
			});
			var userIds=arrayIds.toString();
			
			$.ajax({
				url:"../../userInfo/deleteUserInfo.action",
				type:"post",
				data:{userIds:userIds},
				dataType:"json",
				success:function(result){
					if(result.msg){
						$("#dgUserInfo").datagrid("reload");			//加载完成之后自动刷新
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

//点击授权触发事件
function userInfoRole(){
	var rows=$("#dgUserInfo").datagrid("getSelections");
	if(rows.length!=1){
		$.messager.alert("系统提示","请选择一条需要授权的用户","error");
		return false;
	}
	
	$.ajax({
		url:"../../roleInfo/findAllRoleInfoForUser.action",
		type:"post",
		data:{user_id:rows[0].user_id},
		dataType:"json",
		success:function(result){
			$("#dgroleInfo").datagrid({
				onLoadSuccess:function(data){
					$.each(data.rows,function(index,row){
						if(row.checked){
							$("#dgroleInfo").datagrid("selectRow",index);
						}
					});
				},
				data:result.rows
			});
		}
	})
	$("#dlgRoleInfo").dialog("open").dialog("setTitle","用户授权");
}

//角色授权
function saveUserAndRole(){
	var roleRows=$("#dgroleInfo").datagrid("getSelections");
	/*if(roleRows.length<1){
		$.messager.alert("系统提示","请至少选择一个角色给用户授权","error");
		return false;
	}*/
	var userRow=$("#dgUserInfo").datagrid("getSelected");
	var userId=userRow.user_id;
	var roleIdArray=new Array()
	$.each(roleRows,function(index,row){
		roleIdArray.push(row.role_id);
	});
	var roleIds=roleIdArray.toString();
	$.ajax({
		url:"../../userInfo/insertUserAndRole.action",
		type:"post",
		data:{userId:userId,roleIds:roleIds},
		dataType:"json",
		success:function(result){
			if(result.msg){
				$("#dgUserInfo").datagrid("reload");	//加载完成之后自动刷新
				closeUserAndRole();
				$.messager.alert("系统提示","授权成功","info");
			}else{
				$.messager.alert("系统提示","授权失败","error");
			}
		},
		error:function(){
			$.messager.alert("系统提示","系统繁忙，请稍后操作","error");
		}
	})
}

//点击授权关闭按钮触发事件
function closeUserAndRole(){
	
	$("#dgroleInfo").datagrid("unselectAll");
	$("#dlgRoleInfo").dialog("close");
}

//回收权限
/*function deleteUserOwerRoleByUid(){
	var rows=$("#dgUserInfo").datagrid("getSelected");//选中多行需要删除的数据
	var roleRows=$("#dgroleInfo").datagrid("getSelections");
	var userId=rows.user_id;
	
		if(roleRows.length==0){
			$.messager.alert("系统提示","您确定要回收权限吗？","warning");
			return false;
		};
		$.messager.confirm("系统提示","您确认要回收"+roleRows.length+"条权限吗？",function(r){
			if(r){
				var arrayIds=new Array();
				$.each(roleRows,function(index,row){
				arrayIds.push(row.role_id);//想controller传入row数组里的Id
			});
			
			var roleIds=arrayIds.toString();
			
			
			$.ajax({
				url:"../../userInfo/deleteUserOwerRoleByUid.action",
			    type:"post",
			    data:{userId:userId,roleIds:roleIds},
			    dataType:"json",
			    success:function(result){
			    	
			    	if(result.msg){
			    		closeUserAndRoleDialog();
			    		$("#dgUserInfo").datagrid("load");		//刷新数据
			    		$.messager.alert("系统提示","回收成功","info");
			    	}else{
			    		$.messager.alert("系统提示","回收失败","error");
			    	}
			    }
			});
		}
	});

}	

function closeUserAndRoleDialog(){
	$("#dlgRoleInfo").dialog("close");
}
*/





