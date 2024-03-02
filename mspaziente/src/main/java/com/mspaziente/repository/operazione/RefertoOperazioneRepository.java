package com.mspaziente.repository.operazione;

import com.mspaziente.entity.operazione.RefertoOperazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefertoOperazioneRepository extends JpaRepository<RefertoOperazione,Integer> {
}
