package edu.gatech.seclass.project3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Course 
{
	HashSet<Student> studentsAll = new HashSet<Student>();	
	//ArrayList<ArrayList<String>> individGradesInformation1 = new ArrayList<ArrayList<String>>();
	ArrayList<String> assignments;
	static Students studentsInfo;
	String gradesData;
	HashSet<Course> email_attend = new HashSet<Course>();	
	Grades grades;
	int sheet_2 = 1;
	int name_int = 0;
	int gtId_int = 1;
	int email_int = 2;
	int attend_int = 1;
	String formula = "ATT * 0.2 + AVGA * 0.4 + AVGP * 0.4";
	String studentFormula = getFormula();
	
	public Course(String gradesDB){
		this.gradesData = gradesDB;
		grades = new Grades(gradesData);
		studentsInfo = new Students(gradesDB);
		String[] nameArray = getName(studentsInfo);
		String[] gtIdArray = getGtId(studentsInfo);
		String[] emailArray = getEmail(studentsInfo);
		String[] attendArray = getAttend(studentsInfo);
		for(int list=1;list<studentsInfo.getStudentInformation().size();list++){
			String name = nameArray[list];
			String gtId = gtIdArray[list];
			String email = emailArray[list];
			String attend = attendArray[list];
			String teamNumber =  getTeamNumber(gtId);
			int atted = Integer.parseInt(attend);
			int GTIDInt = Integer.parseInt(gtId);
			Student student = newStudent(name, GTIDInt, email, atted, teamNumber);

			studentsAll.add(student);
		}
	}
    public void setStudents(HashSet<Student> studentsRoster) {
        this.studentsAll = studentsRoster;
    }

	
	public String[] getAttend(Students studentsInfo)
	{
		int studentsInfoLen = studentsInfo.getStudentInformation().size();
		String[] attend;
		attend = new String[studentsInfoLen];
		for(int list=1;list<studentsInfo.getStudentInformation().size();list++){
			attend[list] = studentsInfo.getAttendanceInformation().get(list).get(attend_int);
		}
		return attend;
	}
	
	public String[] getEmail(Students studentsInfo)
	{
		int studentsInfoLen = studentsInfo.getStudentInformation().size();
		String[] email;
		email = new String[studentsInfoLen];
		for(int list=1;list<studentsInfo.getStudentInformation().size();list++){
			email[list] = studentsInfo.getStudentInformation().get(list).get(email_int);
		}
		return email;
	}
	
	public String[] getGtId(Students studentsInfo)
	{
		int studentsInfoLen = studentsInfo.getStudentInformation().size();
		String[] gtId;
		gtId = new String[studentsInfoLen];
		for(int list=1;list<studentsInfo.getStudentInformation().size();list++){
			gtId[list] = studentsInfo.getStudentInformation().get(list).get(gtId_int);
		}
		return gtId;
	}
	
	public String[] getName(Students studentsInfo)
	{
		int studentsInfoLen = studentsInfo.getStudentInformation().size();
		String[] name;
		name = new String[studentsInfoLen];
		for(int list=1;list<studentsInfo.getStudentInformation().size();list++){
			name[list] = studentsInfo.getStudentInformation().get(list).get(name_int);
		}
		return name;
	}
	//Put in Students later?
	
	public String getTeamNumber(String GTID)
	{
		String teamNumber = "";
		int team = 0;
		for(int list=1;list<studentsInfo.getTeamInformation().size();list++)
		{
			for(int inner=1;inner<studentsInfo.getTeamInformation().get(list).size();inner++)
			{
				if(studentsInfo.getTeamInformation().get(list).get(inner).equals(GTID))
				{
					teamNumber = studentsInfo.getTeamInformation().get(list).get(team);
				}
			}			
		}
		return teamNumber;
   }
	
	public static Student newStudent(String name, int gtId, String email, int attendance, String team){
		Student student = new Student(name, gtId, email, attendance, team);
		return student;
	}
	
	public String getTeam(Student student){
		return student.getTeam();
	}
	
	public int getNumStudents(){
		return studentsInfo.getTotalStudents();		
	}
	
	public int getAttendance(Student student)
	{
		return student.getAttendance();
	}

	public int getNumAssignments(){
			return grades.individGradesInformation.get(0).size()-1;
	}

	public int getNumProjects(){
			return grades.individContribsInformation.get(0).size()-1;
	}

	public HashSet<Student> getStudents(){
		return studentsAll;
	}
	
	public ArrayList<ArrayList<String>> getIndividContribsInformation()
	{
		return grades.getIndividContribsInformation();
	}
	
	public ArrayList<ArrayList<String>> getIndividGradesInformation()
	{
		return grades.getIndividGradesInformation();
	}
	
	public Student getStudentByName(String name)
	{	
		for(Student student : studentsAll)
		{
			String studentName = name;
			if (student.getName().equals(studentName))
			{
				return student;
			}
		}
		return null;
	}
	
	public Student getStudentByID(int gtId)
	{
		for(Student student : studentsAll)
		{
			if (student.getGtid() == (gtId))
			{
				return student;
			}
		}
		return null;
	}
	
	public void addAssignment(String assignment)
	{		
		for(int list=0; list<grades.getIndividGradesInformation().size(); list++)
		{
			//System.out.println(grades.getIndividGradesInformation().get(i));
			if (list == 0)
			{
				grades.getIndividGradesInformation().get(list).add(assignment);
			}
		}
		
	}
	
	public int getColumnIndivdualContribs(String projectName)
	{
		int column = 0;
		for (int list = 1; list< getIndividContribsInformation().get(0).size();list++)
		{
			if(getIndividContribsInformation().get(0).get(list).equals(projectName))
			{
				column = list;
			}
		}
		return column;
	}
	
	public int getRowIndivdualContribs(int gtId)
	{
		String gtIdInt = Integer.toString(gtId);
		int row = 0;
		for (int list =1; list<getIndividContribsInformation().size(); list++)
		{
			if(getIndividContribsInformation().get(list).get(0).equals(gtIdInt))
			{
				row = list;	
			}
		}
		return row;
	}
	
	public void addIndividualContributions(String project, HashMap<Student, Integer> Contribs)
	{
		for (Student student : Contribs.keySet())
		{
			int gtId = student.getGtid();
			getIndividContribsInformation().get(getRowIndivdualContribs(gtId)).set(getColumnIndivdualContribs(project), Contribs.get(student).toString());	
		}	
	}
	
	public void addGradesForAssignment(String assignment, HashMap<Student, Integer> grades)
	{
		this.grades.addGradesForAssignment(assignment, grades);	
	}
	

	public void updateGrades(Grades grades1)
	{
	}
	
	public int getAverageAssignmentsGrade(Student student)
	{
		List<String> myList = new ArrayList<String>();
		List<Integer> myListDouble = new ArrayList<Integer>();
		int gtId = student.getGtid();
		String gtIdString = Integer.toString(gtId);
		double averageDouble;
		for (int list=1; list<getIndividGradesInformation().size(); list++)
		{
			if(getIndividGradesInformation().get(list).get(0).equals(gtIdString))
			{
				for (int grade = 1; grade<getIndividGradesInformation().get(list).size(); grade++)
				{
					myList.add(getIndividGradesInformation().get(list).get(grade));
				}
			}					    
		}
		for(String s : myList) 
		{
			myListDouble.add(Integer.valueOf(s));
		}
		averageDouble = calculateAverage(myListDouble);
		int averageInt = (int) averageDouble;
		return averageInt;
	}
	private double calculateAverage(List <Integer> number) 
	{
		  Integer total = 0;
		  if(!number.isEmpty()) 
		  {
		    for (Integer numbers : number) 
		    {
		        total += numbers;
		    }
		    return Math.round(total.doubleValue() / number.size());
		  }
		  return total;
	}
	
	public int getAverageProjectsGrade(Student student)
	{
		List<String> myListIndividual = new ArrayList<String>();
		List<String> myListTeam = new ArrayList<String>();
		int gtId = student.getGtid();
		String gtIdString = Integer.toString(gtId);
		String teamNumber = getTeamNumber(gtIdString);
		double averageDouble = 0;
	
		for (int list=1; list<getIndividContribsInformation().size(); list++)
		{
			if(getIndividContribsInformation().get(list).get(0).equals(gtIdString))
			{
				for (int grade = 1; grade<getIndividContribsInformation().get(list).size(); grade++)
				myListIndividual.add(getIndividContribsInformation().get(list).get(grade));
			
			}
		}

		for (int list=1; list<=grades.getTeamGradesInformation().size(); list++){
			if(grades.getTeamGradesInformation().get(list-1).get(0).equals(teamNumber))
			{
				for (int grade = 1; grade<grades.getTeamGradesInformation().get(list).size(); grade++)
				{
					myListTeam.add(grades.getTeamGradesInformation().get(list-1).get(grade));
				}
			}
		}
		for(int list=0 ; list<myListIndividual.size() ; list++) 
		{
			averageDouble += (Double.valueOf((Double.valueOf(myListIndividual.get(list))*.01) * ((Double.valueOf(myListTeam.get(list))* .01))));
		}
		averageDouble = averageDouble * 100;
		averageDouble = Math.round(averageDouble/3);
		int averageInt = (int) averageDouble;
		return averageInt;
	}
	
	public String getEmail(Student student)
	{
		String name = student.getName();
		String email = getEmailStudent(name);
		
		return email;
	}
	
	public String getEmailStudent(String name)
	{
		String email = "";
		for (int list =1; list < studentsInfo.getStudentInformation().size(); list++)
		{
			if(studentsInfo.getStudentInformation().get(list).get(0).equals(name))
			{				
				email = studentsInfo.getStudentInformation().get(list).get(2);
			}
		}
		return email;
	}
	
	public String getFormula(){
		return formula;
	}
	
	public void setFormula(String formula){
		this.formula = formula;
	}
	
	public int formulaObjectToInt(Object formulaObjectString)
	{
		String formulaObject = formulaObjectString.toString();
		double formulaObjectDouble = Double.parseDouble(formulaObject);
		int formulaObjectIntRounded = (int)Math.round(formulaObjectDouble);
		return formulaObjectIntRounded;
	}
	
	public int getOverallGrade(Student student)
	{
		int attendance = 0;
		int gtId = student.getGtid();
		String gtIdString = Integer.toString(gtId);
		attendance = Grades.getAttendanceGrade(gtIdString,grades);
		int ATT = attendance;
		int AVGA = getAverageAssignmentsGrade(student);
		int AVGP = getAverageProjectsGrade(student);
		try{
			ScriptEngineManager factory = new ScriptEngineManager();
			ScriptEngine engine = factory.getEngineByName("JavaScript");
			engine.put("ATT", ATT);
			engine.put("AVGA", AVGA);
			engine.put("AVGP", AVGP);
			Object formulaObject = engine.eval(formula);
			int formula = formulaObjectToInt(formulaObject);
			return formula;
		} catch(Exception e){
			throw new GradeFormulaException("Wrong formula");
		}
	}
	public void addStudent(Student addStudent1) {
		// TODO Auto-generated method stub
		
	}
	public void addProject(String string) {
		// TODO Auto-generated method stub
		
	}
	public void addGradesFoProject(String projectName, Grades grades2) {
		// TODO Auto-generated method stub
		
	}
}	
