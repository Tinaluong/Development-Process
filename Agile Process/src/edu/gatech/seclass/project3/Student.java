package edu.gatech.seclass.project3;

import java.util.HashSet;

public class Student {
	private String name;
	private int gtId;
	private String email;
	private String team;
	private int attendance;
	Course course1;
	static Students studentsInfo;

	HashSet<Student> studentsAll = new HashSet<Student>();
	
	public Student(String name, int gtId, String email, int attendance, String team) {
		this.name = name;
		this.gtId = gtId;
		this.email = "";
		this.attendance = attendance;
		this.team = team;

	}
	
	public Student(String name, int gtId, Course course) {
		
        boolean here = false;
        for (Student studentsAll : course.getStudents())
        {
            if (gtId == (studentsAll.getGtid()) && name.equals(studentsAll.getName()))
            {
                here = true;
                this.name = name;
                this.gtId = gtId;
                this.team = studentsAll.getTeam();
                this.attendance = studentsAll.getAttendance();
            }
        }
        if (!here)
        {
            HashSet<Student> students = course.getStudents();
            students.add(this);
            course.setStudents(students);
        }
	}
	
	public Student(String name, int gtId)
	{
		this.name = name;
		this.gtId = gtId;
	}
    

	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setGtid(int gtId)
	{
		this.gtId = gtId;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setTeam(String team)
	{
		this.team = team;
	}
	
	public void setAttendance(int attendance)
	{
		this.attendance = attendance;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getGtid()
	{
		return gtId;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getTeam()
	{
		return team;
	}
	
	public int getAttendance()
	{
		return attendance;
	}
 
}
