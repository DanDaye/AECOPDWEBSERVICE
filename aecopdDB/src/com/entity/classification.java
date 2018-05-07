package com.entity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class classification {
	float fev1=0;
	int age=0;
	float boold_rate_up=0;
	float boold_rate_down=0;
	float heart_rate=0;
	float breath_rate=0;
	float BMI=0;
	int disease_history=0;
	float cough_level=0;
	String temperature = "";
	String relivate = "";
	public classification(){
		
	}
	
	
	public classification(float fev1, int age, float boold_rate_up, float boold_rate_down, float heart_rate,
			float breath_rate, float bMI,int disease_history, float cough_level, String temperature, String relivate) {
		super();
		this.fev1 = fev1;
		this.age = age;
		this.boold_rate_up = boold_rate_up;
		this.boold_rate_down = boold_rate_down;
		this.heart_rate = heart_rate;
		this.breath_rate = breath_rate;
		this.BMI = bMI;
		this.disease_history = disease_history;
		this.cough_level = cough_level;
		this.temperature = temperature;
		this.relivate = relivate;
	}


	public String Classify(){
		String line;
        String temp = null;
		try {
//        	System.out.println("start");
//        	String url = "123456";
        	String a = this.fev1+"";
        	String b = this.age + "";
        	String c = this.boold_rate_up+"";
        	String d = this.boold_rate_down+"";
        	String e = this.heart_rate+"";
        	String f = this.breath_rate+"";
        	String g = this.BMI+"";
        	String i = this.disease_history+"";
        	String h = this.cough_level+"";
        	System.out.println("success");
//            String[] args1=new String[]{"python","C:\\Program Files\\pythonCode\\classify.py",a,b,c,d,e,f,g,i,h,this.temperature,this.relivate};
            String[] args1=new String[]{"python","G:\\graduate\\pythonCode\\classify.py",a,b,c,d,e,f,g,i,h,this.temperature,this.relivate};
//            System.out.println(args1[2]+" "+args1[3] + " " + args1[4] + " "+args1[5]+ " "+args1[6]+ " "+args1[7]+ " "+args1[8]+ " "+args1[9]);
            Process pr=Runtime.getRuntime().exec(args1);
            if(pr!=null){
            	System.out.println("yeah");
            }
//            pr.waitFor();
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            
            while ((line = in.readLine()) != null) {
             System.out.println(line);
             temp = line;
            }
            System.out.println(temp);
            in.close();
            pr.waitFor();
//            System.out.println("end");
           } catch (Exception e) {
            e.printStackTrace();
           }
		return temp;
		
	}
//	public static void main(String[] args) { 
//		
//		classification c =new classification((float)11.0,63,(float)56,(float)19,(float)108.0,(float)6.0,(float)3.5,45, (float)1., "45","35");
//		System.out.println(c.Classify());
//	}
}
