package com.example.ManagerShoers.service;

import com.example.ManagerShoers.common.ServiceResponse;
import com.example.ManagerShoers.dao.entity.Product;
import com.example.ManagerShoers.dao.model.ProductCreateModel;
import org.hibernate.service.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    ServiceResponse<Product> saveProduct(ProductCreateModel product);

    ServiceResponse<Product> updateProduct(Integer id, ProductCreateModel product);

    Product removeProduct(Integer id);

    boolean checkTypeId(Integer id);

    boolean checkBrandId(Integer id);

    void createMail();

}
