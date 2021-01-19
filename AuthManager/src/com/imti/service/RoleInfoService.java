package com.imti.service;

import java.util.List;
import java.util.Map;

import com.imti.model.RoleInfo;

import net.sf.json.JSONArray;

/**@文件名: RoleInfoService.java
 * @类功能说明: 处理层角色接口
 * @作者: DuYongGang
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月8日下午2:52:02
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月8日下午2:52:02</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface RoleInfoService {
	
	/**
	 * @方法名: findAllRoleInfo
	 * @方法说明: 处理层查询角色接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月9日上午9:09:32
	 * @param user_id
	 * @return: JSONArray
	 */
	public JSONArray findAllRoleInfoForUser(int user_id);
	
	
	/**
	 * @方法名: findAllRoleInfo
	 * @方法说明: 处理层查询接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月10日下午10:53:37
	 * @param map
	 * @return
	 * @return: List<RoleInfo>
	 */
	
	public List<RoleInfo> findAllRoleInfo(Map<String,Object> map);
	
	/**
	 * @方法名: findAllRoleInfoCount
	 * @方法说明: 处理层查询角色条数接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月9日上午9:10:05
	 * @param map
	 * @return: int
	 */
	public int findAllRoleInfoCount(Map<String, Object> map);
	
	/**
	 * @方法名: findroleNameIsExist
	 * @方法说明: 判断角色名是否存在接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月11日上午10:30:18
	 * @param roleName
	 * @return
	 * @return: int
	 */
	public int findroleNameIsExist(String roleName);
	
	/**
	 * @方法名: addRoleInfo
	 * @方法说明: 新增
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月11日上午10:30:31
	 * @param roleInfo
	 * @return
	 * @return: int
	 */
	public int addRoleInfo(RoleInfo roleInfo);
	
	/**
	 * @方法名: updateRoleInfo
	 * @方法说明: 修改
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月11日上午10:30:46
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
	 * @日期: 2021年1月11日上午10:31:07
	 * @param roleIds
	 * @return
	 * @return: int
	 */
	public int deleteRoleInfo(String roleIds);
}
