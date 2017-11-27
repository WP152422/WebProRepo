package org.dimigo.servlet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(description = "First Servlet", urlPatterns = { "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 데이터 처리
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println(id + ", " + name);
		
		//출력 데이터 ContentType 설정
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='utf-8'>");
		out.print("<title>Survlet Test</Title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Hello, Survlet</h1>");
		out.print("<h2>id : " + id + ", name : " + name + "</h2>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("Init() called");
	}
	
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("Service() called");
		super.service(arg0, arg1);
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy() called");
	}

}
