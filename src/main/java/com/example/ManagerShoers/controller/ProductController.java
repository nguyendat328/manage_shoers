package com.example.ManagerShoers.controller;

import com.example.ManagerShoers.dao.entity.Product;
import com.example.ManagerShoers.dao.model.productDTO;
import com.example.ManagerShoers.service.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private productservice productservice;
    @GetMapping("")
    public List<Product> getAll(){
        return productservice.getAll();
    }
    @GetMapping(value = "/{id}")
    public Product getById(int id){
        return productservice.getById(id);
    }
    @PostMapping(value = "/save/{id}")
    public String save(productDTO request){
        return productservice.save(request);
    }
    @PutMapping(value = "/update/{id}")
    public String update(productDTO request){
        return productservice.update(request);
    }
    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(int id){
        return productservice.delete(id);
    }
}
