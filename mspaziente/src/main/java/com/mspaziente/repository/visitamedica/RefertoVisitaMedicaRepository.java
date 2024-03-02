package com.mspaziente.repository.visitamedica;

import com.mspaziente.entity.visitamedica.RefertoVisitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefertoVisitaMedicaRepository extends JpaRepository<RefertoVisitaMedica,Integer> {
}
