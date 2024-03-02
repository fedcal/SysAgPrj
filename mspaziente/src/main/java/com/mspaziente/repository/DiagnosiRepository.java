package com.mspaziente.repository;

import com.mspaziente.entity.Diagnosi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosiRepository extends JpaRepository<Diagnosi,Integer> {
}
