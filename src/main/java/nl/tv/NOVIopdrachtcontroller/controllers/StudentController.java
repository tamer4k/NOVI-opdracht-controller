package nl.tv.NOVIopdrachtcontroller.controllers;

import nl.tv.NOVIopdrachtcontroller.model.Student;
import nl.tv.NOVIopdrachtcontroller.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("students")
@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/name")
    public List<Student> searchByFullName(@RequestParam String fullName) {
        return studentRepository.findByFullNameContaining(fullName);
    }

}
