package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.OperazionePrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperazionePrescrizioneRepository extends JpaRepository<OperazionePrescrizione,Integer> {
}
