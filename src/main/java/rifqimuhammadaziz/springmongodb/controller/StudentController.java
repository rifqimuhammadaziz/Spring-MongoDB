package rifqimuhammadaziz.springmongodb.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springmongodb.entity.Gender;
import rifqimuhammadaziz.springmongodb.entity.Student;
import rifqimuhammadaziz.springmongodb.error.StudentNotFoundException;
import rifqimuhammadaziz.springmongodb.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/email/{email}")
    public Student findStudentByEmail(@PathVariable String email) throws StudentNotFoundException {
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

    @PutMapping("/update/{email}")
    public Student updateStudentByEmail(@PathVariable String email, @RequestBody Student student) {
        return studentService.updateStudentByEmail(email, student);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity deleteStudentByEmail(@PathVariable String email) {
        studentService.deleteStudentByEmail(email);
        return ResponseEntity.ok("Student " + email + " successfully deleted");
    }
}
