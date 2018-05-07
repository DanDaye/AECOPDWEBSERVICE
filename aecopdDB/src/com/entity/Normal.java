package com.entity;

public class Normal {
	String fev1;
	String heart_rate;
	String boold_rate_up;
	String boold_rate_down;
	String breath_rate;
	String BMI;
	
	public Normal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Normal(String fev1, String heart_rate, String boold_rate_up, String boold_rate_down, String breath_rate,
			String bMI) {
		super();
		this.fev1 = fev1;
		this.heart_rate = heart_rate;
		this.boold_rate_up = boold_rate_up;
		this.boold_rate_down = boold_rate_down;
		this.breath_rate = breath_rate;
		BMI = bMI;
	}

	public String getFev1() {
		return fev1;
	}

	public void setFev1(String fev1) {
		this.fev1 = fev1;
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
	
	
	
}
