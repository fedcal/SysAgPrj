package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.OperazioneConsentita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperazioneConsentitaRepository extends JpaRepository<OperazioneConsentita,Integer> {
}
