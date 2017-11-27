/**
 * 
 */
package org.dimigo.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.UserService;
import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.action
 *   |_ ListAction
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 3.
 * </pre>
 *
 * @author	: Hvid
 * @version	: 1.0
 */
public class ListAction implements IAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserService service = new UserService();
		List<UserVO> list = service.searchUserList();
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/list.jsp");
		rd.forward(request, response);
		
	}

}
