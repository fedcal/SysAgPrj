package com.msinfermiere.repository.account;

import com.msinfermiere.entity.account.OperazioneAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperazioneAccountRepository extends JpaRepository<OperazioneAccount,Integer> {
}
