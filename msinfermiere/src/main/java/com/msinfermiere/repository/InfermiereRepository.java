package com.msinfermiere.repository;

import com.msinfermiere.dto.InfermiereDto;
import com.msinfermiere.entity.Infermiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfermiereRepository extends JpaRepository<Infermiere,Integer> {
    List<Infermiere> findByNomeAndCognome(String nome, String cognome);

    List<Infermiere> findByNome(String nome);

    List<Infermiere> findByCognome(String cognome);
}
