package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exepom 
{
	
	WebDriver driver;
	
    @BeforeTest
	public void Algn() throws InterruptedException
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://103.211.39.246/ranford2/");
		
		//Login
		
		RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
		RHP.Alogin();
	}
    
    @Test(dataProvider="Rdata")
    public void Role(String Rn,String Rt) throws InterruptedException, IOException 
    {
    	
 		Thread.sleep(3000);
		
		//Branches
		
		AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
	    AHP.Rol();
	    
	    Thread.sleep(3000);
	    
	    //New Role
	   RoleDetails RD=PageFactory.initElements(driver,RoleDetails.class);
	   RD.NewRole();
	   
	   Thread.sleep(3000);
	   //Role Creation
	   
	   RoleCreation RC=PageFactory.initElements(driver,RoleCreation.class);
	   RC.Rcre(Rn,Rt);
	   
	   //Alert
	   Thread.sleep(3000);
	   driver.switchTo().alert().accept();
	   
	   //Home
	   Thread.sleep(3000);
	   RD.RoleHome();
	   
    }   
	   
    @DataProvider
    public Object [][] Rdata()
    {
    Object [][] Obj=new Object[3][2];
    
    Obj[0][0]="TellerAxisBank";
    Obj[0][1]="E";
    
    Obj[1][0]="CashierAxisBank";
    Obj[1][1]="E";
    
    Obj[2][0]="GenManagerAxisBank";
    Obj[2][1]="E";
    
    return Obj;
    }

    }  