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
 *   |_ LoginAction
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 1.
 * </pre>
 *
 * @author	: Hvid
 * @version	: 1.0
 */
public class LoginAction implements IAction{

	private void validate(String id, String pwd) throws Exception
	{
		if(CommonUtil.isEmpty(id))
		{
			throw new Exception("아이디를 입력하세요.");
		}
		if(CommonUtil.isEmpty(pwd))
		{
			throw new Exception("비밀번호를 입력하세요.");
		}
	}
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			System.out.println(id + ", " + pwd);
			
			response.setContentType("text/html;charset=utf-8");
			
			validate(id, pwd);
			
			//id, pwd 정합성 체크
			UserService service = new UserService();
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPwd(pwd);
			
			UserVO result = service.login(vo);
			
			if(result != null)
			{
				//세션에 사용자 정보 생성
				HttpSession session = request.getSession();

				session.setAttribute("user", result);
				
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/subscribe.jsp");
				rd.forward(request, response);
			}
			else{
				throw new Exception("Invalid Username or Password");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/home.jsp");
			rd.forward(request, response);
		}
	}
	
}
