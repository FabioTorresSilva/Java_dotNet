package pt.upskill.iet.restupskill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.upskill.iet.restupskill.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
