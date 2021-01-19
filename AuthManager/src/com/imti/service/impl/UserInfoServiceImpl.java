package com.imti.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imti.dao.UserInfoDao;
import com.imti.model.UserInfo;
import com.imti.service.UserInfoService;
import com.imti.util.Md5;
import com.imti.util.UUIDUtil;

/**@文件名: UserInfoServiceImpl.java
 * @类功能说明: 用户处理层service实现类
 * @作者: DuYongGang
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月4日下午4:21:05
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月4日下午4:21:05</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;	//将持久层dao接口引入service实现类

	
	/**
	 * 用户处理层登录实现
	 */
	@Override
	public UserInfo login(UserInfo userInfo) {
		return userInfoDao.login(userInfo);
	}
	
	/**
	 * 用户处理层查询实现
	 */
	@Override
	public List<UserInfo> findAllUserInfo(Map<String,Object> map) {
		return userInfoDao.findAllUserInfo(map);
	}

	/**
	 * 用户处理层分页条数查询实现
	 */
	@Override
	public int findAllUserInfoCount(Map<String, Object> map) {
		return userInfoDao.findAllUserInfoCount(map);
	}

	/**
	 * 用户处理层判断用户名是否存在实现
	 */
	@Override
	public int findUserNameIsExist(String userName) {
		return userInfoDao.findUserNameIsExist(userName);
	}

	/**
	 * 用户处理层新增实现
	 */
	@Override
	public int addUserInfo(UserInfo userInfo) {
		userInfo.setUser_code(UUIDUtil.getUUID());
		return userInfoDao.addUserInfo(userInfo);
	}

	/**
	 * 用户处理层修改实现
	 */
	@Override
	public int updateUserInfo(UserInfo userInfo) {
			String user_pwd=userInfoDao.findPasswordByUserId(userInfo.getUser_id());
			if(!user_pwd.equals(userInfo.getUser_pwd())){
				userInfo.setUser_pwd(Md5.MD5(userInfo.getUser_pwd())+userInfo.getUser_name());
			}
		return userInfoDao.updateUserInfo(userInfo);
		
	}

	/**
	 * 用户处理层删除实现
	 */
	@Override
	public int deleteUserInfo(String userIds) {
		String strs[]=userIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			result+=userInfoDao.deleteUserInfo(Integer.parseInt(strs[i]));
		}
		return result;
	}

	@Override
	public int insertUserAndRole(int user_id, String roleIds) {
		userInfoDao.deleteUserOwerRoleByUid(user_id);			//回收权限
		if("".equals(roleIds)) {
			return 1;
		}
		String strs[]=roleIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("user_id", user_id);
			map.put("role_id", Integer.parseInt(strs[i]));
			result+=userInfoDao.insertUserAndRole(map);
		}
		return result;
	}

	/*@Override
	public int deleteUserOwerRoleByUid(int user_id, String roleIds) {
		//
		String strs[]=roleIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("user_id", user_id);
			map.put("role_id", Integer.parseInt(strs[i]));
			result+=userInfoDao.deleteUserOwerRoleByUid(user_id);
		}
		return result;
	}*/
	
}
