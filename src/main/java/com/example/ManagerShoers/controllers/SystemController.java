package com.example.ManagerShoers.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/system")
public class SystemController {
    @GetMapping(value = "/check")
    public ResponseEntity<String> checkSystem(){
        return new ResponseEntity<>("System active", HttpStatus.OK);
    }
}
