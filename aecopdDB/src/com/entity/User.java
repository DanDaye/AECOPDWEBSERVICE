package com.entity;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.dao.UserDao;
public class User {
	private String machine_id;
	private String Account=null;
	private String Password;
	private Date BirthDate;
	private String time;
	private int Disease_histroy;
	public User(){
		
	}
	public User(String machine_id,String Account,Date BirthDate,String Password,int disease_history){
		this.machine_id = machine_id;
		this.Account = Account;
		this.Password = Password;
		this.BirthDate = BirthDate;
		this.Disease_histroy = disease_history;
	}
	
	public String getMachine_id() {
		return machine_id;
	}
	public void setMachine_id(String machine_id) {
		this.machine_id = machine_id;
	}
	public int getDisease_histroy() {
		return Disease_histroy;
	}
	public void setDisease_histroy(int disease_histroy) {
		Disease_histroy = disease_histroy;
	}
	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
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
	public java.sql.Date getBirthDate(){
		return BirthDate;
	}
	public void setBitrhDate(String BirthDate){
		BirthDate = BirthDate;
	}
	public int getDisease_history(){
		return Disease_histroy;
	}
	public void setDisease_history(int Disease_histroy){
//		System.out.println("this"+Disease_histroy);
		this.Disease_histroy = Disease_histroy;
//		System.out.println("here:"+this.Disease_histroy);
	}
	
	//�û�����
//	public boolean addUser(String Account,String Password,Date BirthDate,int Disease_history){
//		User u = new User();
//		u.setAccount(Account);
//		u.setPassword(Password);
//		return new UserDao().addUser(u);
//	}
//	public boolean modifyUser(String Account,String Password,Date BirthDate,int Disease_history){
//		User u = new User(Account,Password,BirthDate,Disease_history);
//		return new UserDao().modifyUser(u);
//	}
//	public boolean deleteUser(String Account){
//		User u = new User();
//		u.setAccount(Account);
//		return new UserDao().deleteUser(u);
//	}
	public User findUser(String find){
		return  new UserDao().findUser(find);
	}
	
	
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	
//	public static void main(String[] args) throws Exception{
//		User u = new UserDao().findUser("12345");
//		System.out.println(u.getBirthDate());
//		System.out.println(u.getAge(u.getBirthDate()));
//	}
	
}

