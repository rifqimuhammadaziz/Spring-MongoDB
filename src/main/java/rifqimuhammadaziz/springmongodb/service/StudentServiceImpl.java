package rifqimuhammadaziz.springmongodb.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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
}
