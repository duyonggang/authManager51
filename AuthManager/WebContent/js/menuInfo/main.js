$(function(){
	$.ajax({
		url:"../menuInfo/findMenuInfoByParentId.action",
		type:"post",
		dataType:"json",
		success:function(result){
			$("#tree").tree({		//加载到tree中
				data:result,
				lines:true,
				onBeforeLoad:function(node,param){	//onBeforeLoad加载数据请求发出之前触发	或onLoadSuccess数据加载成功时触发
					$("#tree").tree("expandAll")	//展开所有节点
				},onClick:function(node){
					if(node.attributes.url!=null){
						if($("#tabs").tabs("exists",node.text)){
							$("#tabs").tabs("select",node.text);
						}else{
							var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%;' src='../html/"+node.attributes.url+"'></iframe>";
							//在id=tabs里面展示
							$("#tabs").tabs("add",{
								title:node.text,
								closable:true,		//显示关闭按钮
								iconCls:node.iconCls,	//显示图标
								content:content
							});
						}
					}
				}
			});
		}
	});
});