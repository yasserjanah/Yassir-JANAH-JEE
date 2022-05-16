package me.janah.studentmanagement.service;

import lombok.AllArgsConstructor;
import me.janah.studentmanagement.entities.Student;
import me.janah.studentmanagement.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService{

    private StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        // if student id is not null, then update
        if (student.getId() != null) {
            studentRepository.save(student);
            return;
        }
        // create new student
        student.setId(UUID.randomUUID().toString());
        studentRepository.save(student);
    }

    @Override
    public Page<Student> findByName(String name, Pageable pageable) {
        return studentRepository.findByFirstNameOrLastName(name, pageable);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }
}
