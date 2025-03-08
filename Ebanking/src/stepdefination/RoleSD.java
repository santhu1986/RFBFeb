package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoleSD 
{
   
	 WebDriver driver;
	

@Given("^Tester should on RHP$")
public void tester_should_on_RHP() throws Throwable 
{
	driver=new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("http://103.211.39.246/ranford2/");
}

@When("^Tester Enter Login Details$")
public void tester_Enter_Login_Details() throws Throwable 
{
	driver.findElement(By.id("txtuId")).sendKeys("Admin");
    driver.findElement(By.id("txtPword")).sendKeys("Test@Mq");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id=\'login\']")).click();    
}

@Then("^Tester click on Role button$")
public void tester_click_on_Role_button() throws Throwable 
{
	driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
	
}

@When("^Tester click on new role and enters \"([^\"]*)\" and \"([^\"]*)\"$")
public void tester_click_on_new_role_and_enters_and(String Rn, String Rt) throws Throwable 
{
	driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
	driver.findElement(By.id("txtRname")).sendKeys(Rn);
	driver.findElement(By.id("lstRtypeN")).click();
	driver.findElement(By.id("lstRtypeN")).sendKeys(Rt);
	Thread.sleep(3000);
	driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
}

@Then("^Tester close the application$")
public void tester_close_the_application() throws Throwable 
{
	Thread.sleep(3000);
      driver.close();
}


}
