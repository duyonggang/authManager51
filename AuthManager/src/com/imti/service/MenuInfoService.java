package com.imti.service;

import java.util.List;

import com.imti.model.MenuInfo;

import net.sf.json.JSONArray;

/**
 * @文件名: MenuInfoService.java
 * @类功能说明: 
 * @作者: DuYongGang 
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月6日上午8:51:00
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月6日上午8:51:00</li> 
 *	 <li>内容: </li>
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
