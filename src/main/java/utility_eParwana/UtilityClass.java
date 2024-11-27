package utility_eParwana;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;



public class UtilityClass extends BaseClass{
	
	public static String getPFdata(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("D:\\NewWorkspace\\com.e_Parwana_HybrideFramework\\src\\main\\java\\utility_eParwana\\config.Properties");
		//FileInputStream file=new FileInputStream("C:\\Users\\Amjad.Sayyed\\Downloads\\MAHA_DBT\\src\\main\\java\\utility\\Config.properties");
			Properties properties=new Properties();
			properties.load(file);
			String value=properties.getProperty(key);
			return value;
	}	
	
	
//	
	public String currentPageTitle()
	{
		String titlle=driver.getTitle();
		return titlle;
	}
	public static void takeSS(String filename)
	{
		try
		{
			String path="D:\\NewWorkspace\\com.e_Parwana_HybrideFramework\\ExtentReports\\Screenshots";
			//String path="C:\\Users\\Amjad.Sayyed\\Downloads\\MAHA_DBT\\ExtentReports\\Screenshots";
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dec=new File(path+filename+".png");
			FileHandler.copy(src, dec);

		}catch(IOException e)
		{
			System.out.println("file path is not correct");
			e.printStackTrace();
		}
	}
	
//  Drop Drown
  public static void selectOptionFromDropDown(WebElement ele, String value) {

      Select drp = new Select(ele);

      List<WebElement> alloptions = drp.getOptions();

      for (WebElement option : alloptions) {

          if (option.getText().equals(value)) {

              option.click();

              break;

          }}

}

}
