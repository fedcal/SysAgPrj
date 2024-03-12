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
    List<OperazionePrescrizione> findByIdOperazione(@Param("idOperazione") Integer idOperazione);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.cartellaClinica.idCartellaClinica = :idCartella")
    List<OperazionePrescrizione> findByIdCartella(@Param("idCartella") Integer idCartella);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.medico.idMedico = :idMedico")
    List<OperazionePrescrizione> findByIdMedico(@Param("idMedico") Integer idMedico);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.medico.nome = :nomeMedico " +
            "AND op.medico.cognome = :cognomeMedico")
    List<OperazionePrescrizione> findByNomeAndCognomeMedico(@Param("nomeMedico") String nomeMedico,
                                                            @Param("cognomeMedico") String cognomeMedico);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.medico.cognome = :cognomeMedico")
    List<OperazionePrescrizione> findByCognomeMedico(@Param("cognomeMedico") String cognomeMedico);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.operazioneMedica.nome = :nomeOperazione ")
    List<OperazionePrescrizione> findByNomeOperazione(@Param("nomeOperazione") String nomeOperazione);

    @Query("SELECT op FROM OperazionePrescrizione op WHERE op.medico.nome = :nomeMedico ")
    List<OperazionePrescrizione> findByNomeMedico(@Param("nomeMedico") String nomeMedico);

}
