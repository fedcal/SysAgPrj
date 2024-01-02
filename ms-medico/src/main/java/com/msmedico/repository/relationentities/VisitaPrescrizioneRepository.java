package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.VisitaPrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaPrescrizioneRepository extends JpaRepository<VisitaPrescrizione,Integer> {
}
