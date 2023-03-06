package coride;

import java.sql.*;

public class DataSource {
	
	private String url="jdbc:mysql://localhost:3306/coride";
	private String login="root";
	private String pwd="";
	private Connection cnx;
	public static Connection cn;

	private static DataSource instance;
	
	private DataSource()
	{
		try {
			cnx=DriverManager.getConnection(url,login,pwd);
			System.out.println("connection etablit");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection ConnectDb() {
		 String url="jdbc:mysql://localhost:3306/coride";
		 String login="root";
		String pwd="";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection(url,login,pwd);
				return cn;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
		
	}

	public static DataSource getInstance() 
	{
		if(instance == null)
			instance=new DataSource();
		return instance;
	}
	public Connection getCnx() {
		return cnx;
	}

	
	

}
