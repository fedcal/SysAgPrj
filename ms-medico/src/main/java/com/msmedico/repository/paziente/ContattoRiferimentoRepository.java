package com.msmedico.repository.paziente;

import com.msmedico.entity.paziente.ContattoRiferimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContattoRiferimentoRepository extends JpaRepository<ContattoRiferimento,Integer> {
}
