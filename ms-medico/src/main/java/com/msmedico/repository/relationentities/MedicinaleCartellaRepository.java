package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.MedicinaleCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinaleCartellaRepository extends JpaRepository<MedicinaleCartella,Integer> {
}
