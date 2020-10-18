package com.dc365.k67s2crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

// 学生添加

public class StudentAdd extends ActionSupport
{
	// 变量 *********************************************************************
	private String ID = "";		// 学号
	private String Name = "";	// 姓名
	private String msg = "";	// 信息
	
	
	// 函数 *********************************************************************
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
	
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	
	
	// 重载ActionSupport中的函数execute(),实现数据的添加
	@Override
	public String execute() throws Exception
	{
		// 添加数据
		Connection con = null;    
		Statement stmt = null;    
		
		String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=dbStudent;user=sa;password=sql";//sa身份连接
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			con = DriverManager.getConnection(url);  
			
			String strSql = "insert into Student values('" + getID() + "','" + getName() + "')";    
			stmt = con.createStatement();  
			stmt.execute(strSql);
		}
		catch (Exception e) 
		{
			setMsg("学号重复!");
			return "Error";
		}
		
		return "Success";
		
	}
	
	
	
	
}
