package Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import pages_eParwana.Login_Page;
import utility_eParwana.BaseClass;
import utility_eParwana.ExcelReader;

public class Login_Test extends BaseClass{
	
Login_Page lp;
	
	SoftAssert softAssert1 = new SoftAssert();
	public static String Excel_path;
	public static String gender = "";
	public static String stream = "";




@Test
@Parameters("Excel_path")
public void setup(String Excel_path1) throws Exception {
	Excel_path = Excel_path1;
	ExcelReader er = new ExcelReader(Excel_path, 0);
	
	applicantlogin();
	
	lp= new Login_Page(driver, Excel_path1);
	
	lp.enterUserName(er.getExcelData(6, 5));// AO_fert
	lp.enterPassword(er.getExcelData(11, 2));// Pass@123
	
	lp.Enter_Captha();
	lp.clickLoginButton();
	
}

}
