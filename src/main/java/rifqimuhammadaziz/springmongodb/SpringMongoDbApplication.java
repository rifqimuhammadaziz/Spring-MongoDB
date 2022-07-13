package rifqimuhammadaziz.springmongodb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import rifqimuhammadaziz.springmongodb.entity.Address;
import rifqimuhammadaziz.springmongodb.entity.Gender;
import rifqimuhammadaziz.springmongodb.entity.Student;
import rifqimuhammadaziz.springmongodb.repository.StudentRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringMongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoDbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address(
                    "Indonesia",
                    "Semarang",
                    "52121"
            );
            String email = "bagasdwiyulianto@gmail.com";
            Student student = new Student(
                    "Bagas",
                    "Dwi Yulianto",
                    email,
                    Gender.MALE,
                    address,
                    List.of("Computer Sience"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );

            Query query = new Query();
            query.addCriteria(Criteria.where("email").is(email));

            List<Student> students = mongoTemplate.find(query, Student.class);
            if (students.size() > 1) {
                throw new IllegalStateException("Found many students with email " + email);
            }
            if (students.isEmpty()) {
                log.info("Inserting STUDENT: " + student);
                studentRepository.insert( student);
            } else {
                log.warn(student.getEmail() + " already exists.");
            }
        };
    }
}
