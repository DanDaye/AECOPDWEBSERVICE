package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MachineDao;
import com.dao.UserDao;
import com.entity.*;
import com.google.gson.Gson;

/**
 * Servlet implementation class login
 */
//@WebServlet("/login")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String password = request.getParameter("password");
		password = new String(password.getBytes("ISO-8859-1"));
		
		//日期强转
		String birth = request.getParameter("birthdate");
		birth = new String(birth.getBytes("ISO-8859-1"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		try{
			d = format.parse(birth);
		}catch(Exception e){
			e.printStackTrace();
		}
		java.sql.Date date = new java.sql.Date(d.getTime());
		
		
		String machinename = request.getParameter("machine_id");
		machinename = new String(machinename.getBytes("ISO-8859-1"));
		
		String desease_history = request.getParameter("desease_history");
		desease_history = new String(desease_history.getBytes("ISO-8859-1"));
		
		boolean signal=false;
		Machine mac =new MachineDao().findMachine(machinename);
		System.out.println(mac);
		if(mac != null){
			System.out.println("machine is in it");
			User u = new UserDao().findUser(username);
			if (u.getAccount() !=null){
				System.out.println("user has already exit");
				out.print(signal + "1");
			}else{
				signal = new UserDao().addUser(new User(machinename,username,date,password,Integer.valueOf(desease_history).intValue()));
				out.print(signal);
			}
		}else{
			System.out.println("machine not in it");
			out.print(signal + "2");
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
