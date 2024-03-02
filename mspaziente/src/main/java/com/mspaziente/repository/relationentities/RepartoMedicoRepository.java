package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.Reparto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepartoMedicoRepository extends JpaRepository<Reparto,Integer> {
}
