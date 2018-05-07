package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BMIRateDao;
import com.dao.BooldRateDao;
import com.dao.BreathRateDao;
import com.dao.FEVDao;
import com.dao.HeartRateDao;
import com.dao.RelivateDao;
import com.dao.TemperatureDao;
import com.entity.BMIRate;
import com.entity.BooldRate;
import com.entity.BreathRate;
import com.entity.FEV;
import com.entity.HeartRate;
import com.entity.Relivate;
import com.entity.Temperature;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

/**
 * Servlet implementation class DataDetailServlet
 */
public class DataDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataDetailServlet() {
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
//		JsonArray jsonArr = new JsonArray();
		PrintWriter out = response.getWriter();
		boolean flag = false;
		String type = request.getParameter("type");
		type = new String(type.getBytes("ISO-8859-1"));
		String machine_id = request.getParameter("machine_id");
		machine_id = new String(machine_id.getBytes("ISO-8859-1"));
		if (type.equals("0")){
			List<BreathRate> breath = new BreathRateDao().findBreathRate(machine_id);
			if(breath != null){
				String json = gson.toJson(breath);
				out.write(json);
			}else{
				System.out.println("no");
				out.print(false);
			}
			
		}else if (type.equals("1")){
			List<HeartRate> heart  = new HeartRateDao().findHeartRate(machine_id);
			if(heart !=null){
				String jsonData = gson.toJson(heart);
				out.write(jsonData);
			}else{
				out.print(false);
			}
			
		}else if(type.equals("2")){
			List<BooldRate> boold  = new BooldRateDao().findBooldRate(machine_id);
			if(boold!=null){
				String jsonData = gson.toJson(boold);
				out.write(jsonData);
			}else{
				out.print(false);
			}
			
		}else if(type.equals("3")){
			List<BMIRate> bmi  = new BMIRateDao().findBMIRate(machine_id);
			if(bmi!=null){
				String jsonData = gson.toJson(bmi);
				out.write(jsonData);
			}else{
				out.print(false);
			}
			
		}else if(type.equals("4")){
			
			List<Temperature> temperature  = new TemperatureDao().findTemperature(machine_id);
			if(temperature!=null){
				String jsonData = gson.toJson(temperature);
				out.write(jsonData);
			}else{
				out.print(false);
			}
		}else if(type.equals("5")){
			List<Relivate> relivate  = new RelivateDao().findRelivate(machine_id);
			if(relivate !=null){
				String jsonData = gson.toJson(relivate);
				out.write(jsonData);
			}else{
				out.print(false);
			}
			
			
		}else if(type.equals("6")){
			List<FEV> fev = new FEVDao().findFEV(machine_id);
			if(fev !=null){
				String jsonData = gson.toJson(fev);
				out.write(jsonData);
			}else{
				out.print(false);
			}
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
