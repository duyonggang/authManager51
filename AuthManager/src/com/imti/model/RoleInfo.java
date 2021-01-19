package com.imti.model;
/**
 * @文件名: RoleInfo.java
 * @类功能说明: 角色实体
 * @作者: DuYongGang
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月8日上午12:08:39
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月8日上午12:08:39</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class RoleInfo {
	
	private Integer role_id;        //角色id
	private String role_name;       //角色名称
	private String role_code;       //角色编号
	private int role_state;         //角色状态 ，0表示用户已启用，1表示用户禁用
	private int role_delflag;       //删除标记，0表示用户未删除，1表示用户已删除
	private int opt_id;             //操作人
	private String createTime;      //创建时间
	private String role_remark;     //备注
	
	public RoleInfo() {}

	public RoleInfo(String role_name, String role_remark) {
		this.role_name = role_name;
		this.role_remark = role_remark;
	}
	
	public RoleInfo(Integer role_id, String role_name, String role_remark) {
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_remark = role_remark;
	}


	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_code() {
		return role_code;
	}
	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}
	public int getRole_state() {
		return role_state;
	}
	public void setRole_state(int role_state) {
		this.role_state = role_state;
	}
	public int getRole_delflag() {
		return role_delflag;
	}
	public void setRole_delflag(int role_delflag) {
		this.role_delflag = role_delflag;
	}
	public int getOpt_id() {
		return opt_id;
	}
	public void setOpt_id(int opt_id) {
		this.opt_id = opt_id;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getRole_remark() {
		return role_remark;
	}
	public void setRole_remark(String role_remark) {
		this.role_remark = role_remark;
	}
}
