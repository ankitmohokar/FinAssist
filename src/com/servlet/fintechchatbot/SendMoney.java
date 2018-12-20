package com.servlet.fintechchatbot;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.OutputBuffer;
import org.json.JSONException;

import com.aws.connectinssh.SSHclient;
/**
 * Servlet implementation class SendMoney
 */
@WebServlet("/SendMoney")
public class SendMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMoney() {
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
		String output="";
		String ip="";
		String walletAddress="";
		String user="";
		String input =request.getParameter("data");
		System.out.println(input);
		System.out.println(input.substring((input.indexOf("$"))+1, (input.indexOf("to"))-1));
		user=session.getValue("username").toString();
		String amount=input.substring((input.indexOf("$"))+1, (input.indexOf("to"))-1);
		System.out.println(session.getValue(user.trim()));
		System.out.println(session.getValue((input.substring((input.indexOf("to"))+2, input.length()).trim())).toString());
		String mixinput =session.getValue(user.trim()).toString();
		String mixinput1 =session.getValue((input.substring((input.indexOf("to"))+2, input.length()).trim())).toString();
		
		if(mixinput.length() > 0)
		{
			walletAddress=mixinput1.substring(0, mixinput.indexOf("IP:"));
			ip=mixinput.substring(mixinput.indexOf("IP:")+3, mixinput.length());
		}
		System.out.println(walletAddress);
		System.out.println(ip);
		SSHclient ssh = new SSHclient();
		try {
			 output=ssh.sendMoney(ip,walletAddress, amount.trim());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write("Money sent successfully and available balance is : "+output);
	}

}
