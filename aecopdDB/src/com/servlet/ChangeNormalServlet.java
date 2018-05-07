package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LatestDao;
import com.dao.NormalDao;
import com.dao.UserDao;
import com.entity.Latest;
import com.entity.Normal;
import com.entity.User;
import com.entity.classification;
import com.google.gson.Gson;

/**
 * Servlet implementation class ChangeNormalServlet
 */
public class ChangeNormalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeNormalServlet() {
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
		String machine_id = request.getParameter("machine_id");
		machine_id = new String(machine_id.getBytes("ISO-8859-1"));
//		System.out.println(machine_id);
		
		String type = request.getParameter("type");
		type = new String(type.getBytes("ISO-8859-1"));
		System.out.println(type);
//		System.out.println(username);
		String content = request.getParameter("content");
		content = new String(content.getBytes("ISO-8859-1"));
		Normal normal = new NormalDao().findNormal(machine_id);
		if(type.equals("0")){
			normal.setFev1(content);
		}else if (type.equals("1")){
			normal.setHeart_rate(content);
		}else if(type.equals("2")){
			normal.setBreath_rate(content);
		}else if (type.equals("3")){
			String[] boold = content.split("/");
			normal.setBoold_rate_down(boold[1]);
			normal.setBoold_rate_up(boold[0]);
		}else if(type.equals("4")){
			normal.setBMI(content);
		}
		
		boolean signal=new NormalDao().ChangeNormal(normal, machine_id);
		
		if (signal){
			out.print(true);
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
