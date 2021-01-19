package com.imti.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imti.dao.MenuInfoDao;
import com.imti.model.MenuInfo;
import com.imti.service.MenuInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * @文件名: MenuInfoServiceImpl.java
 * @类功能说明: 
 * @作者: DuYongGang
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月6日上午8:55:13
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月6日上午8:55:13</li> 
 *	 <li>内容: </li>
 * </pre>
 */

@Service
public class MenuInfoServiceImpl implements MenuInfoService {

	@Autowired
	private MenuInfoDao menuInfoDao;	//引入menuInfoDao接口
	
	@Override
	public JSONArray findMenuInfoByParentId(int parentId,List<String> menuIds) {
		JSONArray jsonArray=this.getMenuInfoByParentId(parentId,menuIds);
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.get("state"))) {
				continue;
			}else {
				jsonObject.put("children", findMenuInfoByParentId(jsonObject.getInt("id"),menuIds));
			}
		}
		return jsonArray;
	}

	public JSONArray getMenuInfoByParentId(int parentId,List<String> menuIds) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("parentId", parentId);
		map.put("menuIds", menuIds);
		List<MenuInfo> menuList=menuInfoDao.findMenuInfoByParentId(map);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<menuList.size();i++) {
			MenuInfo menuInfo=menuList.get(i);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", menuInfo.getMenu_id());
			jsonObject.put("text", menuInfo.getMenu_name());
			jsonObject.put("state", menuInfo.getMenu_state());
			jsonObject.put("iconCls", menuInfo.getMenu_icon());
			
			JSONObject jsonObject1=new JSONObject();
			jsonObject1.put("url", menuInfo.getMenu_url());
			jsonObject.put("attributes", jsonObject1);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	@Override
	public List<String> getCurrentUserOwnMenus(int user_id) {
		return menuInfoDao.getCurrentUserOwnMenus(user_id);
	}

	@Override
	public JSONArray findAllMenuInfoByRoleId(int parentId,int role_id) {
		JSONArray jsonArray=this.getAllMenuInfoByRoleId(parentId,role_id);
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.get("state"))) {
				continue;
			}else {
				jsonObject.put("children", findAllMenuInfoByRoleId(jsonObject.getInt("id"),role_id));
			}
		}
		return jsonArray;
	}
	
	public JSONArray getAllMenuInfoByRoleId(int parentId,int role_id) {
		List<Integer> role_menuIds=menuInfoDao.findRoleOwnerMenuByRoleId(role_id);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("parentId", parentId);
		List<MenuInfo> menuList=menuInfoDao.findAllMenuInfoByRoleId(map);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<menuList.size();i++) {
			MenuInfo menuInfo=menuList.get(i);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", menuInfo.getMenu_id());
			if(role_menuIds.contains(jsonObject.getInt("id"))) {
				jsonObject.put("checked", true);
			}
			jsonObject.put("text", menuInfo.getMenu_name());
			jsonObject.put("state", menuInfo.getMenu_state());
			jsonObject.put("iconCls", menuInfo.getMenu_icon());
			
			JSONObject jsonObject1=new JSONObject();
			jsonObject1.put("url", menuInfo.getMenu_url());
			jsonObject.put("attributes", jsonObject1);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	@Override
	public int saveRoleAndMenu(int role_id, String menuIds) {
		menuInfoDao.deleteRoleOldMenuByRoleId(role_id);
		String strs[]=menuIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("role_id", role_id);
			map.put("menu_id", strs[i]);
			result+=menuInfoDao.addRoleAndMenu(map);
		}
		
		return result;
	}

	@Override
	public JSONArray findAllMenuInfo(int parentId) {
		JSONArray jsonArray=this.getAllMenuInfo(parentId);
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.getString("menu_state"))) {
				continue;
			}else {
				jsonObject.put("children", findAllMenuInfo(jsonObject.getInt("menu_id")));
			}
		}
		return jsonArray;
	}
	
	public JSONArray getAllMenuInfo(int parentId){
		List<MenuInfo> menuList=menuInfoDao.findAllMenuInfo(parentId);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<menuList.size();i++) {
			MenuInfo menuInfo=menuList.get(i);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("menu_id", menuInfo.getMenu_id());
			jsonObject.put("parentId", menuInfo.getParentId());
			jsonObject.put("menu_name", menuInfo.getMenu_name());
			jsonObject.put("menu_state", menuInfo.getMenu_state());
			jsonObject.put("menu_url", menuInfo.getMenu_url());
			jsonObject.put("menu_icon", menuInfo.getMenu_icon());
			jsonObject.put("createTime", menuInfo.getCreateTime());
			jsonObject.put("menu_remark", menuInfo.getMenu_remark());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	@Override
	public int addMenuInfo(MenuInfo menuInfo) {
		menuInfo.setMenu_state("open");
		return menuInfoDao.addMenuInfo(menuInfo);
	}

	@Override
	public int updateMenuInfo(MenuInfo menuInfo) {
		menuInfo.setMenu_state("open");
		return menuInfoDao.updateMenuInfo(menuInfo);
	}

	@Override
	public int findMenuNameIsExist(String menuName) {
		return menuInfoDao.findMenuNameIsExist(menuName);
	}

	@Override
	public int deleteMenuInfo(String menuIds) {
		int result=0;
		if(!"".equals(menuIds)) {		// 先判断是否是父节点
			MenuInfo menuInfo=menuInfoDao.findMenuByid(Integer.parseInt(menuIds));//如果是父节点，遍历他下一层子节点
			result+=menuInfoDao.deleteMenuInfo(Integer.parseInt(menuIds));//不论是否为父节点还是子节点都删除它
			if("closed".equals(menuInfo.getMenu_state())) {//再判断下一层子节点是否为父节点
				treeMenuList(Integer.parseInt(menuIds));//如果是父节点调用treeMenuList方法
			}
		}
		return result;//如果不是，则删除后直接结束
	}
	
	public void treeMenuList(int pid) {
		List<MenuInfo> findAllMenuInfo=menuInfoDao.findAllMenuInfo(pid);		//将父节点下的子节点放入集合
		if (findAllMenuInfo.size()>0) {						//判断父节点下是否有子节点
			for(MenuInfo menu:findAllMenuInfo) {				//使用超级for循环遍历
				menuInfoDao.deleteMenuInfo(menu.getMenu_id());	//删除子节点
				if("closed".equals(menu.getMenu_state())) {		//再判断，然后递归
					treeMenuList(menu.getMenu_id());
				}
			}
		}
	}

}
