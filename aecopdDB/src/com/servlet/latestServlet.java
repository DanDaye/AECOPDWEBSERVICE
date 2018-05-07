package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LatestDao;
import com.dao.NormalDao;
import com.dao.PatientDao;
import com.dao.UserDao;
import com.entity.Latest;
import com.entity.Normal;
import com.entity.Patient;
import com.entity.User;
import com.entity.classification;
import com.google.gson.Gson;

/**
 * Servlet implementation class latestServlet
 */
public class latestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public latestServlet() {
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
		
		String username = request.getParameter("username");
		username = new String(username.getBytes("ISO-8859-1"));
//		System.out.println(username);
		
		boolean signal=false;
		Latest la = new LatestDao().findLatest(machine_id);
		Normal no = new NormalDao().findNormal(machine_id);
		
		if (la!=null && no!=null){
			signal = true;
		}
		//初始化计算数据
		float fev1 = Math.abs(Float.valueOf(no.getFev1()) - Float.valueOf(la.getFev1()));
		int age = 0;
		float boold_rate_up = Math.abs(Float.valueOf(no.getBoold_rate_up()) - Float.valueOf(la.getBoold_rate_up()));

		float boold_rate_down = Math.abs(Float.valueOf(no.getBoold_rate_down()) - Float.valueOf(la.getBoold_rate_down()));

		float heart_rate = Math.abs(Float.valueOf(no.getHeart_rate()) - Float.valueOf(la.getHeart_rate()));
		float breath_rate = Math.abs(Float.valueOf(no.getBreath_rate())-Float.valueOf(la.getBreath_rate()));
		float bmi_temp = Float.valueOf(la.getBMI());
		
		float bmi=0;
		if (bmi_temp <18.5){
			bmi = (float) (18.5-bmi_temp);
		}
		if(bmi_temp > 23.9){
			bmi = Math.abs((float) (bmi_temp - 23.9));
		}
		float cough_level =Float.valueOf(la.getCough_level());
		
		User u = new UserDao().findUser(username);
		Patient p = new PatientDao().findPatient(machine_id);
		System.out.println("disease history "+p.getDisease_history());
//		System.out.println("password:"+u.getAccount());
		try {
//			System.out.println("birthDate"+u.getBirthDate()+" username"+username);
			age = u.getAge(p.getDat());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = new classification(fev1,age,boold_rate_up,boold_rate_down,heart_rate,breath_rate,bmi,Integer.valueOf(p.getDisease_history()),cough_level,la.getTemperature(),la.getRelivate()).Classify();
		la.setLevel(Integer.valueOf(result));
		if (signal){
			String jsonData = gson.toJson(la);
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
