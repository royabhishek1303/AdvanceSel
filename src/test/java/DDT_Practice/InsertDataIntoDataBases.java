package DDT_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDataBases {
	public static void main(String[] args) throws Throwable {
	
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2 get Connect to data bases
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Abhishek@123");
	    
		//step3 create sql statement
		
		Statement state = conn.createStatement();
		String query = "INSERT INTO Trainers (id,name, trainerName) VALUES ( 2,'abhishek', 'Rani')";
        int result = state.executeUpdate(query);
        
        if(result==1) {
        	System.out.println("Data inserted");
        }else {
        	System.out.println("Data not inserted");
        }
	}
	

	
	
}
