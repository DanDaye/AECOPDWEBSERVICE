package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.entity.BMIRate;


public class BMIRateDao {

	static String sql = null;
    static db_connection db1 = null;
    static ResultSet ret = null;
    public List<BMIRate> findBMIRate(String find){
		List<BMIRate> l = new ArrayList<BMIRate>();
		sql = "SELECT * FROM `BMIRate` where BMIRate.machine_id ="+find+" order by BMIRate.Date";//SQL闁跨喐鏋婚幏鐑芥晸閿燂拷  
        db1= new db_connection(sql);//闁跨喐鏋婚幏鐑芥晸閺傘倖瀚筪b_connection闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�
        try{
        	 ret = db1.pst.executeQuery();
        	 ret.beforeFirst();
        	while(ret.next()){
        		BMIRate h = new BMIRate();
        		Timestamp t = ret.getTimestamp("Date");
        		h.setDate(t.toString());
        		h.setbmi(ret.getString("bmi"));
        		l.add(h);
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
        if(l.size()<=5){
        	return l;
        }else{
        	
        	return l.subList(l.size()-5, l.size());
        }
	}
    public boolean addBMIRate(String machine_id,String bmi)
    {//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柟鐟板槻鐏忓懘骞忛悜鑺ユ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍛婄伄闁归鍏橀弫鎾诲棘閵堝棗顏堕梺璺ㄥ枑閺嬪骞忛悜鑺ユ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍝勫祮妞ゆ劦鍓氱�氬綊鏌ㄩ悢鍛婄伄闁瑰嘲鍢查悢顒勬煥閻旇鈻忔い蹇撳鐎氬綊鏌ㄩ悢鍝勫祮妞ゆ劦鍓氱�氬綊鏌ㄩ悢鍛婄伄闁归鏌夐悗浼搭敄閹烘鏅搁柡鍌樺�栫�氬綊鏌ㄩ悢娲绘晭婵犲﹥鎯屾禍鐑藉箯閻戣姤鏅搁柡鍌樺�栫�氬綊鏌ㄩ悢娲绘晭闁跨噦鎷�    
    	     sql = "INSERT INTO `bmirate` (machine_id,Date,bmi) "+
    		"VALUES (?,?,?)";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
    	     db1= new db_connection(sql);//闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氱b_connection闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氾拷  
        try {        	
            
            db1.conn.setAutoCommit(false);
            db1.pst.setString(1, machine_id);
            db1.pst.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            db1.pst.setString(3, bmi);
//            System.out.println("BMI:"+b.getBmi());
            db1.pst.executeUpdate();//闁圭瑳鍥ㄦ櫢闁哄倶鍊栫�氬綊鏌ㄩ悢鍛婄伄闁归鍏橀弫鎾绘晸閿燂拷
//            db1.pst.execute();
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

}
