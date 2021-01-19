package com.imti.model;
/**
 * @�ļ���: RoleInfo.java
 * @�๦��˵��: ��ɫʵ��
 * @����: DuYongGang
 * @Email: 2509634442@qq.com
 * @����: 2021��1��8������12:08:39
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: DuYongGang</li> 
 * 	 <li>����: 2021��1��8������12:08:39</li> 
 *	 <li>����: </li>
 * </pre>
 */
public class RoleInfo {
	
	private Integer role_id;        //��ɫid
	private String role_name;       //��ɫ����
	private String role_code;       //��ɫ���
	private int role_state;         //��ɫ״̬ ��0��ʾ�û������ã�1��ʾ�û�����
	private int role_delflag;       //ɾ����ǣ�0��ʾ�û�δɾ����1��ʾ�û���ɾ��
	private int opt_id;             //������
	private String createTime;      //����ʱ��
	private String role_remark;     //��ע
	
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
