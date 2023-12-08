package com.msinfo.repository;

import com.msinfo.entity.infermieri.Infermiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfermiereRepository extends JpaRepository<Infermiere,Integer> {
}
