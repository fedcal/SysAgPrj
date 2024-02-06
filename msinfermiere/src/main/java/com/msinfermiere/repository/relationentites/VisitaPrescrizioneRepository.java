package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.VisitaPrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaPrescrizioneRepository extends JpaRepository<VisitaPrescrizione,Integer> {
}
