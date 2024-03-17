package com.msmedico.repository.paziente;

import com.msmedico.entity.paziente.Diagnosi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosiRepository extends JpaRepository<Diagnosi,Integer> {
    @Query("SELECT diagnosi FROM Diagnosi diagnosi WHERE diagnosi.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    List<Diagnosi> findByIdCartellaClinica(@Param("idCartellaClinica") Integer idCartellaClinica);

}
