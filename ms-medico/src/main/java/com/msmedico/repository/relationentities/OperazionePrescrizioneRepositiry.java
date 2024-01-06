package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.OperazionePrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperazionePrescrizioneRepositiry extends JpaRepository<OperazionePrescrizione,Integer> {
}
