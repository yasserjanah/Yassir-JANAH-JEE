package com.yasserjanah.secondspring;

import com.yasserjanah.secondspring.entities.*;
import com.yasserjanah.secondspring.repositories.ConsultationRepository;
import com.yasserjanah.secondspring.repositories.MedecinRepository;
import com.yasserjanah.secondspring.repositories.PatientRepository;
import com.yasserjanah.secondspring.repositories.RendezVousRepository;
import com.yasserjanah.secondspring.services.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SecondSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository){
        return args -> {
            System.out.println("**** doing something before starting the application ****");
            Stream.of("Mohammed", "Hassan", "Najat")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });

            Stream.of("Aymane", "Hanane", "Yasmine")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });

            Patient patient = patientRepository.findById(1L).orElse(null);
            //Patient patient1 = patientRepository.findByNom("Mohammed");

            Medecin medecin = medecinRepository.findById(1L).orElse(null);

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            hospitalService.saveRDV(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapportConsultation("C'est le rapport de consulation");
            hospitalService.saveConsultation(consultation);

        };
    }

}
