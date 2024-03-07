package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.relationentities.MalattiaCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MalattiaCartellaRepository extends JpaRepository<MalattiaCartella,Integer> {
    @Query("SELECT malattia FROM MalattiaCartella malattia WHERE malattia.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    List<MalattiaCartella> findByIdCartellaClinica(@Param("idCartellaClinica")Integer idCartellaClinica);
}
