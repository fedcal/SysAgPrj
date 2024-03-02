package com.mspaziente.repository;

import com.mspaziente.entity.CartellaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartellaClinicaRepository extends JpaRepository<CartellaClinica,Integer> {
}
