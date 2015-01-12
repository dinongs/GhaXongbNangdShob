package com;

import java.sql.*;



public class Conn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e)
		{
			System.out.print("没找到驱动");
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/test" ;    
	    String username = "root" ;   
	    String password = "ld123456" ;   
	     try{   
	    Connection con =    
	             DriverManager.getConnection(url , username , password ) ; 
	    Statement stm=con.createStatement();
	    String sql="select * from u";
	    ResultSet rs=stm.executeQuery(sql);
	    while(rs.next())
	    {
	    	System.out.print(rs.getInt(1));
	    	System.out.println(rs.getString(2));
	    }
	     }catch(SQLException se){   
	    System.out.println("数据库连接失败！");   
	    se.printStackTrace() ;   
	     }

	}

}
