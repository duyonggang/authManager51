package com.imti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imti.model.MenuInfo;
import com.imti.model.UserInfo;
import com.imti.service.MenuInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @�ļ���: MenuInfoController.java
 * @�๦��˵��: ���Ʋ�˵�ʵ��
 * @����: DuYongGang
 * @Email: 2509634442@qq.com
 * @����: 2021��1��6������8:50:01
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: DuYongGang</li> 
 * 	 <li>����: 2021��1��6������8:50:01</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Controller
@RequestMapping("menuInfo")
public class MenuInfoController {
	
	@Autowired
	private MenuInfoService menuInfoService;	//����menuInfoService�ӿ�
	
	/**
	 * @������: findMenuInfoByParentId
	 * @����˵��: ���Ʋ�˵�ʵ��
	 * @����:DuYongGang
	 * @���䣺2509634442@qq.com
	 * @����: 2021��1��6������8:39:46
	 * @param request
	 * @return
	 * @return: JSONArray
	 */
	
	@RequestMapping("/findMenuInfoByParentId")
	@ResponseBody
	public JSONArray findMenuInfoByParentId(HttpServletRequest request) {
		int parentId=-1;
		HttpSession session=request.getSession();
		UserInfo userInfoSession=(UserInfo) session.getAttribute("currentUserInfo");
		List<String> menuIds=menuInfoService.getCurrentUserOwnMenus(userInfoSession.getUser_id());
		return menuInfoService.findMenuInfoByParentId(parentId,menuIds);
	}
	
	@RequestMapping("/findAllMenuInfoByRoleId")
	@ResponseBody
	public JSONArray findAllMenuInfoByRoleId(int roleId) {
		int parentId=-1;
		return menuInfoService.findAllMenuInfoByRoleId(parentId,roleId);
	}
	
	@RequestMapping("/saveRoleAndMenu")
	@ResponseBody
	public JSONObject saveRoleAndMenu(int role_id,String menuIds) {
		JSONObject jsonObject=new JSONObject();
		int result=menuInfoService.saveRoleAndMenu(role_id,menuIds);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	@RequestMapping("/findAllMenuInfo")
	@ResponseBody
	public List<MenuInfo> findAllMenuInfo() {
		int parentId=-1;
		return menuInfoService.findAllMenuInfo(parentId);
	}
	
	
	@RequestMapping("/addMenuInfo")
	@ResponseBody
	public JSONObject addMenuInfo(MenuInfo menuInfo,HttpServletRequest request) {
		HttpSession session=request.getSession();
		UserInfo sessionUserInfo=(UserInfo) session.getAttribute("currentUserInfo");
		menuInfo.setOpt_id(sessionUserInfo.getUser_id());
		JSONObject jsonObject=new JSONObject();
		int result=menuInfoService.addMenuInfo(menuInfo);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject; 
	}
	
	
	@RequestMapping("/updateMenuInfo")
	@ResponseBody
	public JSONObject updateMenuInfo(MenuInfo menuInfo) {
		JSONObject jsonObject=new JSONObject();
		int result=menuInfoService.updateMenuInfo(menuInfo);
		if(result>0) {
			jsonObject.put("msg",true);
		}else {
			jsonObject.put("msg",false);
		}
		return jsonObject;
	}
	
	
	@RequestMapping("/findMenuNameIsExist")
	@ResponseBody
	public JSONObject findMenuNameIsExist(String menuName) {
		JSONObject jsonObject=new JSONObject();
		int count=menuInfoService.findMenuNameIsExist(menuName);
		if(count>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject; 
	}
	
	
	@RequestMapping("/deleteMenuInfo")
	@ResponseBody
	public JSONObject deleteMenuInfo(String menuIds,HttpServletRequest request){
		JSONObject jsonObject=new JSONObject();
		int result=menuInfoService.deleteMenuInfo(menuIds);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	} 
	
}
