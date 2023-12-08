package com.enciclopedia.repository;

import com.enciclopedia.entity.Malattia;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
public interface MalattiaRepository extends JpaRepository<Malattia, Integer> {
    Optional<Malattia> findByNome(String nome);
    @Transactional
    void deleteByNome(String nomeMalattia);
}
