package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.Machine;

public class MachineDao {
	static String sql = null;
    static db_connection db1 = null;
    static ResultSet ret = null;
    
    public MachineDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Machine findMachine(String find){
		Machine u = null;
		sql = "SELECT * FROM `Machine` where Machine.machine_id ="+find+" ";//SQL闁跨喐鏋婚幏鐑芥晸閿燂拷  
        db1= new db_connection(sql);//闁跨喐鏋婚幏鐑芥晸閺傘倖瀚筪b_connection闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�
        try{
        	 ret = db1.pst.executeQuery();
        	 ret.beforeFirst();
        	while(ret.next()){
        		u = new Machine();
//        		Machine u = new Machine();
        		u.setMachine_id(ret.getString("machine_id"));
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
}
