package pt.upskill.iet.restupskill.services;

import pt.upskill.iet.restupskill.dto.StudentDTO;

import java.util.List;

public interface StudentManagement {

    public StudentDTO registerStudent(StudentDTO s);
    //public Student showStudent(Student s);
    public StudentDTO showStudent(long id);
    public List<StudentDTO> showStudents();

    public StudentDTO updateStudent(StudentDTO s);
    //public Student removeStudent(Student s);
    public StudentDTO removeStudent(long id);

    public List<StudentDTO> filterStudentAboveX(int age);
    public List<StudentDTO> filterStudentAboveXStartsWithY(int age, char c);
}
