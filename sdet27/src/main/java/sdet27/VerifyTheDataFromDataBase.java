package sdet27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheDataFromDataBase {
	public static void main(String[] args) throws Throwable {
		
		String expectedProjectID="jid";
		 Driver driver = new Driver();
		 DriverManager.registerDriver(driver);
		 
		 //Establish the connection with database
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		 
         //issue the statement 
		 Statement statement = connection.createStatement();
		 
		 //execute querries
		 ResultSet result=statement.executeQuery("select * from Studentsinfo");
		 while(result.next()) {
			 if(result.getString(2).equals(expectedProjectID)) {
				 System.out.println("passed");
			 }
		 }
		 //close the database connection
		  connection.close();
		
	}

}
