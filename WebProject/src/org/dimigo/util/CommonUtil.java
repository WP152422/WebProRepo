/**
 * 
 */
package org.dimigo.util;

/**
 * <pre>
 * org.dimigo.util
 *   |_ CommonUtil
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 1.
 * </pre>
 *
 * @author	: Hvid
 * @version	: 1.0
 */
public class CommonUtil {

	public static boolean isEmpty(String s)
	{
		if(s == null || "".equals(s.trim())) return true;
		return false;
	}
	
}
