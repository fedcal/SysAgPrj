package com.msinfo.repository;

import com.msinfo.entity.relantionentities.OperazioneConsentita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperazioneConsentitaRepository extends JpaRepository<OperazioneConsentita,Integer> {
}
