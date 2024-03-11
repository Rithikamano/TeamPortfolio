package batchweb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SignupController {
	static String dbUrl="jdbc:mysql://localhost:3306/db_1";
    static String dbUname="root";
    static String dbPassword="";
    static String dbDriver="com.mysql.cj.jdbc.Driver";
	String uname,pass;
	SignupController(String n,String ps){
		uname=n;
		pass=ps;
	}
	void toStore() {
		  System.out.println(uname+"\n"+pass);
		  Connection con = null;
	   		try{
	   			Class.forName(dbDriver);  //class not found exception
	 			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
	 			String sql = "insert into elite2 (uname,pass)"+ "values('"+uname+"','"+pass+"')";
	 			Statement s = con.createStatement();
	 			s.execute(sql);
	 		   	con.close();
			} catch(Exception e){      
				e.printStackTrace();
			}   
		}

}
