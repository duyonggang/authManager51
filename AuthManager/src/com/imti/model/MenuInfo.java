package com.imti.model;
/**
 * @文件名: MenuInfo.java
 * @类功能说明: 
 * @作者: DuYongGang
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月6日上午8:54:12
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月6日上午8:54:12</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class MenuInfo {

	private Integer menu_id;		//菜单主键
	private int parentId;			//菜单父id
	private String menu_name;		//菜单名称
	private String menu_state;		//菜单状态(判断是否有子节点)
	private String menu_url;		//菜单路径
	private String menu_icon;		//菜单图标
	private int state;				//菜单状态，判断菜单启用或者禁用，0表示启用，1表示禁用
	private int menu_delflag;		//删除标记，0表示用户未删除，1表示用户已删除
	private int opt_id;				//操作人
	private String createTime;		//操作时间
	private String menu_remark;		//备注
	
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
