package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.MedicinalePrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicinalePrescrizioneRepository extends JpaRepository<MedicinalePrescrizione, Integer> {
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.medicinale.idMedicinale = :idMedicinale")
    List<MedicinalePrescrizione> findByIdMedicinale(@Param("idMedicinale") Integer idMedicinale);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.cartellaClinica.idCartellaClinica = :idCartella")
    List<MedicinalePrescrizione> findByIdCartella(@Param("idCartella") Integer idCartellaClinica);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.medico.idMedico = :idMedico")
    List<MedicinalePrescrizione> findByIdMedico(@Param("idMedico") Integer idMedico);

    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.medico.nome = :nomeMedico " +
            "AND op.medico.cognome = :cognomeMedico")
    List<MedicinalePrescrizione> findByNomeAndCognomeMedico(@Param("nomeMedico") String nomeMedico,
                                                            @Param("cognomeMedico") String cognomeMedico);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.medicinale.nome = :nomeMedicinale")
    List<MedicinalePrescrizione> findByNomeMedicinale(@Param("nomeMedicinale") String nomeMedicinale);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.medico.cognome = :cognomeMedico")
    List<MedicinalePrescrizione> findByCognomeMedico(@Param("cognomeMedico") String cognomeMedico);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.medico.nome = :nomeMedico")
    List<MedicinalePrescrizione> findByNomeMedico(@Param("nomeMedico") String nomeMedico);
}
