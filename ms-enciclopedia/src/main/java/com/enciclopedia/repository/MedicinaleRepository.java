package com.enciclopedia.repository;

import com.enciclopedia.entity.Medicinale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface MedicinaleRepository extends JpaRepository<Medicinale, Integer> {
    Optional<Medicinale> findByNome(String nomeMedicinale);
    @Transactional
    void deleteByNome(String nomeMedicinale);
}
