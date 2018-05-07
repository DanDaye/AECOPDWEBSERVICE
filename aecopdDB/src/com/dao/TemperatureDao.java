package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.entity.Temperature;



public class TemperatureDao {

	static String sql = null;
    static db_connection db1 = null;
    static ResultSet ret = null;
    public List<Temperature> findTemperature(String find){
		List<Temperature> l = new ArrayList<Temperature>();
		sql = "SELECT * FROM `temperatureRate` where temperatureRate.machine_id ="+find+" order by temperatureRate.Date";//SQL闁跨喐鏋婚幏鐑芥晸閿燂拷  
        db1= new db_connection(sql);//闁跨喐鏋婚幏鐑芥晸閺傘倖瀚筪b_connection闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�
        try{
        	 ret = db1.pst.executeQuery();
        	 ret.beforeFirst();
        	while(ret.next()){
        		Temperature h = new Temperature();
        		Timestamp t = ret.getTimestamp("Date");
        		h.setDate(t.toString());
        		h.settemperature(ret.getString("temperature"));
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

}
