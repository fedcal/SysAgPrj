package com.msinfo.repository;

import com.msinfo.entity.infermieri.Infermiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InfermiereRepository extends JpaRepository<Infermiere,Integer> {
    List<Infermiere> findByNomeAndCognome(String nomeInfermiere, String cognomeInfermiere);

    List<Infermiere> findByNome(String nomeInfermiere);

    List<Infermiere> findByCognome(String cognomeInfermiere);
}
