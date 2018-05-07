package com.entity;

import java.sql.Date;

public class Temperature {

	private  String Dat;
	private  String temperature;
	public Temperature() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Temperature(String Dat,String temperature){
		this.Dat = Dat;
		this.temperature = temperature;
	}
	public String  getDate() {
		return Dat;
	}
	public  void setDate(String dat) {
		Dat = dat;
	}
	public  String gettemperature() {
		return temperature;
	}
	public  void settemperature(String temperature) {
		this.temperature = temperature;
	}
	
}
