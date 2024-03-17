package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.MedicinaleCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicinaleCartellaRepository extends JpaRepository<MedicinaleCartella,Integer> {
    @Query("SELECT medicinale FROM MedicinaleCartella medicinale WHERE medicinale.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    List<MedicinaleCartella> findByIdCartellaClinica(Integer idCartellaClinica);
}
