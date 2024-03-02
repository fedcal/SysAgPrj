package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.relationentities.MedicinaleCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinaleCartellaRepository extends JpaRepository<MedicinaleCartella,Integer> {
}
