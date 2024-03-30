package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.VisitaEffettuataMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaEffettuataMedicoRepository extends JpaRepository<VisitaEffettuataMedico,Integer> {
}
