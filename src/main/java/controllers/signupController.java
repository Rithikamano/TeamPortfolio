package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import models.signupModels;

public class signupController {
	static String dbUrl="jdbc:mysql://localhost:3306/db_1";
    static String dbUname="root";
    static String dbPassword="";
    static String dbDriver="com.mysql.cj.jdbc.Driver";
    signupModels sm1;
	public signupController(signupModels sm1){
		this.sm1=sm1;
	}
	public void toStore() {
		  //System.out.println(name+"\n"+pass+"\n"+email+"\n"+pno);
		  Connection con = null;
	   		try{
	   			Class.forName(dbDriver);  //class not found exception
	 			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
	 			String sql = "insert into elite2 (uname,pass)"
	 					+ "values('"+sm1.getName()+"','"+sm1.getPass()+"')";
	 			Statement s = con.createStatement();
	 			s.execute(sql);
	 		   	con.close();
			} catch(Exception e){      
				e.printStackTrace();
			}
		
	   
	}

}
