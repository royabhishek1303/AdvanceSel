package TestNG_Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class SampleTest {
	
	@Test(invocationCount = -1)
	public void createProduct() {
		
		System.out.println("Product is create");
	}
	@Test(dependsOnMethods = "createProduct", priority = 1)
	public void updateProduct() {
	
		System.out.println("Product is update");

}
	@Test(dependsOnMethods = {"updateProduct","createProduct"})
	public void delectProduct() {
	System.out.println("Product is delete");
}
}
