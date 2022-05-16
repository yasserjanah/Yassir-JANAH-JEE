package me.janah.studentmanagement.repositories;

import me.janah.studentmanagement.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, String> {
    @Query("select s from Student s where s.firstName like %:name% or s.lastName like %:name%")
    Page<Student> findByFirstNameOrLastName(@Param("name") String Name, Pageable pageable);

    Page<Student> findByFirstName(String firstName, Pageable pageable);
}
