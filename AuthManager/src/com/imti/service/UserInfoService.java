package com.imti.service;

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

/**@文件名: UserInfoService.java
 * @类功能说明: 用户处理层service接口
 * @作者: DuYongGang
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月4日下午3:55:59
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月4日下午3:55:59</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface UserInfoService {
	/**
	 * @方法名: login
	 * @方法说明: 用户处理层登录接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月4日下午4:18:26
	 * @param userInfo
	 * @return: UserInfo
	 */
	
	public UserInfo login(UserInfo userInfo);
	
	/**
	 * @方法名: findAllUserInfo
	 * @方法说明: 用户处理层查询接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月6日下午5:18:39
	 * @param map
	 * @return: List<UserInfo>
	 */
	
	public List<UserInfo> findAllUserInfo(Map<String,Object> map);
	
	/**
	 * @方法名: findAllUserInfoCount
	 * @方法说明: 用户处理层分页条数查询接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月6日下午6:30:38
	 * @param map
	 * @return
	 * @return: int
	 */
	public int findAllUserInfoCount(Map<String,Object> map);
	
	/**
	 * @方法名: findUserNameIsExist
	 * @方法说明: 用户处理层判断用户名是否存在接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月6日下午6:29:49
	 * @param userName
	 * @return: int
	 */
	public int findUserNameIsExist(String userName);
	
	/**
	 * @方法名: addUserInfo
	 * @方法说明: 用户处理层新增接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月6日下午10:28:35
	 * @param userInfo
	 * @return: int
	 */
	public int addUserInfo(UserInfo userInfo);
	
	/**
	 * @方法名: updateUserInfo
	 * @方法说明: 用户处理层修改接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月7日下午4:45:13
	 * @param userInfo
	 * @return: int
	 */
	public int updateUserInfo(UserInfo userInfo);
	
	/**
	 * @方法名: deleteUserInfo
	 * @方法说明: 用户处理层删除接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月7日下午11:14:12
	 * @param userIds
	 * @return: int
	 */
	public int deleteUserInfo(String userIds);
	
	/**
	 * @方法名: insertUserAndRole
	 * @方法说明: 用户处理层授权接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月9日上午9:14:43
	 * @param user_id
	 * @param roleIds
	 * @return: int
	 */
	public int insertUserAndRole(int user_id,String roleIds);
	
	/**
	 * @方法名: deleteUserOwerRoleByUid
	 * @方法说明: 回收权限
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月13日上午10:04:18
	 * @param user_id
	 * @param roleIds
	 * @return
	 * @return: int
	 */
	/*public int deleteUserOwerRoleByUid(int user_id,String roleIds);
*/
}
