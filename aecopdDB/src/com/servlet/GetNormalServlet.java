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
 * Servlet implementation class GetNormalServlet
 */
public class GetNormalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNormalServlet() {
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
		boolean signal=false;
		Normal normal = new NormalDao().findNormal(machine_id);
		if(normal.getBMI()!=null){
			signal = true;
		}
		
		if (signal){
			String jsonData = gson.toJson(normal);
			out.write(jsonData);
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
