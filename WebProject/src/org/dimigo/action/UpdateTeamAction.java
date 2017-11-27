/**
 * 
 */
package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtil;
import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.action
 *   |_ ChangeTeamAction
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 25.
 * </pre>
 *
 * @author	: Hvid
 * @version	: 1.0
 */
public class UpdateTeamAction implements IAction{
	
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("utf-8");
			String teamName = request.getParameter("teamName");
			System.out.println("teamName : " + teamName);
			
			response.setContentType("text/html;charset=utf-8");
			


			
			HttpSession session = request.getSession();
			
			UserService service = new UserService();
			service.updateTeam(teamName, (UserVO)session.getAttribute("user"));
			
			
			((UserVO) session.getAttribute("user")).setTeamName(teamName);

			RequestDispatcher rd = request.getRequestDispatcher("/jsp/subscribe.jsp");
			rd.forward(request, response);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/subscribe.jsp");
			rd.forward(request, response);
		}
	}
}
