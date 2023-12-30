package com.msinfo.repository;

import com.msinfo.entity.account.Profilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfiloRepository extends JpaRepository<Profilo,Integer> {
    Optional<Profilo> findByTipo(String tipo);
}
