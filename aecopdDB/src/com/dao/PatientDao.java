package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.entity.Patient;
import com.entity.User;

public class PatientDao {
	static String sql = null;
    static db_connection db1 = null;
    static ResultSet ret = null;
	public Patient findPatient(String find){
		Patient u = new Patient();
		sql = "SELECT * FROM `patient` where patient.machine_id ="+find+" ";//SQL闁跨喐鏋婚幏鐑芥晸閿燂拷  
        db1= new db_connection(sql);//闁跨喐鏋婚幏鐑芥晸閺傘倖瀚筪b_connection闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�
        try{
        	 ret = db1.pst.executeQuery();
        	 ret.beforeFirst();
        	while(ret.next()){
//        		Latest u = new Latest();
        		u.setMachine_id(ret.getString("machine_id"));
        		u.setDisease_history(ret.getString("disease_history"));
        		u.setDat(ret.getDate("birthday"));
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
	
	public boolean modifyPatientBirth(String machine_id,String birthDate){
		sql = "update `patient` set `patient`.`birthday` = ? where `patient`.machine_id = ?";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹 
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
        	db1.pst.setString(2, machine_id);
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
	
	public boolean modifyPatientDisease(String machine_id,int disease_history){
		sql = "update `patient` set `patient`.`disease_history` = ? where `patient`.machine_id = ?";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹 
		
        db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷  
        try {  
        	db1.pst.setInt(1,disease_history);
        	db1.pst.setString(2, machine_id);
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
	
	public boolean addPatient(Patient u)
    {//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柟鐟板槻鐏忓懘骞忛悜鑺ユ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍛婄伄闁归鍏橀弫鎾诲棘閵堝棗顏堕梺璺ㄥ枑閺嬪骞忛悜鑺ユ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍝勫祮妞ゆ劦鍓氱�氬綊鏌ㄩ悢鍛婄伄闁瑰嘲鍢查悢顒勬煥閻旇鈻忔い蹇撳鐎氬綊鏌ㄩ悢鍝勫祮妞ゆ劦鍓氱�氬綊鏌ㄩ悢鍛婄伄闁归鏌夐悗浼搭敄閹烘鏅搁柡鍌樺�栫�氬綊鏌ㄩ悢娲绘晭婵犲﹥鎯屾禍鐑藉箯閻戣姤鏅搁柡鍌樺�栫�氬綊鏌ㄩ悢娲绘晭闁跨噦鎷�    
    	     sql = "INSERT INTO patient (machine_id,birthday,disease_history) "+
    		"VALUES (?,?,?)";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
    	     db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷  
        try {        	
            
            db1.conn.setAutoCommit(false);
            db1.pst.setString(1, u.getMachine_id());
            db1.pst.setDate(2, u.getDat());
            db1.pst.setString(3, u.getDisease_history());
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
	
//	public static void main(String[] args){
//		System.out.println(new PatientDao().modifyPatientDisease("123", 1));
//	}
}
