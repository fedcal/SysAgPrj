package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.VisitaSottoministrazioneMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaSottoministrazioneMedicoRepository extends JpaRepository<VisitaSottoministrazioneMedico,Integer> {
}
