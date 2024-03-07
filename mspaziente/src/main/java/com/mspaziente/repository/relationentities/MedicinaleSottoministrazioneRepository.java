package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.relationentities.MedicinaleSottoministrazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicinaleSottoministrazioneRepository extends JpaRepository<MedicinaleSottoministrazione,Integer> {
    @Query("SELECT medicinaleSottoministrazione FROM MedicinaleSottoministrazione medicinaleSottoministrazione WHERE medicinaleSottoministrazione.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    List<MedicinaleSottoministrazione> findByIdCartellaClinica(@Param("idCartellaClinica") Integer idCartellaClinica);
}
