package com.example.ManagerShoers.service;

import com.example.ManagerShoers.dao.entity.Product;
import com.example.ManagerShoers.dao.model.ProductCreateModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    Product saveProduct(ProductCreateModel product);

    Product updateProduct(Product product);

    void remove(Integer id);

    boolean checkTypeId(Integer id);

    boolean checkBrandId(Integer id);
}
