package nl.tv.NOVIopdrachtcontroller.repository;

import nl.tv.NOVIopdrachtcontroller.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFullNameContaining(String query);
}