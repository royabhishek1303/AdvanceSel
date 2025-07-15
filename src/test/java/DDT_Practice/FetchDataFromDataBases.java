package DDT_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDataBases {
	public static void main(String[] args) throws Throwable {
		
		//Regiseter load my-sql data base--
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2 get Connect to data bases
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Abhishek@123");
	    
		//step3 create sql statement
		
		Statement state = conn.createStatement();
		String query = "select * from users";
		
		ResultSet result = state.executeQuery(query);
		//System.out.println(query + "\t");
		
		while(result.next()) {
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3));
		}
		
		// close the conn
		conn.close();

	
	
	
	}
	
	

}
