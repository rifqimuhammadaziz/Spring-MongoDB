package rifqimuhammadaziz.springmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rifqimuhammadaziz.springmongodb.entity.Gender;
import rifqimuhammadaziz.springmongodb.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository
        extends MongoRepository<Student, String> {
    Optional<Student> findStudentByEmail(String email);
    List<Student> findStudentsByFirstName(String name);
    List<Student> findStudentByGenderIgnoreCase(Gender gender);
    void deleteStudentByEmail(String email);
    boolean existsByEmail(String email);
}
