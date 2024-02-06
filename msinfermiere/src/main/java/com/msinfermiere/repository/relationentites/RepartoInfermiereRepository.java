package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.RepartoInfermiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepartoInfermiereRepository extends JpaRepository<RepartoInfermiere,Integer> {
}
