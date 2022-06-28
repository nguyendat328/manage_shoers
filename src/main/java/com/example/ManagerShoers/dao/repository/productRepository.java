package com.example.ManagerShoers.dao.repository;

import com.example.ManagerShoers.dao.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

}
