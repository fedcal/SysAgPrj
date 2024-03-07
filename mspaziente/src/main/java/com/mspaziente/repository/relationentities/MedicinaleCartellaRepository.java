package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.relationentities.MedicinaleCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicinaleCartellaRepository extends JpaRepository<MedicinaleCartella,Integer> {
    @Query("SELECT medicinale FROM MedicinaleCartella medicinale WHERE medicinale.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    List<MedicinaleCartella> findByIdCartellaClinica(@Param("idCartellaClinica")Integer idCartellaClinica);
}
