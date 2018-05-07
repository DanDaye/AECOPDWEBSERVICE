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
import com.dao.PatientDao;
import com.entity.Latest;
import com.entity.Patient;
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
		String machine = request.getParameter("machine_id");
		machine = new String(machine.getBytes("ISO-8859-1"));
		System.out.println(machine);
		boolean signal=false;
		Patient p = new PatientDao().findPatient(machine);
		String t = "";
		if(p!=null){
			signal = true;
			t=p.getDat().toString();
		}
		p.setTime(t);
		if (signal){
			String jsonData = gson.toJson(p);
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
