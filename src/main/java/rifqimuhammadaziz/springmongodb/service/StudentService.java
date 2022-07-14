package rifqimuhammadaziz.springmongodb.service;

import rifqimuhammadaziz.springmongodb.entity.Gender;
import rifqimuhammadaziz.springmongodb.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();

    Student findStudentByEmail(String email);

    List<Student> findStudentsByFirstNameContains(String name);

    List<Student> findStudentByGender(Gender gender);

    Student save(Student student);

    Student updateStudentByEmail(String email, Student student);
}
