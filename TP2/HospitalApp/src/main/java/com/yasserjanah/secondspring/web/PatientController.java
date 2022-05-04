package com.yasserjanah.secondspring.web;

import com.yasserjanah.secondspring.entities.Patient;
import com.yasserjanah.secondspring.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController  {

    @Autowired
    PatientRepository patientRepository;


    @GetMapping("/patients")
    public List<Patient> getPatients(){
        // return Json format
        return patientRepository.findAll();
    }

    @GetMapping("/patients/count")
    public long getPatientsCount(){
        // return Json format
        return patientRepository.count();
    }

    @GetMapping("/patients/findByName")
    public Patient getPatientByName(){
        // return Json format
        return patientRepository.findByNom("Mohammed");
    }

}