package com.imti.util;

import java.util.UUID;

/**@�ļ���: UUIDUtil.java
 * @�๦��˵��:����UUID������ 
 * @����: DuYongGang
 * @Email: 2509634442@qq.com
 * @����: 2021��1��6������11:11:01
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: DuYongGang</li> 
 * 	 <li>����: 2021��1��6������11:11:01</li> 
 *	 <li>����: </li>
 * </pre>
 */
public class UUIDUtil {
	
	public static String getUUID() {
		String uuid=UUID.randomUUID().toString().replace("-", "");
		return uuid;
		
	}

}
