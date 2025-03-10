package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ALoginSD
{
	
	   WebDriver driver;

	@Given("^User should on Ranford Home Page$")
	public void user_should_on_Ranford_Home_Page() throws Throwable 
	{
	       driver=new FirefoxDriver();
	       driver.manage().window().maximize();
	       driver.get("http://103.211.39.246/ranford2/");
	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String Un,String Pwd) throws Throwable 
	{
		driver.findElement(By.id("txtuId")).sendKeys(Un);
	    driver.findElement(By.id("txtPword")).sendKeys(Pwd);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\'login\']")).click();
	    
	}

	@Then("^User validates Admin Login$")
	public void user_validates_Admin_Login() throws Throwable 
	{
		String Expval="Welcome to Admin";
		 
		 String Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		   
		   //Comparision
		   
		   if (Expval.equalsIgnoreCase(Actval))
		   {
			System.out.println("Admin Login Succ");
		   }
		   else
		   {
			   System.out.println("Admin Login Failed");
		   }
	}


}
