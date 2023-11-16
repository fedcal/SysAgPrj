package com.enciclopedia.repository;

import com.enciclopedia.entity.Medicinale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinaleRepository extends JpaRepository<Medicinale, Integer> {
}
