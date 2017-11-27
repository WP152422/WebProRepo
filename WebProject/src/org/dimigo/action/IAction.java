/**
 * 
 */
package org.dimigo.action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * org.dimigo.action
 *   |_ IAction
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 1.
 * </pre>
 *
 * @author	: Hvid
 * @version	: 1.0
 */
public interface IAction {

	void excute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
