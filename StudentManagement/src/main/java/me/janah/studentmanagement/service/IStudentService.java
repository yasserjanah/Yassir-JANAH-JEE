package me.janah.studentmanagement.service;

import me.janah.studentmanagement.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {
    void addStudent(Student student);
    Page<Student> findByName(String name, Pageable pageable);
    Page<Student> findAll(Pageable pageable);
    Student findById(String id);
    void deleteById(String id);
}
