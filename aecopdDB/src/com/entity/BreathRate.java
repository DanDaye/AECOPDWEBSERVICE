package com.entity;

public class BreathRate {
	private  String Dat;
	private  String breath_rate;
	public BreathRate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BreathRate(String Dat,String breath_rate){
		super();
		this.Dat = Dat;
		this.breath_rate = breath_rate;
	}
	public String  getDate() {
		return Dat;
	}
	public  void setDate(String dat) {
		this.Dat = dat;
	}
	public  String getbreath_rate() {
		return breath_rate;
	}
	public  void setbreath_rate(String breath_rate) {
		this.breath_rate = breath_rate;
	}
	
}

