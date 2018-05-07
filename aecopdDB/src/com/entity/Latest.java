package com.entity;

public class Latest {
	private  String Dat;
	private String machine_id;
	private String heart_rate;
	private String boold_rate_up;
	private String boold_rate_down;
	private String breath_rate;
	private String BMI;
	private String cough_level;
	private String temperature;
	private String relivate;
	private int level;
	private String fev1;
	public Latest(){
		
	}
	public Latest(String machine_id,String heart_rate,String boold_rate_up,String boold_rate_down,String breath_rate,String BMI,String cough_level,String temperature,String relivate,String fev1){
		this.machine_id = machine_id;
		this.heart_rate = heart_rate;
		this.boold_rate_up = boold_rate_up;
		this.boold_rate_down = boold_rate_down;
		this.breath_rate = breath_rate;
		this.BMI = BMI;
		this.cough_level = cough_level;
		this.temperature = temperature;
		this.relivate = relivate;
		this.fev1 = fev1;
	}
	public String getmachine_id() {
		return machine_id;
	}
	public void setmachine_id(String machine_id) {
		machine_id = machine_id;
	}
	public String getHeart_rate() {
		return heart_rate;
	}
	public void setHeart_rate(String heart_rate) {
		this.heart_rate = heart_rate;
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
	public String getBreath_rate() {
		return breath_rate;
	}
	public void setBreath_rate(String breath_rate) {
		this.breath_rate = breath_rate;
	}
	public String getBMI() {
		return BMI;
	}
	public void setBMI(String bMI) {
		BMI = bMI;
	}
	public String getCough_level() {
		return cough_level;
	}
	public void setCough_level(String cough_level) {
		this.cough_level = cough_level;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getRelivate() {
		return relivate;
	}
	public void setRelivate(String relivate) {
		this.relivate = relivate;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getMachine_id() {
		return machine_id;
	}
	public void setMachine_id(String machine_id) {
		this.machine_id = machine_id;
	}
	public String getFev1() {
		return fev1;
	}
	public void setFev1(String fev1) {
		this.fev1 = fev1;
	}
	public String getDat() {
		return Dat;
	}
	public void setDat(String dat) {
		Dat = dat;
	}
	
	
	

}
