package com.example.ManagerShoers.service.impl;

import com.example.ManagerShoers.common.Constants;
import com.example.ManagerShoers.common.ServiceResponse;
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
    public ServiceResponse<Product> updateProduct(Integer id, ProductCreateModel product) {
        Product pro = productRepository.findById(id).get();
        if (pro != null){
            pro.setName(product.getName());
            pro.setBrandId(product.getBrandId());
            pro.setTypeId(product.getTypeId());
            pro.setSize(product.getSize());
            pro.setColor(product.getColor());
            pro.setImgUrl(product.getImgUrl());
            pro.setStatus(Constants.STATUS_PENDING);
            Product newProuct = productRepository.save(pro);
            return new ServiceResponse<>(Constants.SUCCESS, Constants.SUCCESS_MESSAGE, newProuct);
        }
        return new ServiceResponse<>(Constants.ERROR, Constants.ERROR_MESSAGE, null);
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
    public ServiceResponse<Product> saveProduct(ProductCreateModel product) {


        Product pro = new Product();
        pro.setName(product.getName());
        pro.setBrandId(product.getBrandId());
        pro.setTypeId(product.getTypeId());
        pro.setSize(product.getSize());
        pro.setColor(product.getColor());
        pro.setImgUrl(product.getImgUrl());
        pro.setStatus(Constants.STATUS_PENDING);
        Product newProduct = productRepository.save(pro);

        return new ServiceResponse<Product>(Constants.SUCCESS, Constants.SUCCESS_MESSAGE, newProduct);
    }

    @Override
    public Product removeProduct(Integer id) {
        Product product = productRepository.findById(id).get();
        if (product != null){
            product.setStatus(Constants.STATUS_INACTIVE);
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public boolean checkTypeId(Integer id) {
        Optional<ShoersType> shoersType = shoersTypeRepository.findById(id);

        if (shoersType.isPresent()){
            return true;
        }else{
            return false;
        }



    }

    @Override
    public boolean checkBrandId(Integer id) {
        Optional<Brand> brand = brandRepository.findById(id);

        if (brand.isPresent()){
            return true;
        }else{
            return false;
        }
    }
}
