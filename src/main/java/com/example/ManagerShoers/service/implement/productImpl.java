package com.example.ManagerShoers.service.implement;

import com.example.ManagerShoers.dao.entity.Product;
import com.example.ManagerShoers.dao.model.productDTO;
import com.example.ManagerShoers.dao.repository.productRepository;
import com.example.ManagerShoers.service.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class productImpl implements productservice {
    @Autowired
    private productRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public String save(productDTO request) {
        try {
            Product product = new Product(request.getId(),request.getName(),request.getTypeId(),request.getBrandId(),
                    request.getSize(),request.getColor(),request.getImgUrl(),request.getStatus());
            productRepository.save(product);
            return "Thêm thành công";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String update(productDTO request) {
        try {
            Product product = productRepository.findById(request.getId()).get();
            product.setName(request.getName());
            productRepository.save(product);
            return "Thêm thành công";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            productRepository.delete(productRepository.findById(id).get());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
