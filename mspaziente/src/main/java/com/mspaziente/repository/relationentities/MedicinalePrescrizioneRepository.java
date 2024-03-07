package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.relationentities.MedicinalePrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicinalePrescrizioneRepository extends JpaRepository<MedicinalePrescrizione,Integer> {
    @Query("SELECT medicinalePre FROM MedicinalePrescrizione  medicinalePre WHERE medicinalePre.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    List<MedicinalePrescrizione> findByIdCartellaClinica(@Param("idCartellaClinica")Integer idCartellaClinica);
}
