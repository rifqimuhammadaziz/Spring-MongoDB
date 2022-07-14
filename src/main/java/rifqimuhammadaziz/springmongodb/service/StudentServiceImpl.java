package rifqimuhammadaziz.springmongodb.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springmongodb.entity.Gender;
import rifqimuhammadaziz.springmongodb.entity.Student;
import rifqimuhammadaziz.springmongodb.error.StudentNotFoundException;
import rifqimuhammadaziz.springmongodb.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentByEmail(String email) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findStudentByEmail(email);
        if (!student.isPresent()) {
            throw new StudentNotFoundException("Student with email " + email + " not found");
        }
        return student.get();
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
        boolean checkStudent = studentRepository.existsByEmail(student.getEmail());
        if (!checkStudent) {
            student.setCreated(LocalDateTime.now());
            return studentRepository.save(student);
        }
        // TODO : return if data exists
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

    @Override
    public void deleteStudentByEmail(String email) {
        studentRepository.deleteStudentByEmail(email);
    }
}
