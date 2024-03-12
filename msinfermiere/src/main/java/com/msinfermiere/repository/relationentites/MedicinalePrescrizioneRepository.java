package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.MedicinalePrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicinalePrescrizioneRepository extends JpaRepository<MedicinalePrescrizione,Integer> {
    @Query("SELECT medPresc FROM MedicinalePrescrizione medPresc WHERE " +
            "medPresc.medicinale.idMedicinale = :idMedicinale")
    List<MedicinalePrescrizione> findByIdMedicinale(@Param("idMedicinale") Integer idMedicinale);
    @Query("SELECT medPresc FROM MedicinalePrescrizione medPresc WHERE " +
            "medPresc.medico.idMedico = :idMedico")
    List<MedicinalePrescrizione> findByIdMedico(@Param("idMedico") Integer idMedico);
    @Query("SELECT medPresc FROM MedicinalePrescrizione medPresc WHERE " +
            "medPresc.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    List<MedicinalePrescrizione> findByIdCartellaClinica(@Param("idCartellaClinica") Integer idCartellaClinica);

    @Query("SELECT medPresc FROM MedicinalePrescrizione medPresc WHERE " +
            "medPresc.medicinale.nome = :nomeMedicinale")
    List<MedicinalePrescrizione> findByNomeMedicinale(@Param("nomeMedicinale") String nomeMedicinale);

    @Query("SELECT medPresc FROM MedicinalePrescrizione medPresc WHERE " +
            "medPresc.medico.nome = :nomeMedico AND "+
            "medPresc.medico.cognome = :cognomeMedico")
    List<MedicinalePrescrizione> findByNomeAndCognomeMedico(@Param("nomeMedico") String nomeMedico,@Param("cognomeMedico") String cognomeMedico);


    @Query("SELECT medPresc FROM MedicinalePrescrizione medPresc WHERE " +
            "medPresc.medico.nome = :nomeMedico")
    List<MedicinalePrescrizione> findByNomeMedico(@Param("nomeMedico") String nomeMedico);

    @Query("SELECT medPresc FROM MedicinalePrescrizione medPresc WHERE " +
            "medPresc.medico.cognome = :cognomeMedico")
    List<MedicinalePrescrizione> findByCognomeMedico(@Param("cognomeMedico") String cognomeMedico);
}
