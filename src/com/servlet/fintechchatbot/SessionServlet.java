package com.servlet.fintechchatbot;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.connection.ConnectionManager;
/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
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
		// TODO Auto-generated method stub
		System.out.println("in");
		//HttpSession session = request.getSession();
		
		String fname= request.getParameter("fname").toString();
		String lname= request.getParameter("lname");
		String username= request.getParameter("username");
		String email= request.getParameter("email");
		String pass= request.getParameter("pass");
		//System.out.println(fname);
		
		ConnectionManager cn = new ConnectionManager();
		cn.insert(fname, lname, username, pass, email);
		
		response.sendRedirect("sign-up-complete.html");
		
		
		
		
				/*session.setAttribute("fname", fname);
				session.setAttribute("lname",lname);
				session.setAttribute("username", username);
				session.setAttribute("email", email);
				session.setAttribute("pass", pass);
				
				System.out.println(session.getValue("fname"));
				System.out.println(session.getValue("lname"));
				System.out.println(session.getValue("username"));
				System.out.println(session.getValue("email"));
				System.out.println(session.getValue("pass"));*/
		
	}

}
