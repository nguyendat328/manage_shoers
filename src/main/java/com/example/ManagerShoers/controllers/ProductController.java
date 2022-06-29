package com.example.ManagerShoers.controllers;

import com.example.ManagerShoers.dao.entity.Product;
import com.example.ManagerShoers.dao.model.ProductCreateModel;
import com.example.ManagerShoers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create")
    public ResponseEntity<Product> create(@RequestBody ProductCreateModel product){

        if (productService.checkTypeId(product.getTypeId()) == true && productService.checkBrandId(product.getBrandId())== true){
            return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value="")
    public  ResponseEntity<Iterable<Product>> getAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

}
