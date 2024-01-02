package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.MalattiaCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MalattiaCartellaRepository extends JpaRepository<MalattiaCartella,Integer> {
}
