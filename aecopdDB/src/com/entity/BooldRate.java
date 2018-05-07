package com.entity;

import java.sql.Date;

public class BooldRate {

	private  String Dat;
	private  String boold_rate_up;
	private String boold_rate_down;
	public BooldRate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BooldRate(String dat, String boold_rate_up, String boold_rate_down) {
		super();
		Dat = dat;
		this.boold_rate_up = boold_rate_up;
		this.boold_rate_down = boold_rate_down;
	}
	public String getDat() {
		return Dat;
	}
	public void setDat(String dat) {
		Dat = dat;
	}
	public String getBoold_rate_up() {
		return boold_rate_up;
	}
	public void setBoold_rate_up(String boold_rate_up) {
		this.boold_rate_up = boold_rate_up;
	}
	public String getBoold_rate_down() {
		return boold_rate_down;
	}
	public void setBoold_rate_down(String boold_rate_down) {
		this.boold_rate_down = boold_rate_down;
	}
	
}
