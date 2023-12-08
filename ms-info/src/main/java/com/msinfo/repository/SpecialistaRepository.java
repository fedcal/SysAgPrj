package com.msinfo.repository;

import com.msinfo.entity.specialista.Specialista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistaRepository extends JpaRepository<Specialista,Integer> {
}
