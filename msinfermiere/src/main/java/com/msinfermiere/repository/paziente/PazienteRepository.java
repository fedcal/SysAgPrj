package com.msinfermiere.repository.paziente;

import com.msinfermiere.entity.paziente.Paziente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PazienteRepository extends JpaRepository<Paziente,Integer> {
}
