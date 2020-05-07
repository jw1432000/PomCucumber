package package1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksBaseClass {

	private Properties prop;
	private FileInputStream fileLoc;
	private String browserName;
	private String currentDir = System.getProperty("user.dir");
	protected WebDriver driver;


	@Before
	public WebDriver setUpBrowser()
	{
		
		System.out.println("+++++++++++++++BEFORE HOOK STARTED++++++++++++++++++");
		readPropertyFile();
		if (driver == null) 
		{

			browserName = prop.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
				driver.manage().window().maximize();

			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			else
			{
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();

			}

			driver.get(prop.getProperty("url"));
		}

		return driver;
	}


	@After
	public void tearDown(Scenario scene)
	{
		if (!scene.isFailed())
		{
			System.out.println("++++++++++++++++++++NOT FAILED AFTER METHOD+++++++++++++++");
			System.out.println("Scenario passed is : " + scene.getName());

		}
		else
		{
			System.out.println("++++++++++++++++++++FAILED AFTER METHOD+++++++++++++++");
			System.out.println("Scenario failed is : " + scene.getName());
		}
		
		driver.quit(); 
		driver = null;
	}

	private void readPropertyFile()
	{
		try {

			prop = new Properties();
			fileLoc= new FileInputStream(currentDir + "//PropertyFiles//data.properties");
			prop.load(fileLoc);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
