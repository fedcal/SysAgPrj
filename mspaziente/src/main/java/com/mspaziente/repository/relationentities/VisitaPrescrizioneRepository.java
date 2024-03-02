package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.relationentities.VisitaPrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaPrescrizioneRepository extends JpaRepository<VisitaPrescrizione,Integer> {
}
