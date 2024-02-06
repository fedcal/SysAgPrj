package com.msinfermiere.repository.paziente;

import com.msinfermiere.entity.paziente.CartellaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartellaClinicaRepository extends JpaRepository<CartellaClinica,Integer> {
}
