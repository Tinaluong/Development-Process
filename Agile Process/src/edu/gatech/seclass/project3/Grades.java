package edu.gatech.seclass.project3;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Grades {

	public InputStream file;
	public OutputStream outFile;
	public String gradesData;
	
	int sheet_1 = 2;
	int sheet_2 = 3;		
	int sheet_3 = 4;
	int sheet_4 = 5;
	ArrayList<ArrayList<String>> attendanceGradesInformation = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> individGradesInformation = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> individContribsInformation = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> teamGradesInformation = new ArrayList<ArrayList<String>>();
	

	public Grades(String gradesData)
	{	
		this.gradesData = gradesData;

		try {
		     
		    FileInputStream file = new FileInputStream(new File(gradesData));
		    XSSFWorkbook workbook = new XSSFWorkbook(file);

		    //Get first sheet from the workbook
			XSSFSheet sheet2 = workbook.getSheetAt(sheet_1);
			Iterator<Row> rowIterator = sheet2.iterator();
	    	while(rowIterator.hasNext()) 
	    	{
	    		Row row1 = rowIterator.next();
	    		ArrayList<String> rowInfo1 = new ArrayList<String>();

	    		//For each row, iterate through each columns
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
	    			rowInfo1.add(info1);
	    		}
	    		attendanceGradesInformation.add(rowInfo1);
	    	}
		    //Get second sheet from the workbook
			XSSFSheet sheet3 = workbook.getSheetAt(sheet_2);
			Iterator<Row> rowIterator1 = sheet3.iterator();
	    	while(rowIterator1.hasNext()) 
	    	{
	    		Row row1 = rowIterator1.next();
	    		ArrayList<String> rowInfo1 = new ArrayList<String>();

	    		//For each row, iterate through each columns
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
	    			rowInfo1.add(info1);
	    		}
	    		individGradesInformation.add(rowInfo1);
	    	}
		    //Get third sheet from the workbook
			XSSFSheet sheet4 = workbook.getSheetAt(sheet_3);
			Iterator<Row> rowIterator2 = sheet4.iterator();
	    	while(rowIterator2.hasNext()) 
	    	{
	    		Row row1 = rowIterator2.next();
	    		ArrayList<String> rowInfo1 = new ArrayList<String>();

	    		//For each row, iterate through each columns
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
	    			rowInfo1.add(info1);
	    		}
	    		individContribsInformation.add(rowInfo1);
	    	}
		    //Get forth sheet from the workbook
			XSSFSheet sheet5 = workbook.getSheetAt(sheet_4);
			Iterator<Row> rowIterator3 = sheet5.iterator();
	    	while(rowIterator3.hasNext()) 
	    	{
	    		Row row1 = rowIterator3.next();
	    		ArrayList<String> rowInfo1 = new ArrayList<String>();

	    		//For each row, iterate through each columns
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
	    			rowInfo1.add(info1);
	    		}
	    		teamGradesInformation.add(rowInfo1);
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
	
	public ArrayList<ArrayList<String>> getAttendenceGradesInformation()
	{
		return attendanceGradesInformation;
	}
	
	public ArrayList<ArrayList<String>> getIndividGradesInformation()
	{
		return individGradesInformation;
	}
	
	public ArrayList<ArrayList<String>> getIndividContribsInformation()
	{
		return individContribsInformation;
	}
	
	public ArrayList<ArrayList<String>> getTeamGradesInformation()
	{
		return teamGradesInformation;
	}

	public int getColumnIndividGrades(String assignment)
	{
		int column = 0;
		for (int list = 1; list< getIndividGradesInformation().get(0).size();list++)
		{
			if(getIndividGradesInformation().get(0).get(list).equals(assignment))
			{
				column = list;
			}
		}
		return column;
	}
	
	public int getRowIndividGrades(int gtId)
	{
		String gtIdInt = Integer.toString(gtId);
		int row = 0;
		for (int list =1; list<getIndividGradesInformation().size(); list++)
		{
			if(getIndividGradesInformation().get(list).get(0).equals(gtIdInt))
			{
				row = list;	
			}
		}
		return row;
	}
	
		
	public void addGradesForAssignment(String assignment, HashMap<Student, Integer> grades)
	{
		for (Student student : grades.keySet()) 
		{
			int gtId = student.getGtid();
			getIndividGradesInformation().get(getRowIndividGrades(gtId)).add(getColumnIndividGrades(assignment), grades.get(student).toString());
		}
	
	}

	public static int getAttendanceGrade(String gtIdString, Grades grades) {
		int attendance = 0;
		for(int list=1; list<grades.getAttendenceGradesInformation().size(); list++)
		{			
			for(int grade=0; grade<grades.getAttendenceGradesInformation().get(list).size(); grade++)
			{
				if(grades.getAttendenceGradesInformation().get(list).get(grade).equals(gtIdString))
				{		
					attendance = Integer.parseInt(grades.getAttendenceGradesInformation().get(list).get(1));
				}				
			}
		}
		return attendance;
	}

}
