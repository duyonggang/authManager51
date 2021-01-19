package com.imti.dao;

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

/**@�ļ���: UserInfoDao.java
 * @�๦��˵��: �û��־ò�dao�ӿ�
 * @����: DuYongGang
 * @Email: 2509634442@qq.com
 * @����: 2021��1��4������3:54:27
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: DuYongGang</li> 
 * 	 <li>����: 2021��1��4������3:54:27</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface UserInfoDao {
	/**
	 * @������: login
	 * @����˵��: �û��־ò��¼�ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��4������4:16:56
	 * @param userInfo
	 * @return: UserInfo
	 */
	
	public UserInfo login(UserInfo userInfo);
	
	/**
	 * @������: findAllUserInfo
	 * @����˵��: �û��־ò��ѯ�ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��6������5:48:47
	 * @return: List<UserInfo>
	 */
	public List<UserInfo> findAllUserInfo();
	
	/**
	 * @������: findAllUserInfo
	 * @����˵��: �û��־ò�ģ����ѯ�ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��6������5:49:21
	 * @param map
	 * @return: List<UserInfo>
	 */
	
	public List<UserInfo> findAllUserInfo(Map<String,Object> map);
	
	/**
	 * @������: findAllUserInfoCount
	 * @����˵��: �û��־ò��ҳ������ѯ�ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��6������5:50:27
	 * @param map
	 * @return: int
	 */
	public int findAllUserInfoCount(Map<String,Object> map);
	
	/**
	 * @������: findUserNameIsExist
	 * @����˵��: �û��־ò��ж��û����Ƿ���ڽӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��6������6:23:53
	 * @param userName
	 * @return: int
	 */
	public int findUserNameIsExist(String userName);
	
	/**
	 * @������: addUserInfo
	 * @����˵��: �û��־ò������ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��6������10:29:31
	 * @param userInfo
	 * @return: int
	 */
	public int addUserInfo(UserInfo userInfo);
	
	/**
	 * @������: findPasswordByUserId
	 * @����˵��: �û��־ò��޸�ǰͨ���û�id�ҵ��û�����ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��7������11:10:38
	 * @param user_id
	 * @return: String
	 */
	public String findPasswordByUserId(int user_id);
	
	/**
	 * @������: updateUserInfo
	 * @����˵��: �û��־ò��޸Ľӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��7������11:11:49
	 * @param userInfo
	 * @return: int
	 */
	public int updateUserInfo(UserInfo userInfo);
	
	/**
	 * @������: deleteUserInfo
	 * @����˵��:  �û��־ò�ɾ���ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��7������11:12:38
	 * @param user_id
	 * @return: int
	 */
	public int deleteUserInfo(int user_id);
	
	/**
	 * @������: insertUserAndRole
	 * @����˵��: ��Ȩ
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��13������10:01:09
	 * @param map
	 * @return
	 * @return: int
	 */
	public int insertUserAndRole(Map<String,Object> map);
	
	/**
	 * @������: deleteUserOwerRoleByUid
	 * @����˵��: ����Ȩ��
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��13������10:01:31
	 * @param user_id
	 * @param roleIds
	 * @return
	 * @return: int
	 */
	public int deleteUserOwerRoleByUid(int user_id);

}
