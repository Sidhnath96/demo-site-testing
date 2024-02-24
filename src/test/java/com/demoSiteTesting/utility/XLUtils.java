package com.demoSiteTesting.utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fo;
	
	
	public static int getRowCount(File src, String xlname) throws IOException
	{
		src= new File(System.getProperty("user.dir")+"/demoSiteTesting/src/test/java/com/demoSiteTesting/testData/LoginTestData.xlsx");
		fi= new FileInputStream(src);
		wb= new XSSFWorkbook(fi);
		sh= wb.getSheet(xlname);
		
		int rowcount=sh.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
	}
	
	
	public static int getCellCount(File src, String xlname, int rownum) throws IOException
	{
		src= new File(System.getProperty("user.dir")+"/demoSiteTesting/src/test/java/com/demoSiteTesting/testData/LoginTestData.xlsx");

		fi= new FileInputStream(src);
		wb= new XSSFWorkbook(fi);
		sh= wb.getSheet(xlname);
		
		row = sh.getRow(rownum);
		
		int cellcount = row.getLastCellNum();
		
		wb.close();
		fi.close();
		return cellcount;
		
	}
	
	public static String getCellData(File src, String xlname, int rownum, int colnum) throws IOException
	{
		
		fi= new FileInputStream(src);
		wb= new XSSFWorkbook(xlname);
		sh= wb.getSheet(xlname);
		
		row = sh.getRow(rownum);
		cell = row.getCell(colnum);
		
		String data;
		
		try
		{
			DataFormatter formatter = new DataFormatter();
			String cellData= formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e)
		{
			data="";
			e.printStackTrace();
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public static void setCellData(File src, String xlname, int rownum,int colnum, String data) throws IOException
	{
		fi= new FileInputStream(src);
		wb= new XSSFWorkbook(xlname);
		sh= wb.getSheet(xlname);
		
		row = sh.getRow(rownum);
		cell= row.createCell(colnum);
		cell.setCellValue(data);
		fo= new FileOutputStream(src);
		
		wb.close();
		fi.close();
		fo.close();
		
	}
	
	
}
