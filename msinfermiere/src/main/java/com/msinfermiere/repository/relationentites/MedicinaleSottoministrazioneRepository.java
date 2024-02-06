package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.MedicinaleSottoministrazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinaleSottoministrazioneRepository extends JpaRepository<MedicinaleSottoministrazione,Integer> {
}
