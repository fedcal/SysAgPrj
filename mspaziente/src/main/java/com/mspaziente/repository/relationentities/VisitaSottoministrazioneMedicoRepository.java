package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.relationentities.VisitaSottoministrazioneMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaSottoministrazioneMedicoRepository extends JpaRepository<VisitaSottoministrazioneMedico,Integer> {
}
