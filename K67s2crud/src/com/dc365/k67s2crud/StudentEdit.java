package com.dc365.k67s2crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

public class StudentEdit extends ActionSupport
{
	private String ID = "";
	private String Name = "";
	
	public String getID()
	{
		return ID;
	}
	public void setID(String iD)
	{
		ID = iD;
	}
	public String getName()
	{
		return Name;
	}
	public void setName(String name)
	{
		Name = name;
	}
	
	@Override
	public String execute() throws Exception
	{
		// 编辑数据
		Connection con = null;    
		Statement stmt = null;    
		
		String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=dbStudent;user=sa;password=sql";//sa身份连接
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			con = DriverManager.getConnection(url);  
			
			String strSql = "update Student set Name='" + getName() + "' where ID='" + getID() + "'";    
			stmt = con.createStatement();  
			stmt.execute(strSql);
		}
		catch (Exception e) 
		{
			return "Error";
		}
				
		return "Success";
		
	}
	
	
	

}
