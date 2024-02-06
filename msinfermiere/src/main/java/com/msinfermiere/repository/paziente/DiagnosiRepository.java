package com.msinfermiere.repository.paziente;

import com.msinfermiere.entity.paziente.Diagnosi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosiRepository extends JpaRepository<Diagnosi,Integer> {
}
