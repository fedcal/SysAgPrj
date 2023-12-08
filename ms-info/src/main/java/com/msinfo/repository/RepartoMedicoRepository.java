package com.msinfo.repository;

import com.msinfo.entity.relantionentities.RepartoMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepartoMedicoRepository extends JpaRepository<RepartoMedico,Integer> {
}
