package DATABSECONNECTIONS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBINTERGATE1
{
	public static Object  DbConectionresuse1(int x) throws SQLException
	{
		//creat object of connection class
		Connection mycon =null;
		
		//exuxute setof an sql statment
		Statement myst=null;
		
		ResultSet myRs=null;
		//resposne in object
		Object obj=null;
		
		//to manage jdbc driver
	mycon=	DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","root");
		System.out.println("connection sucessfull");
		
		myst =mycon.createStatement();
		
		myRs= myst.executeQuery(SQLQueryy.myquery());
		
		while(myRs.next())
		{
			obj = myRs.getString(1);
		}
	      return obj;
		
		
	}
}
