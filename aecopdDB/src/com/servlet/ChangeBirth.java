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
 * Servlet implementation class ChangeBirth
 */
public class ChangeBirth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeBirth() {
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
		String birthDate = request.getParameter("birthdate");
		birthDate = new String(birthDate.getBytes("ISO-8859-1"));
		
		System.out.println(birthDate);
		boolean signal=false;
//		signal = new UserDao().modifyUserBirth(username, birthDate);
		signal = new PatientDao().modifyPatientBirth(machine_id, birthDate);
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
