package com.imti.util;

import java.util.UUID;

/**@文件名: UUIDUtil.java
 * @类功能说明:创建UUID工具类 
 * @作者: DuYongGang
 * @Email: 2509634442@qq.com
 * @日期: 2021年1月6日下午11:11:01
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: DuYongGang</li> 
 * 	 <li>日期: 2021年1月6日下午11:11:01</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class UUIDUtil {
	
	public static String getUUID() {
		String uuid=UUID.randomUUID().toString().replace("-", "");
		return uuid;
		
	}

}
