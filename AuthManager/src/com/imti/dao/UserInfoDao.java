package com.imti.dao;

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

/**@文件名: UserInfoDao.java
 * @类功能说明: 用户持久层dao接口
 * @作者: DuYongGang
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月4日下午3:54:27
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月4日下午3:54:27</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface UserInfoDao {
	/**
	 * @方法名: login
	 * @方法说明: 用户持久层登录接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月4日下午4:16:56
	 * @param userInfo
	 * @return: UserInfo
	 */
	
	public UserInfo login(UserInfo userInfo);
	
	/**
	 * @方法名: findAllUserInfo
	 * @方法说明: 用户持久层查询接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月6日下午5:48:47
	 * @return: List<UserInfo>
	 */
	public List<UserInfo> findAllUserInfo();
	
	/**
	 * @方法名: findAllUserInfo
	 * @方法说明: 用户持久层模糊查询接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月6日下午5:49:21
	 * @param map
	 * @return: List<UserInfo>
	 */
	
	public List<UserInfo> findAllUserInfo(Map<String,Object> map);
	
	/**
	 * @方法名: findAllUserInfoCount
	 * @方法说明: 用户持久层分页条数查询接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月6日下午5:50:27
	 * @param map
	 * @return: int
	 */
	public int findAllUserInfoCount(Map<String,Object> map);
	
	/**
	 * @方法名: findUserNameIsExist
	 * @方法说明: 用户持久层判断用户名是否存在接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月6日下午6:23:53
	 * @param userName
	 * @return: int
	 */
	public int findUserNameIsExist(String userName);
	
	/**
	 * @方法名: addUserInfo
	 * @方法说明: 用户持久层新增接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月6日下午10:29:31
	 * @param userInfo
	 * @return: int
	 */
	public int addUserInfo(UserInfo userInfo);
	
	/**
	 * @方法名: findPasswordByUserId
	 * @方法说明: 用户持久层修改前通过用户id找到用户密码接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月7日下午11:10:38
	 * @param user_id
	 * @return: String
	 */
	public String findPasswordByUserId(int user_id);
	
	/**
	 * @方法名: updateUserInfo
	 * @方法说明: 用户持久层修改接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月7日下午11:11:49
	 * @param userInfo
	 * @return: int
	 */
	public int updateUserInfo(UserInfo userInfo);
	
	/**
	 * @方法名: deleteUserInfo
	 * @方法说明:  用户持久层删除接口
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月7日下午11:12:38
	 * @param user_id
	 * @return: int
	 */
	public int deleteUserInfo(int user_id);
	
	/**
	 * @方法名: insertUserAndRole
	 * @方法说明: 授权
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月13日上午10:01:09
	 * @param map
	 * @return
	 * @return: int
	 */
	public int insertUserAndRole(Map<String,Object> map);
	
	/**
	 * @方法名: deleteUserOwerRoleByUid
	 * @方法说明: 回收权限
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月13日上午10:01:31
	 * @param user_id
	 * @param roleIds
	 * @return
	 * @return: int
	 */
	public int deleteUserOwerRoleByUid(int user_id);

}
