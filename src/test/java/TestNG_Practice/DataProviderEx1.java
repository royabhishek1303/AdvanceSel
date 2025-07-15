package TestNG_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	
	@Test(dataProvider = "getdata")
	public void bookTickets(String src , String dest, int noOfPpl) {
		System.out.println("Book tickets from "+src+" to "+dest+" ----------> total number of People "+noOfPpl+"");
	}
	
	@DataProvider
	public Object[] [] getdata() {
		
		Object[][] obj = new Object[3][3];
	    obj[0][0]="Banglore";
	    obj[0][1]="goa";
	    obj[0][2]=10;
	    
	    obj[1][0]="delhi";
	    obj[1][1]="bihar";
	    obj[1][2]=20;

	    
	    obj[2][0]="punjab";
	    obj[2][1]="Austrailia";
	    obj[2][2]=30;

		
		return obj;
		
		
	}

}

