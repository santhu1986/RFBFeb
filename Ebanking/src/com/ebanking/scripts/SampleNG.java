package com.ebanking.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleNG 
{
	
	WebDriver driver;
	
        @BeforeTest
	    public void xyz() throws InterruptedException 
	    {
	    	//Launch Firefox
	    	driver=new FirefoxDriver();
	    	driver.manage().window().maximize();
	    	Thread.sleep(3000);
	    	
	    }
	      @Test
	    public void abc() throws InterruptedException 
	    {
	    	// URL
	    	
	    	driver.get("http://103.211.39.246/ranford2/");
	    	Thread.sleep(3000);
	    	
	    }
	      @Test
		    public void bcd() 
		    {
		    	// URL
		    	
		    	driver.get("http:www.google.com");
		    }
	    @AfterTest
	    public void pqr() throws InterruptedException 
	    {
	    	 // Close App
	    	Thread.sleep(3000);
	    	driver.close();
	    }
}
