package com.mspaziente.repository;

import com.mspaziente.entity.Infermiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfermiereRepository extends JpaRepository<Infermiere,Integer> {
}
