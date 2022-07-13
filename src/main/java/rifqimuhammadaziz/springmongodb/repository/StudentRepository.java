package rifqimuhammadaziz.springmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rifqimuhammadaziz.springmongodb.entity.Student;

public interface StudentRepository
        extends MongoRepository<Student, String> {
}
