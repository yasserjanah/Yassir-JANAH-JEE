package me.janah.studentmanagement;

import me.janah.studentmanagement.entities.GenderType;
import me.janah.studentmanagement.entities.Student;
import me.janah.studentmanagement.security.service.ISecurityService;
import me.janah.studentmanagement.service.IStudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IStudentService studentService, ISecurityService securityService) {
        return (args) -> {
            // Create a few students
            Stream.of("John", "Jane", "Jack", "Jill", "Yasser", "Hamza", "Amine", "Ahmed", "Mohammed", "Magd").forEach(name -> {
                Student student = new Student();
                student.setFirstName(name);
                student.setLastName("Doe");
                student.setEmail(name.toLowerCase() + "@gmail.com");
                student.setDateOfBirth(new Date());
                student.setGender(Math.random() > 0.5 ? GenderType.MALE : GenderType.FEMALE);
                student.setEnRegle(Math.random() > 0.5);
                studentService.addStudent(student);
            });

            // create a few users
            securityService.saveNewUser( "admin", "admin", "admin");
            securityService.saveNewUser( "user", "user", "user");

            // create a few roles
            securityService.saveNewRole( "ADMIN",  "Admins of the system");
            securityService.saveNewRole( "USER", "Users of the system");

            // add roles to users
            securityService.addRoleToUser("admin", "ADMIN");
            securityService.addRoleToUser("admin", "USER");
            securityService.addRoleToUser( "user", "USER");
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
