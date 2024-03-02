package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.relationentities.VisitaMedicaCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaMedicaCartellaRepository extends JpaRepository<VisitaMedicaCartella,Integer> {
}
