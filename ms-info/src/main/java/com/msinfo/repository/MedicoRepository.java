package com.msinfo.repository;

import com.msinfo.entity.medici.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Integer> {
}
