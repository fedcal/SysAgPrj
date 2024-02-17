package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.OperazioneCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperazioneCartellaRepository extends JpaRepository<OperazioneCartella,Integer> {
}
