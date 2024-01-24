package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.OperazioneCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperazioneCartellaRepository extends JpaRepository<OperazioneCartella,Integer> {
    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.operazioneMedica.idOperazioneMedica = :idOperazione")
    Optional<OperazioneCartella> findByIdOperazione(@Param("idOperazione") Integer idOperazione);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    Optional<OperazioneCartella> findByIdCartellaClinica(@Param("idCartellaClinica") Integer idCartellaClinica);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.cartellaClinica.paziente.idPaziente = :idPaziente")
    Optional<OperazioneCartella> findByIdPaziente(@Param("idPaziente") Integer idPaziente);
    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.medico.idMedico = :idMedico")
    Optional<OperazioneCartella> findByIdMedico(@Param("idMedico") Integer idMedico);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.refertoOperazione.idReferto = :idReferto")
    Optional<OperazioneCartella> findByIdReferto(@Param("idReferto") Integer idReferto);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.operazioneMedica.nome = :nomeOperazione")
    List<OperazioneCartella> findByNomeOperazione(@Param("nomeOperazione") String nomeOperazione);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.cartellaClinica.paziente.nome = :nomePaziente " +
            "AND oc.cartellaClinica.paziente.cognome = :cognomePaziente")
    List<OperazioneCartella> findByNomePazienteAndCognomePaziente(@Param("nomePaziente") String nomePaziente,
                                                                  @Param("cognomePaziente") String cognomePaziente);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.cartellaClinica.paziente.nome = :nomePaziente")
    List<OperazioneCartella> findByNomePaziente(@Param("nomePaziente") String nomePaziente);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.cartellaClinica.paziente.cognome = :cognomePaziente")
    List<OperazioneCartella> findByCognomePaziente(@Param("cognomePaziente") String cognomePaziente);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.medico.nome = :nomeMedico " +
            "AND oc.medico.cognome = :cognomeMedico")
    List<OperazioneCartella> findByNomeMedicoAndCognomeMedico(@Param("nomeMedico") String nomeMedico,
                                                              @Param("cognomeMedico") String cognomeMedico);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.medico.nome = :nomeMedico")
    List<OperazioneCartella> findByNomeMedico(@Param("nomeMedico") String nomeMedico);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.medico.cognome = :cognomeMedico")
    List<OperazioneCartella> findByCognomeMedico(@Param("cognomeMedico") String cognomeMedico);
}
