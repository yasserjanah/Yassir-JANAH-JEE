package com.yasserjanah.secondspring.repositories;

import com.yasserjanah.secondspring.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String name);
}
