package upskill.restdemo.services;

import upskill.restdemo.dto.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentManagement
{


    public Student showStudentById(String id);
    public Student deleteStudentById(String id);
    public Student registerStudent(Student student);
    // public Student removeStudent(Student student);
    public Student updateStudent(Student student);
    //public Student showStudent(Student student);
    public List<Student> showAllStudents();
    public List<Student> showStudentsAboveX(int age);
    public List<Student> showStudentsAboveXNameLetterX(int age, String letter);

}
