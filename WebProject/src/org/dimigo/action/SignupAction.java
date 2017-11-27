			/**
 * 
 */
package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtil;
import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.action
 *   |_ SignupAction
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 3.
 * </pre>
 *
 * @author	: Hvid
 * @version	: 1.0
 */
public class SignupAction implements IAction{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try
		{
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("text/html;charset=utf-8");
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String nickName = request.getParameter("nickName");
			
			System.out.println("id : " + id + ", pwd : " + pwd + ", name : " + name + ", nickName : " + nickName);
			
			UserVO user = new UserVO(id, pwd, name, nickName);
			
			validate(user);
			
			UserService service = new UserService();
			service.signup(user);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);
		}
		
	}
	
	private void validate(UserVO vo) throws Exception
	{
		if(CommonUtil.isEmpty(vo.getId())) throw new Exception("아이디를 입력하세요");
		if(CommonUtil.isEmpty(vo.getPwd())) throw new Exception("비밀번호를 입력하세요");
		if(CommonUtil.isEmpty(vo.getName())) throw new Exception("이름를 입력하세요");
		if(CommonUtil.isEmpty(vo.getNickName())) throw new Exception("닉네임를 입력하세요");
	}

}
