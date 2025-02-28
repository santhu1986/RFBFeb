package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Instance Class
		
		Library LB=new Library();
		
		LB.OpenApp("http://103.211.39.246/ranford2/");
		LB.AdminLgn("Admin","Test@Mq");
		
	    // To Get Test Data File
		
		FileInputStream FIS=new FileInputStream("D:\\SeleniumJan25Prj\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
	
		//WorkBook
		
		XSSFWorkbook WB=new XSSFWorkbook(FIS);
		
		//Sheet
		
		XSSFSheet WS=WB.getSheet("RData");
		
		//Row Count
		
		int Rcount=WS.getLastRowNum();
		System.out.println(Rcount);
		
		//Multiple Iterations -------- Loop
		
		for (int i=1;i<=Rcount;i++)
		{
		
			//Row
			
			XSSFRow WR=WS.getRow(i);
			
			//Cell
			
			XSSFCell WC=WR.getCell(0);   //RoleName
			XSSFCell WC1=WR.getCell(1);  //RoleType
			
			XSSFCell WC2=WR.createCell(2); //Results
			
			//Cell Values
			
			String Rname=WC.getStringCellValue();
			String Rtyp=WC1.getStringCellValue();
			
			String Res=LB.Role(Rname,Rtyp);
			WC2.setCellValue(Res);
			
			}
		
		FileOutputStream FOS=new FileOutputStream("D:\\SeleniumJan25Prj\\Ebanking\\src\\com\\ebanking\\results\\Role_Res.xlsx");
		WB.write(FOS);
		WB.close();
		
	}
}
