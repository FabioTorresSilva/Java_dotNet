package pt.upskill.iet.restupskill.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.upskill.iet.restupskill.dto.StudentDTO;
import pt.upskill.iet.restupskill.services.StudentManagement;

import java.util.List;


@RestController
@RequestMapping("api/v1/demo")
public class RestDemo {

    @Autowired
    private StudentManagement students;

    @GetMapping("showStudent/{id}")
    public ResponseEntity<StudentDTO> showStudent(@PathVariable("id") long id){
        if (id == 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        StudentDTO s = this.students.showStudent(id);
        if (s==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PostMapping("createStudent")
    public StudentDTO createStudent(@RequestBody StudentDTO student){
        this.students.registerStudent(student);
        return student;
    }

    @GetMapping("showStudents")
    public List<StudentDTO> getStudents(){
        return this.students.showStudents();
    }

    /*@GetMapping("showStudentAboveX")
    public List<Student> showStudentAboveX(@RequestParam("above") int limit){
        List<Student> list = new ArrayList<>();
        for(Student s : this.students){
            if (s.getAge() >= limit ){
                list.add(s);
            }
        }
        return list;
    }

    @GetMapping("showStudentWithFilters")
    public List<Student> showStudenWithFilters(@RequestParam("above") int limit, @RequestParam("starts") String start){
        return this.students
                .stream()
                .filter(student -> student.getAge()>= limit)
                .filter(student -> student.getName().startsWith(start))
                .toList();
    }


    @PutMapping("updateStudent")
    public Student updateStudent(@RequestBody Student student){
        for(Student s : this.students){
          if (s.get_id() == student.get_id()){
              s.setAge(student.getAge());
              s.setName(student.getName());
          }
        }
        return student;
    }

    @DeleteMapping("deleteStudent")
    public Student deleteStudent(@RequestBody Student student){
        for(Student s : this.students){
            if (s.get_id() == student.get_id()){
                this.students.remove(s);
            }
        }
        return student;
    }

    @DeleteMapping("deleteStudent/{id}")
    public Student deleteStudent(@PathVariable("id") long idStudent){
        Student sTemp = null;
        for(Student s : this.students){
            if (s.get_id() == idStudent){
                sTemp = s;
                this.students.remove(s);
            }
        }
        return sTemp;
    }
*/
}
