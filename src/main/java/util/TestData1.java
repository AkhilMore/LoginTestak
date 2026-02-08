package util;

import org.testng.annotations.DataProvider;

public class TestData1 {

	@DataProvider(name="testdata1")
	public static Object[][]logindata(){
		return new Object[][] {
			{"student","Password123","Success"},
			{"InvalidUser","InvalidPassword", "Fail"},
			{"Validuser","Invalidpassword","Fail"},
			{"Invaliduser","Validpassword","Fail"}
			
		};
	}

}
