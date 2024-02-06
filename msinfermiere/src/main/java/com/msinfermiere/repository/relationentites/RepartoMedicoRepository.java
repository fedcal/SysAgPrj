package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.RepartoMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepartoMedicoRepository extends JpaRepository<RepartoMedico,Integer> {
}
