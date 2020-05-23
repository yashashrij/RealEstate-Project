package dataProvider;

import org.testng.annotations.DataProvider;

import com.clearcode.utils.ExcelUtils;

public class LoginData {
	@DataProvider
	public Object[][] negativeLogin(){
		return ExcelUtils.getData("TestData.xls", "NegativeLogin");
	}
}
