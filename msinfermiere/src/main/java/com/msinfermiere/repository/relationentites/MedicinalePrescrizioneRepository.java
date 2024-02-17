package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.MedicinalePrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinalePrescrizioneRepository extends JpaRepository<MedicinalePrescrizione,Integer> {
}
