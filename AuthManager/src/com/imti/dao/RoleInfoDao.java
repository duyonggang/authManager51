package com.imti.dao;
/**@�ļ���: RoleInfoDao.java
 * @�๦��˵��:  ��ɫ��Ȩ�־ò�ӿ�
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��7������6:58:18
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��7������6:58:18</li> 
 *	 <li>����: </li>
 * </pre>
 */

import java.util.List;
import java.util.Map;

import com.imti.model.RoleInfo;

public interface RoleInfoDao {
	/**
	 * @������: findAllRoleInfoForUser
	 * @����˵��: ��ɫ�־ò��ѯ�ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��8������12:13:58
	 * @param 
	 * @return: List<RoleInfo>
	 */
	public List<RoleInfo> findAllRoleInfoForUser();
	
	/**
	 * @������: findUserOwerRolesByUId
	 * @����˵��: ��ǰ�û���ӵ�еĽ�ɫ
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��9������9:51:58
	 * @param user_id
	 * @return: List<Integer>
	 */
	public List<Integer> findUserOwerRolesByUId(int user_id);
	
	/**
	 * @������: findAllRoleInfo
	 * @����˵��: ��ɫ�־ò�ģ����ѯ�ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��10������10:47:13
	 * @param map
	 * @return
	 * @return: List<RoleInfo>
	 */
	
	public List<RoleInfo> findAllRoleInfo(Map<String,Object> map);
	
	
	
	/**
	 * @������: findAllRoleInfoCount
	 * @����˵��: ��ѯ���н�ɫ��Ϣ��ҳ
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��8������12:14:20
	 * @param map
	 * @return: int
	 */
	public int findAllRoleInfoCount(Map<String, Object> map);
	
	
	/**
	 * @������: findroleNameIsExist
	 * @����˵��: �û��־ò��жϽ�ɫ���Ƿ���ڽӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��11������10:28:22
	 * @param roleName
	 * @return
	 * @return: int
	 */
	public int findroleNameIsExist(String roleName);
	
	/**
	 * @������: addRoleInfo
	 * @����˵��:���
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��11������10:28:48
	 * @param roleInfo
	 * @return
	 * @return: int
	 */
	public int addRoleInfo(RoleInfo roleInfo);
	
	/**
	 * @������: updateRoleInfo
	 * @����˵��:�޸� 
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��11������10:29:15
	 * @param roleInfo
	 * @return
	 * @return: int
	 */
	public int updateRoleInfo(RoleInfo roleInfo);
	
	/**
	 * @������: deleteRoleInfo
	 * @����˵��: ɾ��
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��11������10:29:35
	 * @param role_id
	 * @return
	 * @return: int
	 */
	public int deleteRoleInfo(int role_id);
}
