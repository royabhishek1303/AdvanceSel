package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	

	@Test
	public void m1() {
		System.out.println("step1");
		System.out.println("step1");
		Assert.assertEquals("A", "B");
		System.out.println("step1");
		System.out.println("step1");

		
	}
	@Test
	public void m2() {
		String act="Qspiders";
		String ext="Qspiders";
		Assert.assertEquals(act, ext);
	}
	@Test
	public void m3() {
	    int a = 10;
	    int b= 1;
		Assert.assertEquals(a, b, "Assert fails");
		System.out.println("Assert pass");
	}
	@Test
	public void m4() {
	    int a = 10;
	    int b= 1;
		Assert.assertNotEquals(a, b, "Assert Equal");
		System.out.println("Assert Not Equal");
	}
    @Test
	public void m5() {
	  String extdata = "abhi";
	  String actData="abhi";
	  Assert.assertTrue(actData.equals(extdata),"Assert fail");
	  System.out.println("Assert pass");
	}
    @Test
   	public void m6() {
   	  String extdata = "abhi";
   	  String actData="abhI";
   	  Assert.assertTrue(actData.equals(extdata),"Assert fail");
   	  System.out.println("Assert pass");
   	}
    @Test
   	public void m7() {
   	  String extdata = "Welcome";
   	  String actData="Welcome ";
   	  Assert.assertFalse(actData.equals(extdata),"Assert fail");
   	  System.out.println("Assert pass");
   	}
    @Test
   	public void m8() {
   	  String extdata = "Welcome";
   	  String actData="Welcome";
   	  Assert.assertFalse(actData.equals(extdata),"Assert fail");
   	  System.out.println("Assert pass");
   	}
    @Test
	public void m9() {
	   	  String extdata = null;
	   	  Assert.assertNull(extdata,"Assert fail");
	   	  System.out.println("Assert pass");
	   	}
	    @Test
	    public void m10() {
		   	  String extdata = "abc";
		   	  Assert.assertNull(extdata,"Assert fail");
		   	  System.out.println("Assert pass");
		   	}
	    @Test
		public void m11() {
		   	  String extdata = "abc";
		   	  Assert.assertNotNull(extdata,"Assert fail");
		   	  System.out.println("Assert pass");
		   	}
		    @Test
		    public void m12() {
			   	  String extdata = null;
			   	  Assert.assertNull(extdata,"Assert fail");
			   	  System.out.println("Assert pass");
			   	}	    
	    

}
