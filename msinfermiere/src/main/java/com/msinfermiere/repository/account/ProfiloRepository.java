package com.msinfermiere.repository.account;

import com.msinfermiere.entity.account.Profilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfiloRepository extends JpaRepository<Profilo,Integer> {
}
