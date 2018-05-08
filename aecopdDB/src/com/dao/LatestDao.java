package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Latest;
import com.entity.Normal;


public class LatestDao {
	static String sql = null;
    static db_connection db1 = null;
    static ResultSet ret = null;
    public Latest findLatest(String find){
		Latest u = new Latest();
		sql = "SELECT * FROM `latest` where latest.machine_id ="+find+" ";//SQL闁跨喐鏋婚幏鐑芥晸閿燂拷  
        db1= new db_connection(sql);//闁跨喐鏋婚幏鐑芥晸閺傘倖瀚筪b_connection闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�
        try{
        	 ret = db1.pst.executeQuery();
        	 ret.beforeFirst();
        	while(ret.next()){
//        		Latest u = new Latest();
        		u.setmachine_id(ret.getString("machine_id"));
        		u.setHeart_rate(ret.getString("heart_rate"));
        		u.setBoold_rate_up(ret.getString("boold_rate_up"));
        		u.setBoold_rate_down(ret.getString("boold_rate_down"));
        		u.setBreath_rate(ret.getString("breath_rate"));
        		u.setBMI(ret.getString("BMI"));
        		u.setCough_level(ret.getString("cough_level"));
        		u.setTemperature(ret.getString("temperature"));
        		u.setRelivate(ret.getString("relivate"));
        		u.setLevel(ret.getInt("level"));
        		u.setFev1(ret.getString("fev1"));
        		Timestamp t = ret.getTimestamp("Date");
        		
        		u.setDat(t.toString());
//        		l.add(u);
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
		return u;
	}
    
    public boolean Change_Cough_Level(String machine_id,int cough_level){
    	sql = "update `latest` set `latest`.`cough_level` = ? ,`latest`.`Date` = ? where `latest`.machine_id = ?";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
    	db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷  
        try {  
        	db1.pst.setInt(1, cough_level);
        	db1.pst.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
        	db1.pst.setString(3, machine_id);
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
    
    public boolean AddLatestDao(String machine_id,Normal n){
    	sql = "INSERT INTO latest (machine_id,fev1,heart_rate,breath_rate,BMI,boold_rate_up,boold_rate_down,cough_level,temperature,relivate,Date,level) "+
        		"VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
    	db1= new db_connection(sql);
    	try{
    		db1.conn.setAutoCommit(false);
    		db1.pst.setString(1, machine_id);
    		db1.pst.setString(2, n.getFev1());
    		db1.pst.setString(3, n.getHeart_rate());
    		db1.pst.setString(4, n.getBreath_rate());
    		db1.pst.setString(5, n.getBMI());
    		db1.pst.setString(6, n.getBoold_rate_up());
    		db1.pst.setString(7, n.getBoold_rate_down());
    		db1.pst.setString(8, "0");
    		db1.pst.setString(9, "0");
    		db1.pst.setString(10, "0");
    		db1.pst.setTimestamp(11,new Timestamp(System.currentTimeMillis()));
    		db1.pst.setString(12, "0");
    		db1.pst.executeUpdate();
    		db1.pst.executeBatch();
    		db1.conn.commit();
    	}catch (SQLException e) {   
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
    
    public boolean AddLatestDao(String machine_id,Normal n,String temperature,String relivate){
    	sql = "INSERT INTO latest (machine_id,fev1,heart_rate,breath_rate,BMI,boold_rate_up,boold_rate_down,cough_level,temperature,relivate,Date,level) "+
        		"VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
    	db1= new db_connection(sql);
    	try{
    		db1.conn.setAutoCommit(false);
    		db1.pst.setString(1, machine_id);
    		db1.pst.setString(2, n.getFev1());
    		db1.pst.setString(3, n.getHeart_rate());
    		db1.pst.setString(4, n.getBreath_rate());
    		db1.pst.setString(5, n.getBMI());
    		db1.pst.setString(6, n.getBoold_rate_up());
    		db1.pst.setString(7, n.getBoold_rate_down());
    		db1.pst.setString(8, "0");
    		db1.pst.setString(9, temperature);
    		db1.pst.setString(10, relivate);
    		db1.pst.setTimestamp(11,new Timestamp(System.currentTimeMillis()));
    		db1.pst.setString(12, "0");
    		db1.pst.executeUpdate();
    		db1.pst.executeBatch();
    		db1.conn.commit();
    	}catch (SQLException e) {   
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

}
