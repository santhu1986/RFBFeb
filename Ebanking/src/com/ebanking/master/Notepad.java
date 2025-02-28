package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notepad {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		//Instance Class
		
		Library LB=new Library();
		
		LB.OpenApp("http://103.211.39.246/ranford2/");
        LB.AdminLgn("Admin","Test@Mq");
        
        //To Get The Test Data File Path
        
        String Fpath="D:\\SeleniumJan25Prj\\Ebanking\\src\\com\\ebanking\\testdata\\Role.txt";
        
        //Results File Path
        
        String Rpath="D:\\SeleniumJan25Prj\\Ebanking\\src\\com\\ebanking\\results\\RoleResults.txt";
        String SD;
        
        //To get Test Data file
        
        FileReader FR=new FileReader(Fpath);
        BufferedReader BR=new BufferedReader(FR);
        String Sread=BR.readLine();
        System.out.println(Sread);
        
        //Writing Header into Results
        
        FileWriter FW=new FileWriter(Rpath);
        BufferedWriter BW=new BufferedWriter(FW);
        BW.write(Sread);
        BW.newLine();
	
	//Multiple Iterations ---- Loop
        
        while((SD=BR.readLine())!=null)
        {
			  System.out.println(SD);
			  
			  //Split
			  
			  String SR[]=SD.split("###");
			  
			  String Rname=SR[0];
			  String Rtyp=SR[1];
			  
			String Res=LB.Role(Rname,Rtyp);
			System.out.println(Res);
			
			//Results
			
			BW.write(SD+"&%^&&*"+Res);
			BW.newLine();
			  
		}
	
	BW.close();
	BR.close();
	
	
	
	
	
	}
	

}
