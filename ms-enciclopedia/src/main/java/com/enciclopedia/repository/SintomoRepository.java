package com.enciclopedia.repository;

import com.enciclopedia.entity.Sintomo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SintomoRepository extends JpaRepository<Sintomo,Integer> {
    Optional<Sintomo> findByNome(String nomeSintomo);

    void deleteByNome(String nomeSintomo);
}
