package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.VisitaMedicaCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitaMedicaCartellaRepository extends JpaRepository<VisitaMedicaCartella,Integer> {
    @Query("SELECT vmc FROM VisitaMedicaCartella vmc WHERE vmc.visitaMedica.idVisitaMedica = :idVisitaMedica " +
            "AND vmc.cartellaClinica.idCartellaClinica = :idCartella")
    List<VisitaMedicaCartella> findByIdCartellaAndIdVisitaMedica(@Param("idCartella") Integer idCartella,
                                                                 @Param("idVisitaMedica") Integer idVisitaMedica);

    @Query("SELECT vmc FROM VisitaMedicaCartella vmc WHERE vmc.visitaMedica.idVisitaMedica = :idVisitaMedica")
    List<VisitaMedicaCartella> findByIdVisitaMedica(@Param("idVisitaMedica") Integer idVisitaMedica);

    @Query("SELECT vmc FROM VisitaMedicaCartella vmc WHERE vmc.cartellaClinica.idCartellaClinica = :idCartella")
    List<VisitaMedicaCartella> findByIdCartella(@Param("idCartella") Integer idCartella);

    @Query("SELECT vmc FROM VisitaMedicaCartella vmc WHERE vmc.refertoVisitaMedica.idReferto = :idReferto")
    List<VisitaMedicaCartella> findByIdReferto(@Param("idReferto") Integer idReferto);
}
