package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.MedicinalePrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinalePrescrizioneRepository extends JpaRepository<MedicinalePrescrizione, Integer> {
}
