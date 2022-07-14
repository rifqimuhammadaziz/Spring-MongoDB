package rifqimuhammadaziz.springmongodb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void checkStudentExists() {
        boolean student = studentRepository.existsByEmail("rifqimuhammadaziz@gmail.com");
        System.out.println(student);
    }
}