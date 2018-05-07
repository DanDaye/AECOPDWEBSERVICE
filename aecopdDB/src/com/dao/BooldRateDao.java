package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.entity.BooldRate;


public class BooldRateDao {

	static String sql = null;
    static db_connection db1 = null;
    static ResultSet ret = null;
    public List<BooldRate> findBooldRate(String find){
		List<BooldRate> l = new ArrayList<BooldRate>();
		sql = "SELECT * FROM `BooldRate` where BooldRate.machine_id ="+find+" order by BooldRate.Date";//SQL闁跨喐鏋婚幏鐑芥晸閿燂拷  
        db1= new db_connection(sql);//闁跨喐鏋婚幏鐑芥晸閺傘倖瀚筪b_connection闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�
        try{
        	 ret = db1.pst.executeQuery();
        	 ret.beforeFirst();
        	while(ret.next()){
        		BooldRate h = new BooldRate();
        		Timestamp t = ret.getTimestamp("Date");
        		h.setDat(t.toString());
        		h.setBoold_rate_up(ret.getString("boold_rate_up"));
        		h.setBoold_rate_down(ret.getString("boold_rate_down"));
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
