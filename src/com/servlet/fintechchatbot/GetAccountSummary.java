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
import com.aws.connectinssh.GetAccSummary;

/**
 * Servlet implementation class GetAccountSummary
 */
@WebServlet("/GetAccountSummary")
public class GetAccountSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAccountSummary() {
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
		
		
		
		
		
		
		String output="";
		String ip="";
		//String walletAddress="";
		String user="";
		//String input =request.getParameter("data");
		//System.out.println(input);
		//System.out.println(input.substring((input.indexOf("$"))+1, (input.indexOf("to"))-1));
		user=session.getValue("username").toString();
		System.out.println(user);
		//String amount=input.substring((input.indexOf("$"))+1, (input.indexOf("to"))-1);
		System.out.println(session.getValue(user.trim()));
		//System.out.println(session.getValue((input.substring((input.indexOf("to"))+2, input.length()).trim())).toString());
		String mixinput =session.getValue(user.trim()).toString();
		//String mixinput1 =session.getValue((input.substring((input.indexOf("to"))+2, input.length()).trim())).toString();
		
		if(mixinput.length() > 0)
		{
			//walletAddress=mixinput1.substring(0, mixinput.indexOf("IP:"));
			ip=mixinput.substring(mixinput.indexOf("IP:")+3, mixinput.length());
		}
		//System.out.println(walletAddress);
		System.out.println(ip);
		GetAccSummary gasum =new GetAccSummary();
		try {
			String accSum=gasum.getAccountSummary(ip);
			response.getWriter().write(accSum);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
