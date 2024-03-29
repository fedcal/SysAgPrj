package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.VisitaMedicaCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaMedicaCartellaRepository extends JpaRepository<VisitaMedicaCartella, Integer> {
}
