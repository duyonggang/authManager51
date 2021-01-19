package com.imti.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imti.dao.RoleInfoDao;
import com.imti.model.RoleInfo;
import com.imti.service.RoleInfoService;
import com.imti.util.UUIDUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: RoleInfoServiceImpl.java
 * @类功能说明: 逻辑处理层角色实现
 * @作者: DuYongGang
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月8日下午2:53:13
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月8日下午2:53:13</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService{
	
	@Autowired
	private RoleInfoDao roleInfoDao;	//引入角色dao层角色接口

	@Override
	public JSONArray findAllRoleInfoForUser(int user_id) {
		List<Integer> role_ids=roleInfoDao.findUserOwerRolesByUId(user_id);	//查询当前用户所拥有的角色
		List<RoleInfo> roleList=roleInfoDao.findAllRoleInfoForUser();
		JSONArray jsonArray=new JSONArray();
		
		for(int i=0;i<roleList.size();i++) {
			RoleInfo roleInfo=roleList.get(i);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("role_id", (roleInfo.getRole_id()));
			jsonObject.put("role_name", (roleInfo.getRole_name()));
			jsonObject.put("role_code", (roleInfo.getRole_code()));
			jsonObject.put("role_state", (roleInfo.getRole_state()));
			jsonObject.put("role_delflag", (roleInfo.getRole_delflag()));
			jsonObject.put("opt_id", (roleInfo.getOpt_id()));
			jsonObject.put("createTime", (roleInfo.getCreateTime()));
			jsonObject.put("role_remark", (roleInfo.getRole_remark()));
			
			if(role_ids.contains(roleInfo.getRole_id())) {
				jsonObject.put("checked", true);
			}
			
			jsonArray.add(jsonObject);
			
		}
		
		return jsonArray;
	}

	@Override
	public int findAllRoleInfoCount(Map<String, Object> map) {
		return roleInfoDao.findAllRoleInfoCount(map);
	}

	@Override
	public List<RoleInfo> findAllRoleInfo(Map<String, Object> map) {
		return roleInfoDao.findAllRoleInfo(map);
	}

	@Override
	public int findroleNameIsExist(String roleName) {
		return roleInfoDao.findroleNameIsExist(roleName);
	}

	@Override
	public int addRoleInfo(RoleInfo roleInfo) {
		roleInfo.setRole_code(UUIDUtil.getUUID());
		return roleInfoDao.addRoleInfo(roleInfo);
	}

	@Override
	public int updateRoleInfo(RoleInfo roleInfo) {
		return roleInfoDao.updateRoleInfo(roleInfo);
	}

	@Override
	public int deleteRoleInfo(String roleIds) {
		String strs[]=roleIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			result+=roleInfoDao.deleteRoleInfo(Integer.parseInt(strs[i]));
		}
		return result;
				
	}
}
