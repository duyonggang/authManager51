package com.imti.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imti.model.PageBean;
import com.imti.model.RoleInfo;
import com.imti.model.UserInfo;
import com.imti.service.RoleInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: RoleInfoController.java
 * @类功能说明: 
 * @作者: DuYongGang
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月8日下午2:58:09
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月8日下午2:58:09</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/roleInfo")
public class RoleInfoController {
	
	@Autowired
	private RoleInfoService roleInfoService;	//引入service接口
	
	@RequestMapping("/findAllRoleInfoForUser")
	@ResponseBody
	public JSONObject findAllRoleInfoForUser(int user_id) {
		JSONObject jsonObject=new JSONObject();
		JSONArray jsonArray=roleInfoService.findAllRoleInfoForUser(user_id);
		jsonObject.put("rows", jsonArray);
		return jsonObject;
	}
	
	/**
	 * @方法名: findAllRoleInfo
	 * @方法说明: 控制层查询及模糊查询，分页实现 
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月10日下午11:33:11
	 * @param rows
	 * @param page
	 * @param s_roleName
	 * @return
	 * @return: Map<String,Object>
	 */
	@RequestMapping("/findAllRoleInfo")
	@ResponseBody
	public Map<String,Object> findAllRoleInfo(int rows,int page,String s_roleName) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("s_roleName", s_roleName);
		PageBean pageBean=new PageBean(page,rows);
		map.put("pageBean", pageBean);
		List<RoleInfo> roleList=roleInfoService.findAllRoleInfo(map);
		int total=roleInfoService.findAllRoleInfoCount(map);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("total", total);
		resultMap.put("rows", roleList);
		return resultMap;
	
	}
	
	
	@RequestMapping("/findroleNameIsExist")
	@ResponseBody
	public JSONObject findroleNameIsExist(String roleName) {
		JSONObject jsonObject=new JSONObject();
		int count=roleInfoService.findroleNameIsExist(roleName);
		if(count>0) {
			jsonObject.put("msg",true);
		}else {
			jsonObject.put("msg",false);
		}
		return jsonObject;
	}
	
	
	
	@RequestMapping("/addRoleInfo")
	@ResponseBody
	public JSONObject addRoleInfo(RoleInfo roleInfo,HttpServletRequest request) {
		HttpSession session=request.getSession();
		UserInfo sessionUserInfo=(UserInfo) session.getAttribute("currentUserInfo");
		roleInfo.setOpt_id(sessionUserInfo.getUser_id());
		JSONObject jsonObject=new JSONObject();
		int result=roleInfoService.addRoleInfo(roleInfo);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	@RequestMapping("/updateRoleInfo")
	@ResponseBody
	public JSONObject updateRoleInfo(RoleInfo roleInfo) {
		JSONObject jsonObject=new JSONObject();
		int result=roleInfoService.updateRoleInfo(roleInfo);
		if(result>0) {
			jsonObject.put("msg",true);
		}else {
			jsonObject.put("msg",false);
		}
		return jsonObject;
	}
	
	@RequestMapping("/deleteRoleInfo")
	@ResponseBody
	public JSONObject deleteRoleInfo(String roleIds,HttpServletRequest request) {
		JSONObject jsonObject=new JSONObject();
		int result=roleInfoService.deleteRoleInfo(roleIds);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
}
