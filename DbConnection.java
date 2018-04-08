package DataObjects;
import java.sql.DriverManager;
import java.sql.Connection;
public class DbConnection {
	public static Connection Conn=null;
	public static Connection  GetDbConnection() 
	{
		try
		{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		//Conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-U51L9SR\\SQL2014:13223;user=sa;password=abc;database=SecureDb");
		Conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-T2STH68\\MSSQLSERVER:1433;user=sa;password=abc;database=SecureDb");
	    
		System.out.println("Connection established");
		System.out.println("test");
		}
		catch(Exception ex)
		{System.out.println("connection not established"+ex.getLocalizedMessage());

		}	return Conn;
	 }
	public static void mains(String arggs[])
	{
		 try{
	 Connection Con=GetDbConnection();

		Con.close(); 
	  }
	 catch(Exception ex)
	 {
	 }}
	
}

