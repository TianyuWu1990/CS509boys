package com.capricorn.util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	private static String fileName = "C:/Users/SAMSUNG/Desktop/KD&DM/project3/git_lifenggg_aprior/Aprior/data/test_tha.txt";
	private static String newFileName = "C:/Users/SAMSUNG/Desktop/KD&DM/project3/git_lifenggg_aprior/Aprior/data/new_test.txt";
	
	public static void main(String[] args) {
		//
		File file = new File(fileName);  
		BufferedReader br = null;
		InputStreamReader read = null;
		try { 
			String line;
			read = new InputStreamReader(new FileInputStream(file),"UTF-8"); 
			br = new BufferedReader(read);
			
			int count = 1;
			while((line=br.readLine())!=null){
				
				String str = line.trim();
				if(str.equals("")) continue;
				writeFile("T"+count+": "+str,newFileName);
				count++;
			}
			br.close();
			read.close();
		} catch (IOException e) {  
			e.printStackTrace();   
		}	
	}
	
	public static void writeFile(String content, String outputFile) { 
		  try { 
			  File f = new File(outputFile); 
			  if (!f.exists()) { 
				  f.createNewFile(); 
			  }
			  OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(f,true),"UTF-8"); 
			  BufferedWriter writer = new BufferedWriter(write);   
			  
			  writer.write(content); 
			  writer.newLine();
			  writer.close(); 
		  } catch (Exception e) { 
			  System.out.println("Error"); 
			  e.printStackTrace(); 
		  } 
	} 

}
