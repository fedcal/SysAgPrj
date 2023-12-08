package com.msinfo.repository;

import com.msinfo.entity.reparto.Reparto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepartoRepository extends JpaRepository<Reparto,Integer> {
}
