import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    ArrayList<Student> students = new ArrayList<Student>();

    Student temp = new Student("");
    Scanner scan = new Scanner(new File("src/main/java/input.txt"));

    while(scan.hasNextLine())
      {
        String line = scan.nextLine();

        if(!line.contains(",")) //contains will be useful
        {
          students.add(temp);
          temp = new Student(line);
          //System.out.println(line + " is a student");
        }

        else
        { 
          String[] lineSplit = line.split(",");
          //lineSplit[0] will be the name (1st field)
          //lineSplit[1] will be the grade (2nd field)
          temp.addCourse(new Course(lineSplit[0],lineSplit[1]));
          //System.out.println(line + " is a course");
        }
        
        
        //System.out.println(scan.nextLine());
      }

    students.add(temp); //add the last student in the file into the student arraylist

    for(int i = 0; i < students.size(); i++)
      {
        System.out.println(students.get(i));
      }
  }
}

class Student
{
  private String name;
  private ArrayList<Course> courses;

  public Student(String name)
  {
    this.name = name;
    courses = new ArrayList<Course>();
  }

  public void addCourse(Course course)
  {
    courses.add(course);//add a course to a student
  }
  public String getName()
  {
    return name;
  }
  public ArrayList<Course> getCourses()
  {
    return courses;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setCourses(ArrayList<Course> courses)
  {
    this.courses = courses;
  }

  public String toString()
  {
    String result = "";

    result += name +"\n";

    for(int i = 0; i < courses.size(); i++)
      {
        result+= courses.get(i)+"\n";
      }
    return result;
  }
  
}

class Course
{
    private String name;
    private String grade;

  public Course(String name, String grade)
  {
    this.name = name;
    this.grade = grade;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setGrade(String grade)
  {
    this.grade = grade;
  }

  public String getName()
  {
    return name;
  }

  public String getGrade()
  {
    return grade;
  }

  public String toString()
  {
    return name + " " + grade;
  }
}