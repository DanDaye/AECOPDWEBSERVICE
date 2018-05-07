package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LatestDao;
import com.dao.UserDao;
import com.entity.Latest;
import com.entity.User;
import com.google.gson.Gson;

/**
 * Servlet implementation class userDetail
 */
public class userDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userDetail() {
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
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		boolean flag = false;
		String username = request.getParameter("username");
		username = new String(username.getBytes("ISO-8859-1"));
		System.out.println(username);
		boolean signal=false;
		User u = new UserDao().findUser(username);
		String t = "";
		if (u!=null){
			signal = true;
			t = u.getBirthDate().toString() ;
//			System.out.println("time:"+t);
			
		}
		u.setTime(t);
		if (signal){
			String jsonData = gson.toJson(u);
			out.write(jsonData);
//			request.getSession().setAttribute("username", username);
		}else{
			out.print(false);
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
