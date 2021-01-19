package com.imti.service;

import java.util.List;
import java.util.Map;

import com.imti.model.RoleInfo;

import net.sf.json.JSONArray;

/**@�ļ���: RoleInfoService.java
 * @�๦��˵��: ������ɫ�ӿ�
 * @����: DuYongGang
 * @Email: 2509634442@qq.com
 * @����: 2021��1��8������2:52:02
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: DuYongGang</li> 
 * 	 <li>����: 2021��1��8������2:52:02</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface RoleInfoService {
	
	/**
	 * @������: findAllRoleInfo
	 * @����˵��: ������ѯ��ɫ�ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��9������9:09:32
	 * @param user_id
	 * @return: JSONArray
	 */
	public JSONArray findAllRoleInfoForUser(int user_id);
	
	
	/**
	 * @������: findAllRoleInfo
	 * @����˵��: ������ѯ�ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��10������10:53:37
	 * @param map
	 * @return
	 * @return: List<RoleInfo>
	 */
	
	public List<RoleInfo> findAllRoleInfo(Map<String,Object> map);
	
	/**
	 * @������: findAllRoleInfoCount
	 * @����˵��: ������ѯ��ɫ�����ӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��9������9:10:05
	 * @param map
	 * @return: int
	 */
	public int findAllRoleInfoCount(Map<String, Object> map);
	
	/**
	 * @������: findroleNameIsExist
	 * @����˵��: �жϽ�ɫ���Ƿ���ڽӿ�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��11������10:30:18
	 * @param roleName
	 * @return
	 * @return: int
	 */
	public int findroleNameIsExist(String roleName);
	
	/**
	 * @������: addRoleInfo
	 * @����˵��: ����
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��11������10:30:31
	 * @param roleInfo
	 * @return
	 * @return: int
	 */
	public int addRoleInfo(RoleInfo roleInfo);
	
	/**
	 * @������: updateRoleInfo
	 * @����˵��: �޸�
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��11������10:30:46
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
	 * @����: 2021��1��11������10:31:07
	 * @param roleIds
	 * @return
	 * @return: int
	 */
	public int deleteRoleInfo(String roleIds);
}
