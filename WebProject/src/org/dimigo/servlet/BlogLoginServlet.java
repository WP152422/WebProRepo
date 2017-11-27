package org.dimigo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BlogLoginServlet
 */
@WebServlet(urlPatterns = { "/bloglogin" })
public class BlogLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("aaa");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		System.out.println(id);
		
		if("test@naver.com".equals(id))
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			
			RequestDispatcher rd = request.getRequestDispatcher("/myblog/home.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "error");
			request.setAttribute("wrongid", "\"" + id + "\"");
			RequestDispatcher rd = request.getRequestDispatcher("/myblog/login.jsp");
			rd.forward(request, response);
			
		}
	}

}
