package com.imti.model;
/**
 * @�ļ���: MenuInfo.java
 * @�๦��˵��: 
 * @����: DuYongGang
 * @Email: 2509634442@qq.com
 * @����: 2021��1��6������8:54:12
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: DuYongGang</li> 
 * 	 <li>����: 2021��1��6������8:54:12</li> 
 *	 <li>����: </li>
 * </pre>
 */
public class MenuInfo {

	private Integer menu_id;		//�˵�����
	private int parentId;			//�˵���id
	private String menu_name;		//�˵�����
	private String menu_state;		//�˵�״̬(�ж��Ƿ����ӽڵ�)
	private String menu_url;		//�˵�·��
	private String menu_icon;		//�˵�ͼ��
	private int state;				//�˵�״̬���жϲ˵����û��߽��ã�0��ʾ���ã�1��ʾ����
	private int menu_delflag;		//ɾ����ǣ�0��ʾ�û�δɾ����1��ʾ�û���ɾ��
	private int opt_id;				//������
	private String createTime;		//����ʱ��
	private String menu_remark;		//��ע
	
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_state() {
		return menu_state;
	}
	public void setMenu_state(String menu_state) {
		this.menu_state = menu_state;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	public String getMenu_icon() {
		return menu_icon;
	}
	public void setMenu_icon(String menu_icon) {
		this.menu_icon = menu_icon;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getMenu_delflag() {
		return menu_delflag;
	}
	public void setMenu_delflag(int menu_delflag) {
		this.menu_delflag = menu_delflag;
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
	public String getMenu_remark() {
		return menu_remark;
	}
	public void setMenu_remark(String menu_remark) {
		this.menu_remark = menu_remark;
	}
}
