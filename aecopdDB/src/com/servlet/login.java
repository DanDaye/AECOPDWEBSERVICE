package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.entity.*;
import com.google.gson.Gson;

/**
 * Servlet implementation class login
 */
//@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		boolean flag = false;
		String username = request.getParameter("username");
		username = new String(username.getBytes("ISO-8859-1"));
		System.out.println(username);
		String password = request.getParameter("password");
		System.out.println(password);
		boolean signal=false;
		List<User> user =new User().returnAllUser();
		if(user != null){
			System.out.println("yes");
		}
		String machine_id = null;
		for(User u:user){
			System.out.println(u.getAccount());
			if(u.getAccount().equals(username) && u.getPassword().equals(password)){
				signal= true;
				machine_id = u.getMachine_id();
//				System.out.println(machine_id);
				break;
			}
		}
		if (signal){
//			System.out.println("Success");
			out.print(true+":"+machine_id);
//			out.print(":"+username);
			request.getSession().setAttribute("username", username);
		}else{
			System.out.println("Failed");
			out.print(false);
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		out.flush();
		out.close();
		System.out.println(signal);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
