package com.msinfo.repository;

import com.msinfo.entity.reparto.Reparto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepartoRepository extends JpaRepository<Reparto,Integer> {
    Optional<Reparto> findByNomeReparto(String nomeReparto);
}
