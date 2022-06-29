package com.example.ManagerShoers.dao.repo;

import com.example.ManagerShoers.dao.entity.ShoersType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoersTypeRepository extends JpaRepository<ShoersType, Integer> {
}
