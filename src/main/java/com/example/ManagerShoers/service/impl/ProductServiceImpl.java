package com.example.ManagerShoers.service.impl;

import com.example.ManagerShoers.common.Constants;
import com.example.ManagerShoers.dao.entity.Brand;
import com.example.ManagerShoers.dao.entity.Product;
import com.example.ManagerShoers.dao.entity.ShoersType;
import com.example.ManagerShoers.dao.model.ProductCreateModel;
import com.example.ManagerShoers.dao.repo.IBrandRepository;
import com.example.ManagerShoers.dao.repo.IProductRepository;
import com.example.ManagerShoers.dao.repo.IShoersTypeRepository;
import com.example.ManagerShoers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IBrandRepository brandRepository;

    @Autowired
    private IShoersTypeRepository shoersTypeRepository;


    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() {

        return productRepository.findAllByStatus(Constants.STATUS_ACTIVE);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(ProductCreateModel product) {
        Product pro = new Product();
        pro.setName(product.getName());
        pro.setBrandId(product.getBrandId());
        pro.setTypeId(product.getTypeId());
        pro.setSize(product.getSize());
        pro.setColor(product.getColor());
        pro.setImgUrl(product.getImgUrl());
        pro.setStatus("pending");
        return productRepository.save(pro);
    }

    @Override
    public void remove(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean checkTypeId(Integer id) {
        ShoersType obj = shoersTypeRepository.findById(id).get();
        if (obj == null){
            return false;
        }else{
            return true;
        }



    }

    @Override
    public boolean checkBrandId(Integer id) {
        Brand obj = brandRepository.findById(id).get();
        if (obj == null){
            return false;
        }else{
            return true;
        }
    }
}
