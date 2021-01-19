package com.imti.service;

import java.util.List;

import com.imti.model.MenuInfo;

import net.sf.json.JSONArray;

/**
 * @�ļ���: MenuInfoService.java
 * @�๦��˵��: 
 * @����: DuYongGang 
 * @Email: 2509634442@qq.com
 * @����: 2021��1��6������8:51:00
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: DuYongGang</li> 
 * 	 <li>����: 2021��1��6������8:51:00</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface MenuInfoService {

	public JSONArray findMenuInfoByParentId(int parentId,List<String> menuIds);
	
	public List<String> getCurrentUserOwnMenus(int user_id);
	
	public JSONArray findAllMenuInfoByRoleId(int parentId,int role_id);
	
	public int saveRoleAndMenu(int role_id,String menuIds);
	
	public List<MenuInfo> findAllMenuInfo(int parentId);
	
	public int addMenuInfo(MenuInfo menuInfo);
	
	public int updateMenuInfo(MenuInfo menuInfo);
	
	public int findMenuNameIsExist(String menuName);
	
	public int deleteMenuInfo(String menuIds);
}
