package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.MedicinaleCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinaleCartellaRepository extends JpaRepository<MedicinaleCartella,Integer> {
}
