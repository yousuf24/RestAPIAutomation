package com.tcs.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.*;

@SuppressWarnings("all")
public class XcelIntegration {

	public static void main(String[] args) throws IOException {
		
		ArrayList<String> arrayL=getData("TestData");
		System.out.println(arrayL);
		

	}
	public static ArrayList<String> getData(String s) throws IOException{
		ArrayList<String> al=new ArrayList<>();
		File f=new File("C:\\Users\\HI\\My_Items\\Job\\Softwares\\EclipseIDE\\eclipseIDE_ws\\APIFramework\\src\\test\\java\\com\\tcs\\resources\\TestData.xlsx");
		FileInputStream fi=new FileInputStream(f);
		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		int no=wb.getNumberOfSheets();
		
		for(int i=0;i<no;i++) {
			
			int column=0;
			if(wb.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sh=wb.getSheetAt(i);
				int columns=sh.getRow(i).getLastCellNum();
				for(int j=0;j<columns;j++) {
					Cell cl=sh.getRow(i).getCell(j);
					
					if(cl.getCellType().name().equals("STRING") && cl.getStringCellValue().equals(s))
					{
						System.out.format("Found the TestData at row: %d column:%d\n",i,j);
						column=j;
					}
				}
				
				System.out.format("NO of Rows present %d\n",sh.getLastRowNum());
				Iterator<Row> it=sh.rowIterator();
				
				
				while(it.hasNext()) {
					Row row=it.next();
				
					if(row.getCell(column).getStringCellValue().equalsIgnoreCase(s))
					{
					Iterator<Cell> it2=row.cellIterator();
					while(it2.hasNext()) {
						Cell cl=it2.next();
						String local="";
						
					 if(cl.getCellType().name().equals("STRING")) {
						   local=cl.getStringCellValue();
							
					  }else if(cl.getCellType().name().equals("NUMERIC")) {
						 local= NumberToTextConverter.toText(cl.getNumericCellValue());
						  //local=cl.getNumericCellValue()+"";
					  }
					 	System.out.format("%10s",local+"\t");
						al.add(local);
					
					}System.out.println();
					}
				
				}
				
			}
			
		}
		return al;
		
	}

}
