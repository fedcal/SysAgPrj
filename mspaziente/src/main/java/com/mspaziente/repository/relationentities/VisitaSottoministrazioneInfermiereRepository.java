package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.relationentities.VisitaSottoministrazioneInfermiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaSottoministrazioneInfermiereRepository extends JpaRepository<VisitaSottoministrazioneInfermiere,Integer> {
}
