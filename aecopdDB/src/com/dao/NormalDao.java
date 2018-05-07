package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.Normal;

public class NormalDao {
	static String sql = null;
    static db_connection db1 = null;
    static ResultSet ret = null;
    public Normal findNormal(String find){
		Normal u = new Normal();
		sql = "SELECT * FROM `normal` where  normal.machine_id ="+find+" ";//SQL闁跨喐鏋婚幏鐑芥晸閿燂拷  
        db1= new db_connection(sql);//闁跨喐鏋婚幏鐑芥晸閺傘倖瀚筪b_connection闁跨喐鏋婚幏鐑芥晸閺傘倖瀚�
        try{
        	 ret = db1.pst.executeQuery();
        	 ret.beforeFirst();
        	while(ret.next()){
//        		Latest u = new Latest();
//        		u.setmachine_id(ret.getString("machine_id"));
        		u.setHeart_rate(ret.getString("heart_rate"));
        		u.setBoold_rate_up(ret.getString("boold_rate_up"));
        		u.setBoold_rate_down(ret.getString("boold_rate_down"));
        		u.setBreath_rate(ret.getString("breath_rate"));
        		u.setBMI(ret.getString("BMI"));
        		u.setFev1(ret.getString("fev1"));
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
    
    public boolean ChangeNormal(Normal n,String machine_id){
    	sql = "UPDATE `normal`  SET  normal.fev1=?, normal.heart_rate = ?,normal.boold_rate_up = ? ,normal.boold_rate_down = ? ,normal.breath_rate = ? , normal.BMI=? WHERE  normal.machine_id=?";
    	 db1= new db_connection(sql);
    	try{
    		db1.pst.setString(1, n.getFev1());
    		db1.pst.setString(2,n.getHeart_rate());
    		db1.pst.setString(3, n.getBoold_rate_up());
    		db1.pst.setString(4, n.getBoold_rate_down());
    		db1.pst.setString(5, n.getBMI());
    		db1.pst.setString(6, n.getBreath_rate());
    		db1.pst.setString(7,machine_id);
    		db1.pst.executeUpdate();
    	}catch(SQLException e){
    		e.printStackTrace();
    		return false;
    	}finally{
    		db1.close();
    	}
    	return true;
    }
    
    public boolean AddNormal(String machine_id,Normal n){
    	sql = "INSERT INTO normal (machine_id,fev1,heart_rate,breath_rate,BMI,boold_rate_up,boold_rate_down,cough_level) "+
        		"VALUES (?,?,?,?,?,?,?,?)";//SQL闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柨鐕傛嫹  
    	db1= new db_connection(sql);
    	System.out.println(sql);
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
    
//    public static void main(String[] args){
//    	Normal  n = new Normal();
//    	n.setFev1("12");
//    	n.setBMI("13");
//    	n.setBoold_rate_up("123");
//    	n.setBoold_rate_down("124");
//    	n.setBreath_rate("123");
//    	n.setHeart_rate("123");
//    	System.out.println(new NormalDao().AddNormal("125", n));
//    }
}
