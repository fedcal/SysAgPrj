package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.relationentities.MalattiaCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MalattiaCartellaRepository extends JpaRepository<MalattiaCartella,Integer> {
}
