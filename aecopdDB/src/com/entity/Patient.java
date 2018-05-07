package com.entity;

import java.sql.Date;

public class Patient {
	private String machine_id;
	private Date dat;
	private String disease_history;
	private String time;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(String machine_id, Date dat, String disease_history) {
		super();
		this.machine_id = machine_id;
		this.dat = dat;
		this.disease_history = disease_history;
	}
	public String getMachine_id() {
		return machine_id;
	}
	public void setMachine_id(String machine_id) {
		this.machine_id = machine_id;
	}
	public Date getDat() {
		return dat;
	}
	public void setDat(Date dat) {
		this.dat = dat;
	}
	public String getDisease_history() {
		return disease_history;
	}
	public void setDisease_history(String disease_history) {
		this.disease_history = disease_history;
	}
	public void setTime(String t) {
		// TODO Auto-generated method stub
		this.time = t;
	}
	
	

}
