package com.yasserjanah.secondspring.services;

import com.yasserjanah.secondspring.entities.Consultation;
import com.yasserjanah.secondspring.entities.Medecin;
import com.yasserjanah.secondspring.entities.Patient;
import com.yasserjanah.secondspring.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
