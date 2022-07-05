package com.example.ManagerShoers.controllers;

import com.example.ManagerShoers.common.Constants;
import com.example.ManagerShoers.common.ServiceResponse;
import com.example.ManagerShoers.dao.entity.Product;
import com.example.ManagerShoers.dao.model.ProductCreateModel;
import com.example.ManagerShoers.service.ProductService;
import com.example.ManagerShoers.service.impl.FileStorageService;
import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/product")
public class ProductController {

//    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty(""));

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create")
    public ResponseEntity<ServiceResponse<Product>> create(@RequestPart("pro") ProductCreateModel product,@RequestPart("file") MultipartFile file){

        String fileName = fileStorageService.storeFile(file);
        product.setImgUrl("/uploads/" + fileName);
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();

        return fileName;
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
    public ResponseEntity<ServiceResponse<Product>> updateProduct(@PathVariable Integer id, @RequestPart("pro") ProductCreateModel product,@RequestPart("file") MultipartFile file){
        String fileName = fileStorageService.storeFile(file);
        product.setImgUrl("/uploads/" + fileName);
        return new ResponseEntity<>(productService.updateProduct(id,product), HttpStatus.OK);
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<Product> removeProduct(@PathVariable Integer id){
        return new ResponseEntity<>(productService.removeProduct(id), HttpStatus.OK);
    }

    @GetMapping("/cron")
    @Scheduled(cron = "*/10 * * * * *")
    public void scheduleTaskWithCronExpression() {
        //System.out.println("test");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime  now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        //return new ServiceResponse<Product>(Constants.CODE_CRON, Constants.MESSAGE_CRON, null);
    }


}
