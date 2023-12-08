package com.msinfo.repository;

import com.msinfo.entity.relantionentities.RepartoInfermiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepartoInfermiereRepository extends JpaRepository<RepartoInfermiere,Integer> {
}
