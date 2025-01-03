package pt.upskill.iet.restupskill.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.upskill.iet.restupskill.dto.StudentDTO;
import pt.upskill.iet.restupskill.models.Student;
import pt.upskill.iet.restupskill.repository.StudentRepository;
import pt.upskill.iet.restupskill.services.StudentManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentManagmentImpl implements StudentManagement {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO registerStudent(StudentDTO s) {
        Student st = this.studentRepository.save(Student.fromStudentDTO(s));
        return StudentDTO.fromStudent(st);
    }

    @Override
    public StudentDTO showStudent(long id) {
        Student sDB = this.studentRepository.findById(id).orElse(null);
        StudentDTO sDTO = StudentDTO.fromStudent(sDB);
        return sDTO;
    }

    @Override
    public List<StudentDTO> showStudents() {

        List<StudentDTO> newL = new ArrayList<StudentDTO>();
        for (Student s : studentRepository.findAll()) {
            newL.add(StudentDTO.fromStudent(s));
        }
        return newL;

        //return this.studentRepository
//                .findAll()
//                .stream()
//                .map(StudentDTO::fromStudentDTO)
//                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO updateStudent(StudentDTO s) {
        Student st = this.studentRepository.save(Student.fromStudentDTO(s));
        return StudentDTO.fromStudent(st);
    }

    @Override
    public StudentDTO removeStudent(long id) {
        Student sDB = this.studentRepository.findById(id).orElse(null);
        if (sDB != null) {
            this.studentRepository.deleteById(id);
        }
        StudentDTO sDTO = StudentDTO.fromStudent(sDB);
        return sDTO;
    }

    @Override
    public List<StudentDTO> filterStudentAboveX(int age) {
        return List.of();
    }

    @Override
    public List<StudentDTO> filterStudentAboveXStartsWithY(int age, char c) {
        return List.of();
    }
}
