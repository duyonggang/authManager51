package com.imti.dao;

import java.util.List;
import java.util.Map;

import com.imti.model.MenuInfo;

/**
 * @�ļ���: MenuInfoDao.java
 * @�๦��˵��: 
 * @����: DuYongGang
 * @Email: 2509634442@qq.com
 * @����: 2021��1��6������8:53:20
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: DuYongGang</li> 
 * 	 <li>����: 2021��1��6������8:53:20</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface MenuInfoDao {
	/**
	 * @������: findMenuInfoByParentId
	 * @����˵��: �˵��־ò�ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��6������8:41:08
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
