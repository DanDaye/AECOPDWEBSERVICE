package com.entity;

import java.sql.Date;

public class BMIRate {

	private  String Dat;
	private  String bmi;
	public BMIRate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BMIRate(String Dat,String bmi){
		this.Dat = Dat;
		this.bmi = bmi;
	}
	public String  getDate() {
		return Dat;
	}
	public  void setDate(String dat) {
		Dat = dat;
	}
	public  String getbmi() {
		return bmi;
	}
	public  void setbmi(String bmi) {
		this.bmi = bmi;
	}
	
}
