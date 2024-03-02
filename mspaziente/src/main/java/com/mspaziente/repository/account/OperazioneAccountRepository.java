package com.mspaziente.repository.account;

import com.mspaziente.entity.account.OperazioneAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperazioneAccountRepository extends JpaRepository<OperazioneAccount,Integer> {
}
