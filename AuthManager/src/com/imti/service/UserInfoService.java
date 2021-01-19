package com.imti.service;

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

/**@�ļ���: UserInfoService.java
 * @�๦��˵��: �û������service�ӿ�
 * @����: DuYongGang
 * @Email: 2509634442@qq.com
 * @����: 2021��1��4������3:55:59
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: DuYongGang</li> 
 * 	 <li>����: 2021��1��4������3:55:59</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface UserInfoService {
	/**
	 * @������: login
	 * @����˵��: �û�������¼�ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��4������4:18:26
	 * @param userInfo
	 * @return: UserInfo
	 */
	
	public UserInfo login(UserInfo userInfo);
	
	/**
	 * @������: findAllUserInfo
	 * @����˵��: �û�������ѯ�ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��6������5:18:39
	 * @param map
	 * @return: List<UserInfo>
	 */
	
	public List<UserInfo> findAllUserInfo(Map<String,Object> map);
	
	/**
	 * @������: findAllUserInfoCount
	 * @����˵��: �û�������ҳ������ѯ�ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��6������6:30:38
	 * @param map
	 * @return
	 * @return: int
	 */
	public int findAllUserInfoCount(Map<String,Object> map);
	
	/**
	 * @������: findUserNameIsExist
	 * @����˵��: �û�������ж��û����Ƿ���ڽӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��6������6:29:49
	 * @param userName
	 * @return: int
	 */
	public int findUserNameIsExist(String userName);
	
	/**
	 * @������: addUserInfo
	 * @����˵��: �û�����������ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��6������10:28:35
	 * @param userInfo
	 * @return: int
	 */
	public int addUserInfo(UserInfo userInfo);
	
	/**
	 * @������: updateUserInfo
	 * @����˵��: �û�������޸Ľӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��7������4:45:13
	 * @param userInfo
	 * @return: int
	 */
	public int updateUserInfo(UserInfo userInfo);
	
	/**
	 * @������: deleteUserInfo
	 * @����˵��: �û������ɾ���ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��7������11:14:12
	 * @param userIds
	 * @return: int
	 */
	public int deleteUserInfo(String userIds);
	
	/**
	 * @������: insertUserAndRole
	 * @����˵��: �û��������Ȩ�ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��9������9:14:43
	 * @param user_id
	 * @param roleIds
	 * @return: int
	 */
	public int insertUserAndRole(int user_id,String roleIds);
	
	/**
	 * @������: deleteUserOwerRoleByUid
	 * @����˵��: ����Ȩ��
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��13������10:04:18
	 * @param user_id
	 * @param roleIds
	 * @return
	 * @return: int
	 */
	/*public int deleteUserOwerRoleByUid(int user_id,String roleIds);
*/
}
