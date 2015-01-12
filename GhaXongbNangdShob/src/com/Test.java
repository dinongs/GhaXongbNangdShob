package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DataUtil.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
       SingleConnection instance=SingleConnection.getSingleInstance();
       try {
		Connection conn=instance.getConn();
		Statement stm=conn.createStatement();
	    String sql="Select * from stdlib where ndeudx like\'"+"b"+"%\'";
	    ResultSet rs=stm.executeQuery(sql);
	    int i=0;
	    while(rs.next())
	    {
	    	System.out.print(rs.getInt(1));
	    	System.out.println(rs.getString(2));
	    	
	    	if(i>10)
            break;	
	    	i++;
	    }
	    instance.Close(conn, stm, rs);
	     }catch(SQLException se){   
	    System.out.println("数据库连接失败！");   
	    se.printStackTrace() ;   
	     }
       
	}

}
