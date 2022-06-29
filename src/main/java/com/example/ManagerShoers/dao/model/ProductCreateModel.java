package com.example.ManagerShoers.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductCreateModel {
    private String name;

    private Integer typeId;

    private Integer brandId;

    private String size;

    private String color;

    private String imgUrl;

    private String status;
}
