package edu.gatech.seclass.project3;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.project3.Course;
import edu.gatech.seclass.project3.Grades;
import edu.gatech.seclass.project3.Student;
import edu.gatech.seclass.project3.Students;
public class AdditionalCourseTest {
    Students students = null;
    Grades grades = null;
    Course course = null;
    static final String DB = "DB/CourseDatabase6300.xlsx";
    static final String DB_GOLDEN = "DB/CourseDatabase6300-golden.xlsx";

    @Before
    public void setUp() throws Exception {
        FileSystem fs = FileSystems.getDefault();
        Path dbfilegolden = fs.getPath(DB_GOLDEN);
        Path dbfile = fs.getPath(DB);
        Files.copy(dbfilegolden, dbfile, REPLACE_EXISTING);
        course = new Course(DB);
    }

    @After
    public void tearDown() throws Exception {
        students = null;
        grades = null;
        course = null;
    }
    
    @Test
    public void testaddStudent() {
        Student addStudent1 = new Student("Tyler Bobik", 991234502, "bsod@gmail.com", 90, "Team2");
        course.addStudent(addStudent1);
        course.updateGrades(new Grades(DB));
        Student addStudent2 = new Student("Jack Skellington", 966234502, "treat@gmail.com", 90, "Team2");
        course.addStudent(addStudent2);
        course.updateGrades(new Grades(DB));
        assertEquals("Tyler Bobik", course.getStudentByID(991234502));
        assertEquals("Jack Skellington", course.getStudentByID(966234502));
    }
    
    @Test
    public void testaddProject() {
        course.addProject("Project 4");
        course.updateGrades(new Grades(DB));
        course.addProject("Project 5");
        course.updateGrades(new Grades(DB));
        assertEquals(5, course.getNumProjects());
    }
    
    @Test
    public void testaddGradesForProject() {
    	 String projectName = "Project X";
         Student student1 = new Student("Josepha Jube", 901234502, course);
         Student student2 = new Student("Christine Schaeffer", 901234508, course);
         course.addProject(projectName);
         course.updateGrades(new Grades(DB));
         HashMap<Student, Integer> projectGrades = new HashMap<Student, Integer>();
         projectGrades.put(student1, 45);
         projectGrades.put(student2, 50);
         course.addGradesFoProject(projectName, grades);
         course.updateGrades(new Grades(DB));
         HashMap<Student, Integer> contributions = new HashMap<Student, Integer>();
         contributions.put(student1, 30);
         contributions.put(student2, 35);
         course.addIndividualContributions(projectName, contributions);
         course.updateGrades(new Grades(DB));
         assertEquals(72, course.getAverageProjectsGrade(student1));
         assertEquals(47, course.getAverageProjectsGrade(student2));
    }

}
