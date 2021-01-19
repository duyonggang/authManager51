package com.imti.dao;

import java.util.List;
import java.util.Map;

import com.imti.model.MenuInfo;

/**
 * @文件名: MenuInfoDao.java
 * @类功能说明: 
 * @作者: DuYongGang
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月6日上午8:53:20
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月6日上午8:53:20</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface MenuInfoDao {
	/**
	 * @方法名: findMenuInfoByParentId
	 * @方法说明: 菜单持久层接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月6日上午8:41:08
	 * @param map
	 * @return
	 * @return: List<MenuInfo>
	 */

	public List<MenuInfo> findMenuInfoByParentId(Map<String,Object> map);
	
	public List<String> getCurrentUserOwnMenus(int user_id);
	
	public List<MenuInfo> findAllMenuInfoByRoleId(Map<String,Object> map);
	
	public List<Integer> findRoleOwnerMenuByRoleId(int role_id);
	
	public int deleteRoleOldMenuByRoleId(int role_id);
	
	public int addRoleAndMenu(Map<String,Object> map);
	
	public List<MenuInfo> findAllMenuInfo(int parentId);
	
	public int addMenuInfo(MenuInfo menuInfo);
	
	public int updateMenuInfo(MenuInfo menuInfo);
	
	public int findMenuNameIsExist(String menuName);
	
	public int deleteMenuInfo(int menu_id);
	
	public MenuInfo findMenuByid(Integer menuIds);

}
