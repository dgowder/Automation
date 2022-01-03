package testDataHandling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData {

	@DataProvider(name="getUserData")
	public Object[][] getDataFromProvider()
	{
		return new Object[][]
				{
			{"admin","adminc"},
			{"dgowder","dgowder2"}
			
				};
	}
	
@Test(dataProvider = "getUserData")
public void showData(String un,String pwd)
{ 
	System.out.println(un);
	System.out.println(pwd);
}
}