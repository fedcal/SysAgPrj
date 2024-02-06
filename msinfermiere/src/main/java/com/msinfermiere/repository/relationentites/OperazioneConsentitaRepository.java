package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.OperazioneConsentita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperazioneConsentitaRepository extends JpaRepository<OperazioneConsentita,Integer> {
}
