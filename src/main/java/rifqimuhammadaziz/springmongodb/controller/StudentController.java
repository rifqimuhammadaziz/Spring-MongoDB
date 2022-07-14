package rifqimuhammadaziz.springmongodb.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springmongodb.entity.Gender;
import rifqimuhammadaziz.springmongodb.entity.Student;
import rifqimuhammadaziz.springmongodb.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

//    @PostMapping
//    public Student save(@RequestBody Student student) {
//        return studentService.save(student);
//    }

    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/email/{email}")
    public Student findStudentByEmail(@PathVariable String email) {
        return studentService.findStudentByEmail(email);
    }

    @GetMapping("/name/{name}")
    public List<Student> findStudentByName(@PathVariable String name) {
        return studentService.findStudentsByFirstNameContains(name);
    }

    @GetMapping("/gender/{gender}")
    public List<Student> findStudentByName(@PathVariable Gender gender) {
        return studentService.findStudentByGender(gender);
    }
}
