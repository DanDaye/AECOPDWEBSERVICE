package com.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;


public class UserDao {
	static String sql = null;
    static db_connection db1 = null;
    static ResultSet ret = null;
    
	public List<User> returnAllUser(){
		List<User> use = new ArrayList<User>();
		sql = "SELECT * FROM `user`";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
        db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷
        try{
        	 ret = db1.pst.executeQuery();
        	 ret.beforeFirst();
        	while(ret.next()){
        		User u = new User();
        		u.setAccount(ret.getString("username"));
        		u.setPassword(ret.getString("password"));
        		u.setMachine_id(ret.getString("machine_id"));
        		use.add(u);
            }
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	if(db1!=null)
				try {
					db1.pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
		return use;
	}
	
	
	public User findUser(String find){
		User user = new User();
		sql = "SELECT * FROM `user` where user.username ="+find;//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
        db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷
        try{
        	 ret = db1.pst.executeQuery();
        	 ret.beforeFirst();
        	while(ret.next()){
        		user.setAccount(ret.getString("username"));
        		user.setMachine_id(ret.getString("machine_id"));
            }
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	if(db1!=null)
				try {
					db1.pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
		return user;
	}
	
	
	public String findPwd(String find){
		String psd = null;
		sql = "SELECT * FROM `user` where user.username ="+find;//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
        db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷
        try{
        	 ret = db1.pst.executeQuery();
        	 ret.beforeFirst();
        	while(ret.next()){
        		psd = ret.getString("password");
            }
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	if(db1!=null)
				try {
					db1.pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
		return psd;
	}
	
	public boolean addUser(User u)
    {//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柟鐟板槻鐏忓懘骞忛悜鑺ユ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍛婄伄闁归鍏橀弫鎾诲棘閵堝棗顏堕梺璺ㄥ枑閺嬪骞忛悜鑺ユ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍝勫祮妞ゆ劦鍓氱�氬綊鏌ㄩ悢鍛婄伄闁瑰嘲鍢查悢顒勬煥閻旇鈻忔い蹇撳鐎氬綊鏌ㄩ悢鍝勫祮妞ゆ劦鍓氱�氬綊鏌ㄩ悢鍛婄伄闁归鏌夐悗浼搭敄閹烘鏅搁柡鍌樺�栫�氬綊鏌ㄩ悢娲绘晭婵犲﹥鎯屾禍鐑藉箯閻戣姤鏅搁柡鍌樺�栫�氬綊鏌ㄩ悢娲绘晭闁跨噦鎷�    
    	     sql = "INSERT INTO user (machine_id,username,password) "+
    		"VALUES (?,?,?)";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
    	     db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷  
        try {        	
            
            db1.conn.setAutoCommit(false);
            db1.pst.setString(1, u.getMachine_id());
            db1.pst.setString(2, u.getAccount());
            db1.pst.setString(3, u.getPassword());
            db1.pst.executeUpdate();//闁圭瑳鍥ㄦ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍛婄伄闁归鍏橀弫鎾绘晸閿燂拷
        	db1.pst.executeBatch();
        	//db1.conn.rollback(savePoint);
        	db1.conn.commit();  
        } catch (SQLException e) {   
        	try{
        		db1.conn.rollback();
        	}catch(SQLException e1){
        		e1.printStackTrace();
        		return false;
        	}
            e.printStackTrace(); 
            return false;
           }
           finally{
        	 try {
                 db1.conn.setAutoCommit(true);
                 db1.close();//闂佽法鍠愰崺鍛村箟鐎ｎ偄顏堕梺璺ㄥ枑閺嬪骞忛悜鑺ユ櫢闁哄倶鍊栫�氾拷   
             } catch (SQLException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }         
        }
         
        return true;   	   	
    }
	
	public boolean modifyUser(User u){
//		System.out.println(u.getAccount()+"  "+u.getPhone());
		if(u.getPassword().equals("")){
			sql = "UPDATE user  SET  user.Ismanager=?, user.IsForbidden=?,user.Phone=? WHERE  user.Account=?";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
	        db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷  
	        try {  
//	        	db1.pst.setInt(1, u.getIsManager());
//	        	db1.pst.setInt(2, u.getIsForbiddent());
//	        	db1.pst.setString(3, u.getPhone());
	        	db1.pst.setString(4, u.getAccount());
	          db1.pst.executeUpdate();//闁圭瑳鍥ㄦ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍛婄伄闁归鍏橀弫鎾绘晸閿燂拷
	        } catch (SQLException e) {  
	           e.printStackTrace();  
	           return false;
	       }finally
	       {   
	   			  db1.close();//闂佽法鍠愰崺鍛村箟鐎ｎ偄顏堕梺璺ㄥ枑閺嬪骞忛悜鑺ユ櫢闁哄倶鍊栫�氾拷
	       }
			return true;
		}else{
		sql = "UPDATE user  SET user.Password=?,  user.Ismanager=?, user.IsForbidden=?,user.Phone=? WHERE  user.Account=?";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
        db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷  
        try {  
        	db1.pst.setString(1, u.getPassword());
//        	db1.pst.setInt(2, u.getIsManager());
//        	db1.pst.setInt(3, u.getIsForbiddent());
//        	db1.pst.setString(4, u.getPhone());
        	db1.pst.setString(5, u.getAccount());
          db1.pst.executeUpdate();//闁圭瑳鍥ㄦ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍛婄伄闁归鍏橀弫鎾绘晸閿燂拷
        } catch (SQLException e) {  
           e.printStackTrace();  
           return false;
       }finally
       {   
   			  db1.close();//闂佽法鍠愰崺鍛村箟鐎ｎ偄顏堕梺璺ㄥ枑閺嬪骞忛悜鑺ユ櫢闁哄倶鍊栫�氾拷
       }
		return true;
	}
	}
	
	public boolean modifyUserPassword(String username,String password){
		sql = "update `user` set `user`.`password` = ? where `user`.username = ?";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
        db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷  
        try {  
        	db1.pst.setString(1, password);
        	db1.pst.setString(2, username);
        	System.out.println(password);
          db1.pst.executeUpdate();//闁圭瑳鍥ㄦ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍛婄伄闁归鍏橀弫鎾绘晸閿燂拷
        } catch (SQLException e) {  
           e.printStackTrace();  
           return false;
       }finally
       {   
   			  db1.close();//闂佽法鍠愰崺鍛村箟鐎ｎ偄顏堕梺璺ㄥ枑閺嬪骞忛悜鑺ユ櫢闁哄倶鍊栫�氾拷
       }
		return true;
	}
	
	public boolean modifyUserMachine(String username,String machine){
		sql = "update `user` set `user`.`machine_id` = ? where `user`.username = ?";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
        db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷  
        try {  
        	db1.pst.setString(1, machine);
        	db1.pst.setString(2, username);
//        	System.out.println(password);
          db1.pst.executeUpdate();//闁圭瑳鍥ㄦ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍛婄伄闁归鍏橀弫鎾绘晸閿燂拷
        } catch (SQLException e) {  
           e.printStackTrace();  
           return false;
       }finally
       {   
   			  db1.close();//闂佽法鍠愰崺鍛村箟鐎ｎ偄顏堕梺璺ㄥ枑閺嬪骞忛悜鑺ユ櫢闁哄倶鍊栫�氾拷
       }
		return true;
	}
	
	
	public boolean modifyUserBirth(String username,String birthDate){
		sql = "update `user` set `user`.`birthdate` = ? where `user`.username = ?";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		try{
			d = format.parse(birthDate);
		}catch(Exception e){
			e.printStackTrace();
		}
		java.sql.Date date = new java.sql.Date(d.getTime());
		System.out.println(date);
        db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷  
        try {  
        	db1.pst.setDate(1,date);
        	db1.pst.setString(2, username);
          db1.pst.executeUpdate();//闁圭瑳鍥ㄦ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍛婄伄闁归鍏橀弫鎾绘晸閿燂拷
        } catch (SQLException e) {  
           e.printStackTrace();  
           return false;
       }finally
       {   
   			  db1.close();//闂佽法鍠愰崺鍛村箟鐎ｎ偄顏堕梺璺ㄥ枑閺嬪骞忛悜鑺ユ櫢闁哄倶鍊栫�氾拷
       }
		return true;
	}
	
	public boolean modifyUserDisease(String username,int disease_history){
		sql = "update `user` set `user`.`disease_history` = ? where `user`.username = ?";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹 
		
        db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷  
        try {  
        	db1.pst.setInt(1,disease_history);
        	db1.pst.setString(2, username);
          db1.pst.executeUpdate();//闁圭瑳鍥ㄦ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍛婄伄闁归鍏橀弫鎾绘晸閿燂拷
        } catch (SQLException e) {  
           e.printStackTrace();  
           return false;
       }finally
       {   
   			  db1.close();//闂佽法鍠愰崺鍛村箟鐎ｎ偄顏堕梺璺ㄥ枑閺嬪骞忛悜鑺ユ櫢闁哄倶鍊栫�氾拷
       }
		return true;
	}
}
