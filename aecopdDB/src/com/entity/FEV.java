package com.entity;

public class FEV {
	private  String Dat;
	private  String fev1;
	
	
	public FEV() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FEV(String dat, String fev1) {
		super();
		Dat = dat;
		this.fev1 = fev1;
	}


	public String getDat() {
		return Dat;
	}


	public void setDat(String dat) {
		Dat = dat;
	}


	public String getFev1() {
		return fev1;
	}

	public void setFev1(String fev1) {
		this.fev1 = fev1;
	}
	
	
}
