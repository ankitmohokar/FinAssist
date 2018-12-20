package com.servlet.fintechchatbot;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.connection.*;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String sessionId=session.getId();
		
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		System.out.println(username+"--"+password);
		session.setAttribute("username", username);
		System.out.println("session user name: "+session.getAttribute("username"));
		CreateSession cs =new CreateSession();
		String isLogin=cs.insert(username, password,sessionId);
		if(isLogin.equals("success"))
		{
			//HttpSession session = request.getSession();
			response.sendRedirect("home.jsp");
		}
		else
		{
			session.invalidate();
			response.sendRedirect("sign-in.jsp");
		}
	}

}
