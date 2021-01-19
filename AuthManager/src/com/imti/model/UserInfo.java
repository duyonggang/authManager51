package com.imti.model;
/**@文件名: UserInfo.java
 * @类功能说明: 用户实体
 * @作者: DuYongGang
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月4日下午1:23:34
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月4日下午1:23:34</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class UserInfo {
	private Integer user_id;		//用户主键
	private String user_code;		//用户编码
	private String user_name;		//用户姓名
	private String user_nickName;	//用户昵称
	private String user_pwd;		//用户密码
	private int user_state;			//用户状态，0表示用户已启用，1表示用户已禁用
	private int user_delflag;		//删除标记，0表示未删除，1表示已删除
	private int opt_id;				//操作人
	private String createTime;		//创建时间
	private String user_remark;		//备注
	
	public UserInfo() {}
	
	
	public UserInfo(String user_name, String user_pwd) {
		this.user_name = user_name;
		this.user_pwd = user_pwd;
	}

	public UserInfo(String user_name, String user_nickName, String user_pwd, String user_remark) {
		this.user_name = user_name;
		this.user_nickName = user_nickName;
		this.user_pwd = user_pwd;
		this.user_remark = user_remark;
	}

	public UserInfo(Integer user_id, String user_name, String user_nickName, String user_pwd, String user_remark) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_nickName = user_nickName;
		this.user_pwd = user_pwd;
		this.user_remark = user_remark;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_nickName() {
		return user_nickName;
	}

	public void setUser_nickName(String user_nickName) {
		this.user_nickName = user_nickName;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public int getUser_state() {
		return user_state;
	}

	public void setUser_state(int user_state) {
		this.user_state = user_state;
	}

	public int getUser_delflag() {
		return user_delflag;
	}

	public void setUser_delflag(int user_delflag) {
		this.user_delflag = user_delflag;
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

	public String getUser_remark() {
		return user_remark;
	}

	public void setUser_remark(String user_remark) {
		this.user_remark = user_remark;
	}
	
	
}
