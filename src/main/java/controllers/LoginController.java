package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import models.LoginModel;
import models.signupModels;
   

public class LoginController {
	static String dbUrl="jdbc:mysql://localhost:3306/db_1";
    static String dbUname="root";
    static String dbPassword="";
    static String dbDriver="com.mysql.cj.jdbc.Driver";
    LoginModel lm1;
	public LoginController(LoginModel lm1){
		this.lm1=lm1;
	}
	public boolean toStore(){
		 Connection con = null;
	   		try{
	   			Class.forName(dbDriver);  //class not found exception
	 			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
	 			String sql = "select * from elite2 where uname='"+lm1.getName()+"' and pass='"+lm1.getPass()+"'";	 		
	 		    //String sql="SELECT JSON_ARRAYAGG(JSON_OBJECT('uname', lm.getName(),'pass',lm.getPass)) from elite2";
	 		  
	 			Statement s = con.createStatement();
	 			ResultSet rs=s.executeQuery(sql);
	 			 
	 			if(rs.next()) {
	 				System.out.println(rs.getString(1));
//	 				try {
//	 					
//	 				     JSONObject jsonObject = new JSONObject("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");
//	 				}catch (JSONException err){
//	 				     Log.d("Error", err.toString());
//	 				}
	 				con.close();
	 				return true;
	 			}
	 			
	 			con.close();
	 		   	
			 }catch(Exception e){      
				e.printStackTrace();
			 }
	   		return false;
		
	}
	

}
