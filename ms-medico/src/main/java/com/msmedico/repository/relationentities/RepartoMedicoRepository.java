package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.RepartoMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepartoMedicoRepository extends JpaRepository<RepartoMedico,Integer> {
}
