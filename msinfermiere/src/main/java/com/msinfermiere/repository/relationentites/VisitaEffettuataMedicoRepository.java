package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.visitamedica.VisitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaEffettuataMedicoRepository extends JpaRepository<VisitaMedica,Integer> {
}
