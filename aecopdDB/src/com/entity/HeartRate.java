package com.entity;

import java.util.Date;

public class HeartRate {
	private  String Dat;
	private  String heart_rate;
	public HeartRate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HeartRate(String Dat,String heart_rate){
		this.Dat = Dat;
		this.heart_rate = heart_rate;
	}
	public String  getDate() {
		return Dat;
	}
	public  void setDate(String dat) {
		Dat = dat;
	}
	public  String getHeart_rate() {
		return heart_rate;
	}
	public  void setHeart_rate(String heart_rate) {
		this.heart_rate = heart_rate;
	}
	
}
