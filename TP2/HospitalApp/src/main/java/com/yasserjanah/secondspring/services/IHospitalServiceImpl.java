package com.yasserjanah.secondspring.services;

import com.yasserjanah.secondspring.entities.Consultation;
import com.yasserjanah.secondspring.entities.Medecin;
import com.yasserjanah.secondspring.entities.Patient;
import com.yasserjanah.secondspring.entities.RendezVous;
import com.yasserjanah.secondspring.repositories.ConsultationRepository;
import com.yasserjanah.secondspring.repositories.MedecinRepository;
import com.yasserjanah.secondspring.repositories.PatientRepository;
import com.yasserjanah.secondspring.repositories.RendezVousRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class IHospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
