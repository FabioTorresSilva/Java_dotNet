package upskill.restdemo.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upskill.restdemo.dto.Student;
import upskill.restdemo.services.StudentManagement;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/demo")


public class RestDemo {

    @Autowired
    private StudentManagement students;

    @GetMapping("/showStudentById/{id}")
    public ResponseEntity<Student> showStudentById(@PathVariable("id") String idStudent) {
               Student student = this.students.showStudentById(idStudent);
                if (student == null) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(student, HttpStatus.OK);
           }

    @DeleteMapping ("/deleteStudent/{id}")
    public ResponseEntity <String> removeStudentById(@PathVariable String id) {
        if(id == null || id.isEmpty()){
            return new ResponseEntity<>("Student id is required!",HttpStatus.BAD_REQUEST);
        }
        Student student = this.students.deleteStudentById(id);
        if(student != null){
            return new ResponseEntity<>("Student deleted!",HttpStatus.OK);
        }
        return new ResponseEntity<>("Student not found!",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createStudent")
    public ResponseEntity <String> createStudent(@RequestBody Student student) {
        if(student.getId() == null || student.getId().isEmpty()){
            return new ResponseEntity<>("Student id is required!",HttpStatus.BAD_REQUEST);
        }
        if(student.getName() == null || student.getName().isEmpty()){
            return new ResponseEntity<>("Student name is required!",HttpStatus.BAD_REQUEST);

        }
        if(student.getAge() < 0){
            return new ResponseEntity<>("Student age must be greater than zero!",HttpStatus.BAD_REQUEST);
        }
        this.students.registerStudent(student);

        return new ResponseEntity<>("Student Created", HttpStatus.CREATED);
    }

    @GetMapping("/getStudents")
    public ResponseEntity <List<Student>> getStudents() {
        if(this.students.showAllStudents().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(this.students.showAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/showStudentsAboveX")
    public ResponseEntity <List<Student>> showStudentsAboveX(@RequestParam int age) {
        if(age < 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(this.students.showStudentsAboveX(age).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(this.students.showStudentsAboveX(age), HttpStatus.OK);
    }

    @GetMapping("/showStudentsAboveXNameLetterX")
    public ResponseEntity<List<Student>> showStudentsAboveX(@RequestParam int age, @RequestParam String letter) {
        if(age < 0 || letter == null || letter.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(this.students.showStudentsAboveXNameLetterX(age, letter).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(this.students.showStudentsAboveXNameLetterX(age, letter), HttpStatus.OK);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        if(student.getAge() < 0|| student.getName() == null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(this.students.updateStudent(student) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
