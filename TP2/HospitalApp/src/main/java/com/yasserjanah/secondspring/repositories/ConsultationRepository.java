package com.yasserjanah.secondspring.repositories;

import com.yasserjanah.secondspring.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
