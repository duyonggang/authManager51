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
import com.imti.model.UserInfo;
import com.imti.service.UserInfoService;

import net.sf.json.JSONObject;

/**@文件名: UserInfoController.java
 * @类功能说明: 用户管理控制层
 * @作者: DuYongGang
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月4日下午4:37:21
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月4日下午4:37:21</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("userInfo")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;	//引入service接口
	
	/**
	 * @方法名: login
	 * @方法说明: 控制层登录实现
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月4日下午5:40:07
	 * @param userInfo
	 * @param request
	 * @return: String
	 */
	@RequestMapping(value="/login")
	public String login(UserInfo userInfo,HttpServletRequest request) {
		HttpSession session=request.getSession();
		String rands=request.getParameter("yzm");
		String sessionRands=(String) session.getAttribute("sRand");
		UserInfo sessionUserInfo=(UserInfo) session.getAttribute("currentUserInfo");
		if(sessionUserInfo!=null) {
			return "main";
		}else {
			if(sessionRands==null) {
				return "redirect:../login.jsp";
			}else {
				if(sessionRands.equals(rands)) {
					UserInfo resultUserInfo=userInfoService.login(userInfo);
					if(resultUserInfo!=null) {
						session.setAttribute("currentUserInfo", resultUserInfo);
						return "main";
					}else {
					   
						return "redirect:../login.jsp?error=1&user_name="+userInfo.getUser_name()+"&user_pwd="+userInfo.getUser_pwd()+"&yzm="+rands;
				    }
				}else {
					return "redirect:../login.jsp?error=2&user_name="+userInfo.getUser_name()+"&user_pwd="+userInfo.getUser_pwd()+"&yzm="+rands;
				}
			}
		}

	}
	
	/**
	 * @方法名: login
	 * @方法说明: 控制层退出实现
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月4日下午5:40:07
	 * @param userInfo
	 * @param request
	 * @return: String
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("currentUserInfo");
		return "redirect:../login.jsp";
		
	}
	
	/**
	 * @方法名: clearSession
	 * @方法说明: session清空实现
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月6日下午5:04:50
	 * @param request
	 * @return: void
	 */
	@RequestMapping("/clearSession")
	@ResponseBody
	public void clearSession(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("currentUserInfo");
	}
	
	/**
	 * @方法名: findAllUserInfo
	 * @方法说明:控制层查询及模糊查询，分页实现 
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月6日下午5:00:04
	 * @param rows
	 * @param page
	 * @param s_userName
	 * @return: List<UserInfo>
	 */
	@RequestMapping("/findAllUserInfo")
	@ResponseBody
	public Map<String,Object> findAllUserInfo(int rows,int page,String s_userName){
		Map<String,Object> map=new HashMap<String,Object>();	//查询自动封装实现
		map.put("s_userName", s_userName);
		PageBean pageBean=new PageBean(page,rows);	//分页自动封装实现
		map.put("pageBean", pageBean);
		List<UserInfo> userList=userInfoService.findAllUserInfo(map);
		int total=userInfoService.findAllUserInfoCount(map);
		Map<String,Object> resultmap=new HashMap<String,Object>();
		resultmap.put("total", total);
		resultmap.put("rows", userList);
		return resultmap;
	}
	
	/**
	 * 控制层判断用户名是否存在 
	 */
	@RequestMapping("/findUserNameIsExist")
	@ResponseBody
	public JSONObject findUserNameIsExist(String userName) {
		JSONObject jsonObject=new JSONObject();
		int count=userInfoService.findUserNameIsExist(userName);
		if(count>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject; 
	}
	
	/**
	 * 控制层新增实现 
	 */
	@RequestMapping("/addUserInfo")
	@ResponseBody
	public JSONObject addUserInfo(UserInfo userInfo,HttpServletRequest request) {
		HttpSession session=request.getSession();
		UserInfo sessionUserInfo=(UserInfo) session.getAttribute("currentUserInfo");
		userInfo.setOpt_id(sessionUserInfo.getUser_id());
		JSONObject jsonObject=new JSONObject();
		int result=userInfoService.addUserInfo(userInfo);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject; 
	}
	
	/**
	 * 控制层修改实现 
	 */
	@RequestMapping("/updateUserInfo")
	@ResponseBody
	public JSONObject updateUserInfo(UserInfo userInfo,HttpServletRequest request) {
		JSONObject jsonObject=new JSONObject();
		int result=userInfoService.updateUserInfo(userInfo);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject; 
	}
	
	
	/**
	 * 控制层删除实现 
	 */
	@RequestMapping("/deleteUserInfo")
	@ResponseBody
	public JSONObject deleteUserInfo(String userIds,HttpServletRequest request){
		JSONObject jsonObject=new JSONObject();
		int result=userInfoService.deleteUserInfo(userIds);
		if(result>0) {
			jsonObject.put("msg", true);
			jsonObject.put("count", result);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	@RequestMapping("/insertUserAndRole")
	@ResponseBody
	public JSONObject insertUserAndRole(int userId,String roleIds) {
		JSONObject jsonObject=new JSONObject();
		int result=userInfoService.insertUserAndRole(userId,roleIds);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	/**
	 * @方法名: deleteUserOwerRoleByUid
	 * @方法说明: 回收权限
	 * @作者:DuYongGang
	 * @邮箱：2509634442@qq.com
	 * @日期: 2021年1月13日上午9:59:30
	 * @param userId
	 * @param roleIds
	 * @return
	 * @return: JSONObject
	 */
	/*@RequestMapping("/deleteUserOwerRoleByUid")
	@ResponseBody
	public JSONObject deleteUserOwerRoleByUid(int userId,String roleIds){
		JSONObject jsonObject=new JSONObject();
		int result=userInfoService.deleteUserOwerRoleByUid(userId,roleIds);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}*/
}
