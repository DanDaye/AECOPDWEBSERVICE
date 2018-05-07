package com.entity;

import java.sql.Date;

public class Relivate {

	private  String Dat;
	private  String relivate;
	public Relivate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Relivate(String Dat,String relivate){
		this.Dat = Dat;
		this.relivate = relivate;
	}
	public String  getDate() {
		return Dat;
	}
	public  void setDate(String dat) {
		Dat = dat;
	}
	public  String getrelivate() {
		return relivate;
	}
	public  void setrelivate(String relivate) {
		this.relivate = relivate;
	}
	
}
