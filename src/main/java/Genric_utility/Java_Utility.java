package Genric_utility;

import java.util.Random;

public class Java_Utility {
	
	/**
	 * This is the method to avoid duplicate
	 * @return Abhishek
	 */
	public int getRandom() {
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}

}
