package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class db_connection {
	public static final String url = "jdbc:mysql://123.207.20.100:3306/copd";      //内网IP：10.135.46.66 公网IP：123.207.57.24
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "";  
  
    public Connection conn = null;  
    public PreparedStatement pst = null;  
  
    public db_connection(String sql) {  
    	// TODO Auto-generated constructor stub
        try {  
            Class.forName(name);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接  
            pst = conn.prepareStatement(sql);//准备执行语句 
//            System.out.println("connection success");
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
   

	public void close() {  
        try { 
        	this.pst.close(); 
            this.conn.close();  
             
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  

}
