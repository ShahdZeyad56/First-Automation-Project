
//This Test --->  Adding the right items from Swag Labs Website
package AddingItemsTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class RightItems
{
	//Declaring Global Variables
	
	WebDriver driver = new ChromeDriver();
	String WebsiteName="https://www.saucedemo.com/";
	String UserNameFieldID="user-name";
	String PasswordFieldID="password";
	String LogInButtonID  ="login-button";
	String Username="standard_user";
	String Password="secret_sauce";
	String AddItemsClass="btn";
	int i=0;
	
	// Before we start testing
	@BeforeTest
	public void MySetup() 
	{
		
		driver.get(WebsiteName);
		driver.manage().window().maximize();
		
	}
	
	//My Test Cases
	
	@Test(priority=1)
	public void Login()
	{
		//Prepare variables : 
				WebElement UserNameField= driver.findElement(By.id(UserNameFieldID));
				WebElement PassWordField= driver.findElement(By.id(PasswordFieldID));
				WebElement LogInButton  = driver.findElement(By.id(LogInButtonID));
				
	   //Actions : 
		UserNameField.sendKeys(Username);
		PassWordField.sendKeys(Password);
		LogInButton.click();
		
	}
	
	//_________________________________________________________________________________________________
	@Test(priority=2)
	public void AddingRightItems()
	{
		
	//Declaring :
		
	List <WebElement> AddingItems= driver.findElements(By.className(AddItemsClass));
	
	//Adding the Right Items only  : 
	
	   for(i=1;i<AddingItems.size();i+=2)
	   {
		   AddingItems.get(i).click();
	   }
	   
	}
	
	//_____________________________________________________________________________________________
	@Test(priority=3)
	public void LogOut() throws InterruptedException
	{
		WebElement menu= driver.findElement(By.id("react-burger-menu-btn"));
		menu.click();
		Thread.sleep(2000);
		WebElement Logout= driver.findElement(By.id("logout_sidebar_link"));
		Logout.click();
		
	}
	   
	  //After the test End :
	   @AfterTest  
	   public void AfterTesting() throws InterruptedException
	   {
		   Thread.sleep(60000);
		   driver.quit();
	   }
		
	}
	
