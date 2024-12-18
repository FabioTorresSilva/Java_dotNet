package upskill.restdemo.services.implementation;

import org.springframework.stereotype.Service;
import upskill.restdemo.dto.Student;
import upskill.restdemo.services.StudentManagement;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentArrayList implements StudentManagement {

    private final List <Student> students;

    public StudentArrayList(List<Student> students) {
        this.students = new ArrayList<>();
        this.students.add(new Student("Exemplo", 231, "123"));
        if (students != null) {
            this.students.addAll(students); // Adiciona valores de entrada à lista.
        }
    }

    @Override
    public Student showStudentById(String id) {
        for(Student s : students) {
            if(s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Student deleteStudentById(String id) {
        for (Student student : students) {
            if (id.equals(student.getId())) {
                students.remove(student);
                return student;
            }
        }
        return null;
    }

    @Override
    public Student registerStudent(Student student) {
       this.students.add(student);
       return student;
    }

    @Override
    public Student updateStudent(Student student){
        for(Student s : students) {
            if(s.getId().equals(student.getId())) {
                students.remove(s);
                students.add(student);
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> showAllStudents() {
        if(students.isEmpty()){
            return null;
        }
        return students;
    }

    @Override
    public List<Student> showStudentsAboveX(int limit) {
        List<Student> students = new ArrayList<>();
        for (Student s : this.students) {
            if (s.getAge() > limit) {
                students.add(s);
            }
        }
        return students;
    }

    @Override
    public List<Student> showStudentsAboveXNameLetterX(int age, String letter) {
        List<Student> studentsAboveX = new ArrayList<>();
        for (Student s : students) {
            if (age <= 0 || letter == null || letter.isEmpty()) {
                return new ArrayList<>();
            }
            if (s.getAge() >= age && (s.getName().toLowerCase()).startsWith((letter).toLowerCase())) {
                studentsAboveX.add(s);
            }
        }
        return studentsAboveX;
    }
}
