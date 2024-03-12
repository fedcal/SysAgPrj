package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.MedicinaleSottoministrazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicinaleSottoministrazioneRepository extends JpaRepository<MedicinaleSottoministrazione,Integer> {
    @Query("SELECT medPresc FROM MedicinaleSottoministrazione medPresc WHERE " +
            "medPresc.medicinale.idMedicinale = :idMedicinale")
    List<MedicinaleSottoministrazione> findByIdMedicinale(@Param("idMedicinale") Integer idMedicinale);

    @Query("SELECT medPresc FROM MedicinalePrescrizione medPresc WHERE " +
            "medPresc.medico.idMedico = :idMedico")
    List<MedicinaleSottoministrazione> findByIdMedico(@Param("idMedico") Integer idMedico);

    @Query("SELECT medPresc FROM MedicinalePrescrizione medPresc WHERE " +
            "medPresc.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    List<MedicinaleSottoministrazione> findByIdCartellaClinica(@Param("idCartellaClinica") Integer idCartellaClinica);

    @Query("SELECT medPresc FROM MedicinalePrescrizione medPresc WHERE " +
            "medPresc.medicinale.nome = :nomeMedicinale")
    List<MedicinaleSottoministrazione> findByNomeMedicinale(@Param("nomeMedicinale") String nomeMedicinale);

    @Query("SELECT medPresc FROM MedicinalePrescrizione medPresc WHERE " +
            "medPresc.medico.nome = :nomeMedico AND "+
            "medPresc.medico.cognome = :cognomeMedico")
    List<MedicinaleSottoministrazione> findByNomeAndCognomeMedico(@Param("nomeMedico")String nomeMedico,@Param("cognomeMedico") String cognomeMedico);

    @Query("SELECT medPresc FROM MedicinalePrescrizione medPresc WHERE " +
            "medPresc.medico.nome = :nomeMedico")
    List<MedicinaleSottoministrazione> findByNomeMedico(@Param("nomeMedico") String nomeMedico);

    @Query("SELECT medPresc FROM MedicinalePrescrizione medPresc WHERE " +
            "medPresc.medico.cognome = :cognomeMedico")
    List<MedicinaleSottoministrazione> findByCognomeMedico(@Param("cognomeMedico") String cognomeMedico);

}
