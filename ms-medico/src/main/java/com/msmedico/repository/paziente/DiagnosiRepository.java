package com.msmedico.repository.paziente;

import com.msmedico.entity.paziente.Diagnosi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosiRepository extends JpaRepository<Diagnosi,Integer> {
}
