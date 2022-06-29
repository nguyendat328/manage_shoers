package com.example.ManagerShoers.controllers;

import com.example.ManagerShoers.common.Constants;
import com.example.ManagerShoers.common.ServiceResponse;
import com.example.ManagerShoers.dao.entity.Product;
import com.example.ManagerShoers.dao.model.ProductCreateModel;
import com.example.ManagerShoers.service.ProductService;
import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create")
    public ResponseEntity<ServiceResponse<Product>> create(@RequestBody ProductCreateModel product){
        ServiceResponse<Product> response = new ServiceResponse<>();
        if (productService.checkTypeId(product.getTypeId()) == true && productService.checkBrandId(product.getBrandId())== true){


            return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
        }
        response.setCode(Constants.ERROR);
        response.setMessage(Constants.ERROR_MESSAGE);
        response.setData(null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value="")
    public  ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Product> getById(@PathVariable Integer id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ServiceResponse<Product>> updateProduct(@PathVariable Integer id, @RequestBody ProductCreateModel product){
        ServiceResponse<Product> response = new ServiceResponse<>();
        if (productService.checkBrandId(product.getBrandId())== false || productService.checkTypeId(product.getTypeId())==false){
            response.setCode(Constants.ERROR);
            response.setMessage(Constants.WARNING_BRAND_ID);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        response = productService.updateProduct(id, product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<Product> removeProduct(@PathVariable Integer id){
        return new ResponseEntity<>(productService.removeProduct(id), HttpStatus.OK);
    }


}
