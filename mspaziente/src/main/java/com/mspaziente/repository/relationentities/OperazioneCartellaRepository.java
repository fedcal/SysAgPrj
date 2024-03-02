package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.relationentities.OperazioneCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperazioneCartellaRepository extends JpaRepository<OperazioneCartella,Integer> {
}
