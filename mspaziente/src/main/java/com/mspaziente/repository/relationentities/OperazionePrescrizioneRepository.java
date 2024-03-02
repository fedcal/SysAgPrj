package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.relationentities.OperazionePrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperazionePrescrizioneRepository extends JpaRepository<OperazionePrescrizione,Integer> {
}
