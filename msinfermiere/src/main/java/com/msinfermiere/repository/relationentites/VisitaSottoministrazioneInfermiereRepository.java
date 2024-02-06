package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.VisitaSottoministrazioneInfermiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaSottoministrazioneInfermiereRepository extends JpaRepository<VisitaSottoministrazioneInfermiere,Integer> {
}
