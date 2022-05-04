package com.yasserjanah.secondspring.repositories;

import com.yasserjanah.secondspring.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    @Query("select m from Medecin m where m.nom = :nom")
    Medecin findByNom(@Param("nom") String name);
}
