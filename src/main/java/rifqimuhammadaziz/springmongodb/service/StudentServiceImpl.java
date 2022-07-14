package rifqimuhammadaziz.springmongodb.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springmongodb.entity.Gender;
import rifqimuhammadaziz.springmongodb.entity.Student;
import rifqimuhammadaziz.springmongodb.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email).get();
    }

    @Override
    public List<Student> findStudentsByFirstNameContains(String name) {
        return studentRepository.findStudentsByFirstName(name);
    }

    @Override
    public List<Student> findStudentByGender(Gender gender) {
        return studentRepository.findStudentByGenderIgnoreCase(gender);
    }

    @Override
    public Student save(Student student) {
        student.setCreated(LocalDateTime.now());
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentByEmail(String email, Student student) {
        Student currentStudent = studentRepository.findStudentByEmail(email).get();
        if (currentStudent != null) {
            currentStudent.setFirstName(student.getFirstName());
            currentStudent.setLastName(student.getLastName());
            currentStudent.setEmail(student.getEmail());
            currentStudent.setGender(student.getGender());
            currentStudent.setAddress(student.getAddress());
            currentStudent.setFavouriteSubjects(student.getFavouriteSubjects());
            currentStudent.setTotalSpentInBooks(student.getTotalSpentInBooks());
            currentStudent.setCreated(currentStudent.getCreated());
        }
        return studentRepository.save(currentStudent);
    }
}
