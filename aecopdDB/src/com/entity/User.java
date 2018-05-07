package com.entity;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.dao.UserDao;
public class User {
	private String machine_id;
	private String Account=null;
	private String Password;
	public User(){
		
	}
	public User(String machine_id,String Account,String Password){
		this.machine_id = machine_id;
		this.Account = Account;
		this.Password = Password;
	}
	
	public String getMachine_id() {
		return machine_id;
	}
	public void setMachine_id(String machine_id) {
		this.machine_id = machine_id;
	}
	
	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		Account = account;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public void setBitrhDate(String BirthDate){
		BirthDate = BirthDate;
	}
	
	public User findUser(String find){
		return  new UserDao().findUser(find);
	}
	
	//��¼&��������
	public List<User> returnAllUser(){
		return new UserDao().returnAllUser();
	}
	
	public  int getAge(Date birthDay) throws Exception {  
        Calendar cal = Calendar.getInstance();  
  
        if (cal.before(birthDay)) {  
            throw new IllegalArgumentException(  
                    "The birthDay is before Now.It's unbelievable!");  
        }  
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthDay);  
  
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
  
        int age = yearNow - yearBirth;  
  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) age--;  
            }else{  
                age--;  
            }  
        }  
        return age;  
    } 
	
}

