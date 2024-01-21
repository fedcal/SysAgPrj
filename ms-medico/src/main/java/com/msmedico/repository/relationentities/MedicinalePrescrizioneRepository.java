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
    Optional<MedicinalePrescrizione> findByIdMedicinale(@Param("idMedicinale") Integer idMedicinale);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.cartellaClinica.idCartellaClinica = :idCartella")
    Optional<MedicinalePrescrizione> findByIdCartella(@Param("idCartella") Integer idCartellaClinica);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.medico.idMedico = :idMedico")
    Optional<MedicinalePrescrizione> findByIdMedico(@Param("idMedico") Integer idMedico);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.cartellaClinica.paziente.idPaziente = :idPaziente")
    Optional<MedicinalePrescrizione> findByIdPaziente(@Param("idPaziente") Integer idPaziente);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.cartellaClinica.paziente.nome = :nomePaziente " +
            "AND op.cartellaClinica.paziente.cognome = :cognomePaziente")
    List<MedicinalePrescrizione> findByNomeAndCognomePaziente(@Param("nomePaziente") String nomePaziente,
                                                              @Param("cognomePaziente") String cognomePaziente);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.medico.nome = :nomeMedico " +
            "AND op.medico.cognome = :cognomeMedico")
    List<MedicinalePrescrizione> findByNomeAndCognomeMedico(@Param("nomeMedico") String nomeMedico,
                                                            @Param("cognomeMedico") String cognomeMedico);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.cartellaClinica.paziente.cognome = :cognomePaziente")
    List<MedicinalePrescrizione> findByCognomePaziente(@Param("cognomePaziente") String cognomePaziente);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.medicinale.nome = :nomeMedicinale")
    List<MedicinalePrescrizione> findByNomeMedicinale(@Param("nomeMedicinale") String nomeMedicinale);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.cartellaClinica.paziente.nome = :nomePaziente ")
    List<MedicinalePrescrizione> findByNomePaziente(@Param("nomePaziente") String nomePaziente);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.medico.cognome = :cognomeMedico")
    List<MedicinalePrescrizione> findByCognomeMedico(@Param("cognomeMedico") String cognomeMedico);
    @Query("SELECT op FROM MedicinalePrescrizione op WHERE op.medico.nome = :nomeMedico")
    List<MedicinalePrescrizione> findByNomeMedico(@Param("nomeMedico") String nomeMedico);
}
