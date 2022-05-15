package me.janah.patientsmvc;

import me.janah.patientsmvc.entities.Patient;
import me.janah.patientsmvc.repositories.PatientRepository;
import me.janah.patientsmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "Yasser", new Date(), false, 112));
            patientRepository.save(new Patient(null, "Hamza", new Date(), true, 100));
            patientRepository.save(new Patient(null, "Amine", new Date(), true, 107));
            patientRepository.save(new Patient(null, "Mohammed", new Date(), false, 101));

            patientRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    CommandLineRunner saveUsers(SecurityService securityService) {
        return args -> {
            securityService.saveNewUser("yasser", "janah", "janah");
            securityService.saveNewUser("hamza", "janah", "janah");
            securityService.saveNewUser("amine", "janah", "janah");

            securityService.saveNewRole("USER", "Users of the system");
            securityService.saveNewRole("ADMIN", "Admins of the system");

            securityService.addRoleToUser("yasser", "USER");
            securityService.addRoleToUser("yasser", "ADMIN");
            securityService.addRoleToUser("hamza", "USER");
            securityService.addRoleToUser("amine", "USER");
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
