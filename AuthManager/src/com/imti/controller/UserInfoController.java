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

/**@�ļ���: UserInfoController.java
 * @�๦��˵��: �û�������Ʋ�
 * @����: DuYongGang
 * @Email: 2509634442@qq.com
 * @����: 2021��1��4������4:37:21
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: DuYongGang</li> 
 * 	 <li>����: 2021��1��4������4:37:21</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Controller
@RequestMapping("userInfo")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;	//����service�ӿ�
	
	/**
	 * @������: login
	 * @����˵��: ���Ʋ��¼ʵ��
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��4������5:40:07
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
	 * @������: login
	 * @����˵��: ���Ʋ��˳�ʵ��
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��4������5:40:07
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
	 * @������: clearSession
	 * @����˵��: session���ʵ��
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��6������5:04:50
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
	 * @������: findAllUserInfo
	 * @����˵��:���Ʋ��ѯ��ģ����ѯ����ҳʵ�� 
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��6������5:00:04
	 * @param rows
	 * @param page
	 * @param s_userName
	 * @return: List<UserInfo>
	 */
	@RequestMapping("/findAllUserInfo")
	@ResponseBody
	public Map<String,Object> findAllUserInfo(int rows,int page,String s_userName){
		Map<String,Object> map=new HashMap<String,Object>();	//��ѯ�Զ���װʵ��
		map.put("s_userName", s_userName);
		PageBean pageBean=new PageBean(page,rows);	//��ҳ�Զ���װʵ��
		map.put("pageBean", pageBean);
		List<UserInfo> userList=userInfoService.findAllUserInfo(map);
		int total=userInfoService.findAllUserInfoCount(map);
		Map<String,Object> resultmap=new HashMap<String,Object>();
		resultmap.put("total", total);
		resultmap.put("rows", userList);
		return resultmap;
	}
	
	/**
	 * ���Ʋ��ж��û����Ƿ���� 
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
	 * ���Ʋ�����ʵ�� 
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
	 * ���Ʋ��޸�ʵ�� 
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
	 * ���Ʋ�ɾ��ʵ�� 
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
	 * @������: deleteUserOwerRoleByUid
	 * @����˵��: ����Ȩ��
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��13������9:59:30
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
