package rifqimuhammadaziz.springmongodb.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springmongodb.entity.Gender;
import rifqimuhammadaziz.springmongodb.entity.Student;
import rifqimuhammadaziz.springmongodb.repository.StudentRepository;

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
}
