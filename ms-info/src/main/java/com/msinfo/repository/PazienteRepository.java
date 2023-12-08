package com.msinfo.repository;

import com.msinfo.entity.pazienti.Paziente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PazienteRepository extends JpaRepository<Paziente,Integer> {
}
