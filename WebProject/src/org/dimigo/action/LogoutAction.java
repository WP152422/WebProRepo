/**
 * 
 */
package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <pre>
 * org.dimigo.action
 *   |_ LogoutAction
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 3.
 * </pre>
 *
 * @author	: Hvid
 * @version	: 1.0
 */
public class LogoutAction implements IAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/home.jsp");
		rd.forward(request, response);
		
	}

}
