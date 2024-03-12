package com.msmedico.repository.paziente;

import com.msmedico.entity.paziente.CartellaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartellaClinicaRepository extends JpaRepository<CartellaClinica,Integer> {

}
