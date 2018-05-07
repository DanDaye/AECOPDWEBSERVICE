package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PatientDao;
import com.dao.UserDao;

/**
 * Servlet implementation class ChangeDiseaseServlet
 */
public class ChangeDiseaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeDiseaseServlet() {
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
		String machine_id = request.getParameter("machine_id");
		machine_id = new String(machine_id.getBytes("ISO-8859-1"));
		
		System.out.println(machine_id);
		String disease = request.getParameter("disease_history");
		disease = new String(disease.getBytes("ISO-8859-1"));
		int d = Integer.parseInt(disease);
		System.out.print(d);
		boolean signal=false;
//		signal = new UserDao().modifyUserDisease(machine_id, d);
		signal = new PatientDao().modifyPatientDisease(machine_id, d);
		out.print(signal);
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
