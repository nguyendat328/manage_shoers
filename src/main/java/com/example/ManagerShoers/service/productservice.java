package com.example.ManagerShoers.service;

import com.example.ManagerShoers.dao.entity.Product;
import com.example.ManagerShoers.dao.model.productDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface productservice {
    List<Product> getAll();
    Product getById(int id);
    String save(productDTO request);
    String update(productDTO request);
    boolean delete(int id);
}
