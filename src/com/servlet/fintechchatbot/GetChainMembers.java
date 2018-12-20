package com.servlet.fintechchatbot;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.database.connection.GetChainMembersClass;

/**
 * Servlet implementation class GetChainMembers
 */
@WebServlet("/GetChainMembers")
public class GetChainMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetChainMembers() {
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
		HttpSession session =request.getSession();
		String memb="";
		GetChainMembersClass members = new GetChainMembersClass();
		JSONObject mem=members.getMember();
		System.out.println(mem.keys());
		//memb=mem.keys().toString();
		/*for(int i=0;i<mem.length();i++)
		{
			try {
				memb=memb+mem.toString(i)+"\n";
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		//memb=memb+mem.toString()+"\n";
		
		@SuppressWarnings("unchecked")
		Iterator<String> keys = mem.keys();

		while(keys.hasNext()) {
		    String key = keys.next();
		    System.out.println(key);
		    memb=memb+key+"\n";
		    try {
		    	session.setAttribute(key, mem.get(key));
				//System.out.println(mem.get(key)) ;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				
		}
		System.out.println(memb);
		response.getWriter().write(memb);
	}

}
