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
 *   |_ SessionAction
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 3.
 * </pre>
 *
 * @author	: Hvid
 * @version	: 1.0
 */
public class SessionAction implements IAction{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/sessionInfo.jsp");
			rd.forward(request, response);
		}
	}

}
