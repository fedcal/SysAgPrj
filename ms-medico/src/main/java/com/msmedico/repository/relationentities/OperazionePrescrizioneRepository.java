package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.OperazionePrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperazionePrescrizioneRepository extends JpaRepository<OperazionePrescrizione,Integer> {
    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.operazioneMedica.idOperazioneMedica = :idOperazione")
    Optional<OperazionePrescrizione> findByIdOperazione(@Param("idOperazione") Integer idOperazione);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.cartellaClinica.idCartellaClinica = :idCartella")
    Optional<OperazionePrescrizione> findByIdCartella(@Param("idCartella") Integer idCartella);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.medico.idMedico = :idMedico")
    Optional<OperazionePrescrizione> findByIdMedico(@Param("idMedico") Integer idMedico);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.cartellaClinica.paziente.idPaziente = :idPaziente")
    Optional<OperazionePrescrizione> findByIdPaziente(@Param("idPaziente") Integer idPaziente);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.cartellaClinica.paziente.nome = :nomePaziente " +
            "AND op.cartellaClinica.paziente.cognome = :cognomePaziente")
    List<OperazionePrescrizione> findByNomeAndCognomePaziente(@Param("nomePaziente") String nomePaziente,
                                                              @Param("cognomePaziente") String cognomePaziente);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.medico.nome = :nomeMedico " +
            "AND op.medico.cognome = :cognomeMedico")
    List<OperazionePrescrizione> findByNomeAndCognomeMedico(@Param("nomeMedico") String nomeMedico,
                                                            @Param("cognomeMedico") String cognomeMedico);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.medico.cognome = :cognomeMedico")
    Optional<OperazionePrescrizione> findByCognomeMedico(@Param("cognomeMedico") String cognomeMedico);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.cartellaClinica.paziente.nome = :nomePaziente")
    Optional<OperazionePrescrizione> findByNomePaziente(@Param("nomePaziente") String nomePaziente);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.cartellaClinica.paziente.cognome = :cognomePaziente")
    Optional<OperazionePrescrizione> findByCognomePaziente(@Param("cognomePaziente") String cognomePaziente);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.operazioneMedica.nome = :nomeOperazione ")
    Optional<OperazionePrescrizione> findByNomeOperazione(@Param("nomeOperazione") String nomeOperazione);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.medico.nome = :nomeMedico ")
    Optional<OperazionePrescrizione> findByNomeMedico(@Param("nomeMedico") String nomeMedico);
}
