package com.imti.dao;
/**@文件名: RoleInfoDao.java
 * @类功能说明:  角色授权持久层接口
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月7日下午6:58:18
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月7日下午6:58:18</li> 
 *	 <li>内容: </li>
 * </pre>
 */

import java.util.List;
import java.util.Map;

import com.imti.model.RoleInfo;

public interface RoleInfoDao {
	/**
	 * @方法名: findAllRoleInfoForUser
	 * @方法说明: 角色持久层查询接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月8日上午12:13:58
	 * @param 
	 * @return: List<RoleInfo>
	 */
	public List<RoleInfo> findAllRoleInfoForUser();
	
	/**
	 * @方法名: findUserOwerRolesByUId
	 * @方法说明: 当前用户所拥有的角色
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月9日上午9:51:58
	 * @param user_id
	 * @return: List<Integer>
	 */
	public List<Integer> findUserOwerRolesByUId(int user_id);
	
	/**
	 * @方法名: findAllRoleInfo
	 * @方法说明: 角色持久层模糊查询接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月10日下午10:47:13
	 * @param map
	 * @return
	 * @return: List<RoleInfo>
	 */
	
	public List<RoleInfo> findAllRoleInfo(Map<String,Object> map);
	
	
	
	/**
	 * @方法名: findAllRoleInfoCount
	 * @方法说明: 查询所有角色信息分页
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月8日上午12:14:20
	 * @param map
	 * @return: int
	 */
	public int findAllRoleInfoCount(Map<String, Object> map);
	
	
	/**
	 * @方法名: findroleNameIsExist
	 * @方法说明: 用户持久层判断角色名是否存在接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月11日上午10:28:22
	 * @param roleName
	 * @return
	 * @return: int
	 */
	public int findroleNameIsExist(String roleName);
	
	/**
	 * @方法名: addRoleInfo
	 * @方法说明:添加
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月11日上午10:28:48
	 * @param roleInfo
	 * @return
	 * @return: int
	 */
	public int addRoleInfo(RoleInfo roleInfo);
	
	/**
	 * @方法名: updateRoleInfo
	 * @方法说明:修改 
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月11日上午10:29:15
	 * @param roleInfo
	 * @return
	 * @return: int
	 */
	public int updateRoleInfo(RoleInfo roleInfo);
	
	/**
	 * @方法名: deleteRoleInfo
	 * @方法说明: 删除
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月11日上午10:29:35
	 * @param role_id
	 * @return
	 * @return: int
	 */
	public int deleteRoleInfo(int role_id);
}
