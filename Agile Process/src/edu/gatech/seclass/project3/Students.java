package edu.gatech.seclass.project3;

import java.util.Iterator;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class Students {
	int sheet_1 = 0;
	int sheet_2 = 1;
	int sheet_3 = 2;
	ArrayList<ArrayList<String>> studentInformation = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> teamInformation = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> attendanceInformation = new ArrayList<ArrayList<String>>();
		public Students(String studentData)
			{	
				try {
				     
				    FileInputStream file = new FileInputStream(new File(studentData));
				     
				    XSSFWorkbook workbook = new XSSFWorkbook(file);	 
				    //Sheet 1
					XSSFSheet sheet1 = workbook.getSheetAt(sheet_1);
			    	Iterator<Row> rowIterator = sheet1.iterator();
			    	while(rowIterator.hasNext()) 
			    	{
			    		Row row = rowIterator.next();
			    		ArrayList<String> rowInfo = new ArrayList<String>();
			    		Iterator<Cell> cellIterator = row.cellIterator();
			    		while(cellIterator.hasNext()) 
			    		{
			    			Cell cell = cellIterator.next();
			    			String info="";
			    			switch(cell.getCellType()) 
			    			{
			                	case Cell.CELL_TYPE_BOOLEAN:
			                		info = Boolean.toString((boolean)(cell.getBooleanCellValue()));
			                    break;
			                	case Cell.CELL_TYPE_NUMERIC:
			                		info =  Integer.toString((int)(cell.getNumericCellValue()));
			                    break;
			                	case Cell.CELL_TYPE_STRING:
			                		info = cell.getStringCellValue();
			    			}
			    			rowInfo.add(info);
			    		}
			    		studentInformation.add(rowInfo);
			    	}
				
					//Sheet2
					XSSFSheet sheet2 = workbook.getSheetAt(sheet_2);
					Iterator<Row> rowIterator2 = sheet2.iterator();
			    	while(rowIterator2.hasNext()) 
			    	{
			    		Row row1 = rowIterator2.next();
			    		ArrayList<String> rowInfo2 = new ArrayList<String>();

			    		Iterator<Cell> cellIterator1 = row1.cellIterator();
			    		while(cellIterator1.hasNext()) 
			    		{
			    			Cell cell1 = cellIterator1.next();
			    			String info1="";
			    			switch(cell1.getCellType()) 
			    			{
			                	case Cell.CELL_TYPE_BOOLEAN:
			                		info1 = Boolean.toString((boolean)(cell1.getBooleanCellValue()));
			                    break;
			                	case Cell.CELL_TYPE_NUMERIC:
			                		info1 =  Integer.toString((int)(cell1.getNumericCellValue()));
			                    break;
			                	case Cell.CELL_TYPE_STRING:
			                		info1 = cell1.getStringCellValue();
			                    break;
			    			}
			    			rowInfo2.add(info1);
			    		}
			    		teamInformation.add(rowInfo2);
			    	}
					//Sheet 3
					XSSFSheet sheet3 = workbook.getSheetAt(sheet_3);
					Iterator<Row> rowIterator3 = sheet3.iterator();
			    	while(rowIterator3.hasNext()) 
			    	{
			    		Row row1 = rowIterator3.next();
			    		ArrayList<String> rowInfo2 = new ArrayList<String>();

			    		Iterator<Cell> cellIterator1 = row1.cellIterator();
			    		while(cellIterator1.hasNext()) 
			    		{
			    			Cell cell1 = cellIterator1.next();
			    			String info1="";
			    			switch(cell1.getCellType()) 
			    			{
			                	case Cell.CELL_TYPE_BOOLEAN:
			                		info1 = Boolean.toString((boolean)(cell1.getBooleanCellValue()));
			                    break;
			                	case Cell.CELL_TYPE_NUMERIC:
			                		info1 =  Integer.toString((int)(cell1.getNumericCellValue()));
			                    break;
			                	case Cell.CELL_TYPE_STRING:
			                		info1 = cell1.getStringCellValue();
			                    break;
			    			}
			    			rowInfo2.add(info1);
			    		}
			    		attendanceInformation.add(rowInfo2);
			    	}
					
			    	file.close();
				     
				} 
				catch (FileNotFoundException e) 
				{
				    e.printStackTrace();
				} 
				catch (IOException e) 
				{
				    e.printStackTrace();
				}
			}
				
			public ArrayList<ArrayList<String>> getStudentInformation()
			{
				return studentInformation;
			}
			
			public ArrayList<ArrayList<String>> getTeamInformation()
			{
				return teamInformation;
			}
			
			public ArrayList<ArrayList<String>> getAttendanceInformation()
			{
				return attendanceInformation;
			}
			public int getTotalStudents(){
				return studentInformation.size() -1;		
			}

			
			
}
