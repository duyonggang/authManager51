package com.imti.model;
/**@�ļ���: PageBean.java
 * @�๦��˵��: 
 * @����: DuYongGang
 * @Email: 2509634442@qq.com
 * @����: 2021��1��6������4:49:59
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: DuYongGang</li> 
 * 	 <li>����: 2021��1��6������4:49:59</li> 
 *	 <li>����: </li>
 * </pre>
 */
public class PageBean {
	private int page;	//�ڼ�ҳ
	private int rows;	//ÿҳ��¼��
	@SuppressWarnings("unused")
	private int start;	//��ʼҳ
	
	public PageBean(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getStart() {
		return (page-1)*rows;
	}

}
