package rifqimuhammadaziz.springmongodb.service;

import rifqimuhammadaziz.springmongodb.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
}
