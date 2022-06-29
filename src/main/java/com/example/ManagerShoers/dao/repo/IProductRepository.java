package com.example.ManagerShoers.dao.repo;

import com.example.ManagerShoers.dao.entity.Brand;
import com.example.ManagerShoers.dao.entity.Product;
import com.example.ManagerShoers.dao.entity.ShoersType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByStatus(String status);
}
