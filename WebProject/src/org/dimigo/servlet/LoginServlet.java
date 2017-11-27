package org.dimigo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.vo.UserVO;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login.jsp 로 포워딩
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id + ", " + pwd);
		
		response.setContentType("application/json:charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Gson gson = new Gson();
		JsonObject obj = new JsonObject();
		obj.addProperty("id", id);
		obj.addProperty("pwd", pwd);
		out.println(gson.toJson(obj));
		System.out.println(gson.toJson(obj));
		
		out.close();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id + ", " + pwd);
		
		response.setContentType("text/html;charset=utf-8");
		
		//id, pwd 정합성 체크
		boolean result = true;
		if(result)
		{
			//세션에 사용자 정보 생성
			HttpSession session = request.getSession();
			UserVO user = new UserVO();
			
			user.setId(id);
			user.setName("강엄");
			user.setNickName("문신");
			
			session.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/home.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "error");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
			rd.forward(request, response);
		}
	}

}
