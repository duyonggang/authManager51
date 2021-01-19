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
 * @�ļ���: MenuInfoServiceImpl.java
 * @�๦��˵��: 
 * @����: DuYongGang
 * @Email: 2509634442@qq.com
 * @����: 2021��1��6������8:55:13
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: DuYongGang</li> 
 * 	 <li>����: 2021��1��6������8:55:13</li> 
 *	 <li>����: </li>
 * </pre>
 */

@Service
public class MenuInfoServiceImpl implements MenuInfoService {

	@Autowired
	private MenuInfoDao menuInfoDao;	//����menuInfoDao�ӿ�
	
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
		if(!"".equals(menuIds)) {		// ���ж��Ƿ��Ǹ��ڵ�
			MenuInfo menuInfo=menuInfoDao.findMenuByid(Integer.parseInt(menuIds));//����Ǹ��ڵ㣬��������һ���ӽڵ�
			result+=menuInfoDao.deleteMenuInfo(Integer.parseInt(menuIds));//�����Ƿ�Ϊ���ڵ㻹���ӽڵ㶼ɾ����
			if("closed".equals(menuInfo.getMenu_state())) {//���ж���һ���ӽڵ��Ƿ�Ϊ���ڵ�
				treeMenuList(Integer.parseInt(menuIds));//����Ǹ��ڵ����treeMenuList����
			}
		}
		return result;//������ǣ���ɾ����ֱ�ӽ���
	}
	
	public void treeMenuList(int pid) {
		List<MenuInfo> findAllMenuInfo=menuInfoDao.findAllMenuInfo(pid);		//�����ڵ��µ��ӽڵ���뼯��
		if (findAllMenuInfo.size()>0) {						//�жϸ��ڵ����Ƿ����ӽڵ�
			for(MenuInfo menu:findAllMenuInfo) {				//ʹ�ó���forѭ������
				menuInfoDao.deleteMenuInfo(menu.getMenu_id());	//ɾ���ӽڵ�
				if("closed".equals(menu.getMenu_state())) {		//���жϣ�Ȼ��ݹ�
					treeMenuList(menu.getMenu_id());
				}
			}
		}
	}

}
