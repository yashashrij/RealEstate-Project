package com.clearcode.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBUtils {
	
	static Properties p;
	public static Object[][] getDBTable(String query,int col){
		PropertyUtils pu = new PropertyUtils();
		p = pu.loadProperty("Project.properties");
		Object[][] data = new Object[1][col];
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			//driver_type:category://host:port/db_name
			"jdbc:mysql://"+p.getProperty("db.host")+":"+p.getProperty("db.port")+"/"+p.getProperty("db.name"),p.getProperty("db.username"),p.getProperty("db.password"));  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement(); 
			PreparedStatement pstat = con.prepareStatement(query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=pstat.executeQuery();
			rs.last();
			int rows = rs.getRow();
			data = new Object[rows][col].clone(); //data[10][3] => {Object[3],Object[3],Object[3],.......}
			rs.first();
			int j=0;
			while(rs.next()) {
				Object[] row = new Object[col];
				for(int i=0;i<col;i++)
				{
					row[i] = rs.getObject(i+1);
				}
				data[j] = row;
				j++;
			}
			System.out.println(rs.getObject(1)+"  "+rs.getObject(2)+"  "+rs.getObject(3));  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
	return data;
	}
}
