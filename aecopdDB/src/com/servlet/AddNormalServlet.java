package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BMIRateDao;
import com.dao.FEVDao;
import com.dao.LatestDao;
import com.dao.NormalDao;
import com.entity.Normal;

/**
 * Servlet implementation class AddNormalServlet
 */
public class AddNormalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNormalServlet() {
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
		Normal n = new Normal();
		String machine_id = request.getParameter("machine_id");
		machine_id = new String(machine_id.getBytes("ISO-8859-1"));
		
		String fev1 = request.getParameter("fev1");
		fev1 = new String(fev1.getBytes("ISO-8859-1"));
		n.setFev1(fev1);
		
		String heart_rate = request.getParameter("heart");
		heart_rate = new String(heart_rate.getBytes("ISO-8859-1"));
		n.setHeart_rate(heart_rate);
		
		String breath_rate = request.getParameter("breath");
		breath_rate = new String(breath_rate.getBytes("ISO-8859-1"));
		n.setBreath_rate(breath_rate);
		
		String bmi = request.getParameter("bmi");
		bmi = new String(bmi.getBytes("ISO-8859-1"));
		n.setBMI(bmi);
		
		String boold = request.getParameter("boold");
		boold = new String(boold.getBytes("ISO-8859-1"));
		String[] boold_rate = boold.split("/");
		n.setBoold_rate_up(boold_rate[0]);
		n.setBoold_rate_down(boold_rate[1]);
		
		boolean signal = new NormalDao().AddNormal(machine_id, n);
		boolean signal1 = new LatestDao().AddLatestDao(machine_id, n);
		
		signal = signal && signal1;
		if(signal){
			new FEVDao().addFEV(machine_id, fev1);
			new BMIRateDao().addBMIRate(machine_id, bmi);
		}
		out.print(signal);
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
