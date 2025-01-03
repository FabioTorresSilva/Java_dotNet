package pt.upskill.iet.restupskill.models;

import jakarta.persistence.*;
import lombok.*;
import pt.upskill.iet.restupskill.dto.StudentDTO;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Student {
    @Id
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private int age;

    //passa StudentDto para tipo Student para o colocar na db
    public static Student fromStudentDTO(StudentDTO studentDTO) {
        return new Student(studentDTO.get_id(), studentDTO.getName(), studentDTO.getAge());
    }
}
