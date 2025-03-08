package com.ebanking.master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sgrid 
{
               DesiredCapabilities Cap;
               @Parameters("Browser")
               @Test
               public void Grid(String Br) throws MalformedURLException, InterruptedException
               {
            	   
            	   if (Br.equalsIgnoreCase("firefox"))
            	   {
            		   Cap=new DesiredCapabilities();
                	   Cap.setBrowserName("firefox");
                	   Cap.setPlatform(Platform.WINDOWS);
                    }
            	   else if (Br.equalsIgnoreCase("chrome"))
            	   {
            		   Cap=new DesiredCapabilities();
                	   Cap.setBrowserName("chrome");
                	   Cap.setPlatform(Platform.ANY);
                	}
            	   
            	   RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.239.1:4444/wd/hub"),Cap);
            	   
            	   driver.manage().window().maximize();
           		driver.get("http://103.211.39.246/ranford2/");
           		
           		//Login
           		
           		RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
           		RHP.Alogin();

           		AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
        	    AHP.Rol();
        	    
        	    Thread.sleep(3000);
        	    
        	    //New Role
        	   RoleDetails RD=PageFactory.initElements(driver,RoleDetails.class);
        	   RD.NewRole();
        	   
        	   Thread.sleep(3000);
        	   //Role Creation
        	   
        	   RoleCreation RC=PageFactory.initElements(driver,RoleCreation.class);
        	   RC.Rcre("Managerabc","E");
        	   
        	   //Alert
        	   Thread.sleep(3000);
        	   driver.switchTo().alert().accept();
        	   
               }
}
